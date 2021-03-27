package cn.zcbigdata.mybits_demo.entity;

//发布的毕设题目表
public class TeacherTitle {

  private long id;
  private String cno;
  private String content;//发布的毕设题目


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
    return "FinalTitle{" +
            "id=" + id +
            ", cno='" + cno + '\'' +
            ", content='" + content + '\'' +
            '}';
  }
}
