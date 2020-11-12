package com.common;
/**
 *
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

@Slf4j
public class HttpclientUtils {
//    private static Logger logger = LoggerFactory.getLogger(HttpclientUtils.class);

    public static final int DEFAULT_SOCKET_TIMEOUT = 5000;
    public static final int DEFAULT_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_CONNECTION_REQUEST_TIMEOUT = 5000;
    public static final int DEFAULT_SOCKET_PRINT_TIMEOUT = 30000;
    public static final int DEFAULT_CONNECT_PRINT_TIMEOUT = 30000;
    public static final int DEFAULT_CONNECTION_PRINT_REQUEST_TIMEOUT = 30000;
//    private static final String DEFAULT_AGENT = "MEICAI/PSPMC";
    private static CloseableHttpClient httpClient;

    static {
        //https config
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = null;
        try {
            sslContext = org.apache.http.ssl.SSLContexts.custom()
                    .loadTrustMaterial(null, acceptingTrustStrategy)
                    .build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext
                , null, null, NoopHostnameVerifier.INSTANCE);

        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", csf)
                .build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        //最大连接数3000
        connectionManager.setMaxTotal(100);
        //路由链接数400
        connectionManager.setDefaultMaxPerRoute(100);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(2000)
                .setConnectionRequestTimeout(1000)
                .build();


        httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .evictExpiredConnections()
                .evictIdleConnections(30, TimeUnit.SECONDS)
                .build();
    }

    public static String postJsonWithTimeOut(String url, String jsonEntity, int timeout) throws IOException {
        long start = System.currentTimeMillis();
        //建立Request的对象，一般用目标url来构造，Request一般配置addHeader、setEntity、setConfig
        HttpPost req = new HttpPost(url);
        //setConfig,添加配置,如设置请求超时时间,连接超时时间
        RequestConfig reqConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(1000).build();
        req.setConfig(reqConfig);
        req.setHeader("Content-Type", "application/json;charset=UTF-8");
        //setEntity,添加内容
        req.setEntity(new StringEntity(jsonEntity, Charset.forName("UTF-8")));
        //执行Request请求,CloseableHttpClient的execute方法返回的response都是CloseableHttpResponse类型
        //其常用方法有getFirstHeader(String)、getLastHeader(String)、headerIterator（String）取得某个Header name对应的迭代器、getAllHeaders()、getEntity、getStatus等
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(req);
            //用EntityUtils.toString()这个静态方法将HttpEntity转换成字符串,防止服务器返回的数据带有中文,所以在转换的时候将字符集指定成utf-8就可以了
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            log.info("http {} cost:{},req:{},resp:{}", url, System.currentTimeMillis() - start, jsonEntity, result);
            return result;
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    public static String get(String url) throws IOException {
        long start = System.currentTimeMillis();
        String result = "";
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse httpResponse = null;
        httpResponse = httpClient.execute(get);
        try {
            HttpEntity entity = httpResponse.getEntity();
            if (null != entity) {
                result = EntityUtils.toString(entity);
            }
        } finally {
            httpResponse.close();
        }
        log.info("http {} cost:{},resp:{}", url, System.currentTimeMillis() - start, result);
        return result;
    }

}
