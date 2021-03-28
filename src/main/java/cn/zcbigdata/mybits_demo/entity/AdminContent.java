package cn.zcbigdata.mybits_demo.entity;

public class AdminContent {
    private String content;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AdminContent{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }



}
