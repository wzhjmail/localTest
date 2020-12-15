package wzj.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import wzj.es.bean.Book;

import java.util.List;

/**
 * @ClassName BookRepository
 * @Description
 * @Author wzj
 * @Date 2020/12/14 18:14
 **/

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    // 参照springboot中的elasticsearch：
    // https://docs.spring.io/spring-data/elasticsearch/docs/4.1.2/reference/html/#elasticsearch.repositories
    public List<Book> findByBookNameLike(String bookName);

}
