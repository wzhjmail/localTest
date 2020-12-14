package wzj.es.bean;

import java.io.Serializable;

/**
 * @ClassName Aritcle
 * @Description
 * @Author wzj
 * @Date 2020/12/13 16:29
 **/

public class Article implements Serializable {

    int id;
    String title;
    String author;
    String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
