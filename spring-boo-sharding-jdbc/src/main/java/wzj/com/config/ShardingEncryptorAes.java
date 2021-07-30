package wzj.com.config;

import org.apache.shardingsphere.encrypt.strategy.spi.Encryptor;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName ShardingEncryptorAes
 * @Description
 * @Author wzj
 * @Date 2021/7/5 16:30
 **/

public class ShardingEncryptorAes implements Encryptor {

    private static final String AES_PROPERTIES = "aes.properties";

    private Properties properties;

    @Override
    public void init() {
        try {
            properties = PropertiesLoaderUtils.loadAllProperties(AES_PROPERTIES);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("aes秘钥配置文件读取失败", e);
        }
    }

    @Override
    public String encrypt(Object o) {
        if (o == null) {
            return null;
        }
        //AES aes = SecureUtil.aes(getKey().getBytes());
        //return aes.encryptHex((String) o);
        return "<" + (String) o + ">";
    }

    @Override
    public Object decrypt(String str) {
        /*AES aes = SecureUtil.aes(getKey().getBytes());
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return aes.decryptStr(str);*/
        return str.substring(1, str.length() - 1);
    }

    //@Override
    public String getType() {
        return "myaes";
    }

    //@Override
    public Properties getProperties() {
        return properties;
    }

    //@Override
    public void setProperties(Properties properties) {

    }

    private String getKey() {
        return getProperties().getProperty("aesKey");
    }
}