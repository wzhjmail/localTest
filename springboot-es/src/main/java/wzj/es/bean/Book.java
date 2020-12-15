package wzj.es.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ClassName Book
 * @Description
 * @Author wzj
 * @Date 2020/12/14 18:15
 **/
//6.0版本后，一个index只有一个type了,这里type也被移除。ES默认type为“_doc”
@Document(indexName = "wzj", type = "bk")
public class Book {
    Integer id;
    String bookName;
    String author;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
