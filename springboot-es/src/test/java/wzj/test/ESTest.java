package wzj.test;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wzj.es.ESApplication;
import wzj.es.bean.Article;

import java.io.IOException;

/**
 * @ClassName ESTest
 * @Description
 * @Author wzj
 * @Date 2020/12/13 16:18
 **/
@SpringBootTest(classes = ESApplication.class)
public class ESTest {

    @Autowired
    private JestClient jestClient;

    /**
     查看es中某个索引/wzj/news的所有文档
     http://127.0.0.1:9200/wzj/news/_search
     */
    @Test
    public void contextLoads() {
        //给es中索引（保存）一个文档
        Article article = new Article();
        article.setId(1);
        article.setAuthor("wzj");
        article.setTitle("此一次");
        article.setContent("Hello world");

        //构建一个索引功能
        Index index = new Index
                .Builder(article)
                .index("wzj")
                .id("120")
                .type("news").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSearch() {
        // 查询表达式
        String json =
                "{\n"
                        + "    \"query\":{\n"
                        + "        \"match\":{\n"
                        + "            \"content\":\"hello\"\n"
                        + "        }\n"
                        + "    }\n"
                        + "}";
        //构建搜索功能
        Search search = new Search
                .Builder(json)
                .addIndex("wzj")
                .addType("news")
                .build();

        //执行搜索
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
