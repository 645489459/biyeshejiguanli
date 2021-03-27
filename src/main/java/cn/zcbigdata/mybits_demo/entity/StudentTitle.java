package cn.zcbigdata.mybits_demo.entity;


public class StudentTitle {

  private long id;
  private String sno;
  private String content;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getSno() {
    return sno;
  }

  public void setSno(String sno) {
    this.sno = sno;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "StudentTitle{" +
            "id=" + id +
            ", sno='" + sno + '\'' +
            ", content='" + content + '\'' +
            '}';
  }
}
