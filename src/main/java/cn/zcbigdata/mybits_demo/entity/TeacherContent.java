package cn.zcbigdata.mybits_demo.entity;

//教师公告表
public class TeacherContent {

  private long id;
  private String cno;
  private String content;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCno() {
    return cno;
  }

  public void setCno(String cno) {
    this.cno = cno;
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
            "id=" + id +
            ", cno='" + cno + '\'' +
            ", content='" + content + '\'' +
            '}';
  }
}
