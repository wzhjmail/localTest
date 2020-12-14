package wzj.es.config;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName JestClient
 * @Description
 * @Author wzj
 * @Date 2020/12/13 17:28
 **/
@Configuration
public class MyJestClientConfig {

    @Bean
    public JestClient jestClint() {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .multiThreaded(true)
                .build());
        return factory.getObject();
    }

}
