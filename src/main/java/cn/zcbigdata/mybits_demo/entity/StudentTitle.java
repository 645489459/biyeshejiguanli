package cn.zcbigdata.mybits_demo.entity;

//学生选题表
public class StudentTitle {

  private long id;
  private String sno;
  private String content;//学生选择的毕设题目
  private String status;//状态


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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "StudentTitle{" +
            "id=" + id +
            ", sno='" + sno + '\'' +
            ", content='" + content + '\'' +
            ", status='" + status + '\'' +
            '}';
  }
}
