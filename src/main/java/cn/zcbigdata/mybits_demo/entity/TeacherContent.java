package cn.zcbigdata.mybits_demo.entity;

public class TeacherContent {
    private String content;
    private Integer id;
    private String cno;

    public String getCno() {
        return cno;
    }
    public void setCno(String cno) {
        this.cno = cno;
    }
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
        return "TeacherContent{" +
                "content='" + content + '\'' +
                ", id=" + id +
                ", cno='" + cno + '\'' +
                '}';
    }
}
