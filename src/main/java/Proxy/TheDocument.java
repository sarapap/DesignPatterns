package Proxy;

import java.util.Date;

public class TheDocument implements Document {
    private String content;
    public Date date;
    public String id;

    public TheDocument(String id, String content) {
        this.id = id;
        this.content = content;
        this.date = new Date();
    }

    @Override
    public String getContent(User user) {
        return content;
    }

    @Override
    public Date getDate() {
        return date;
    }

    public String getId() {
        return id;
    }
}
