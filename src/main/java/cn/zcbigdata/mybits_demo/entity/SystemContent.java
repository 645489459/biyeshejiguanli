package cn.zcbigdata.mybits_demo.entity;

//系统公告表
public class SystemContent {

  private long id;
  private String content;


  public long getId() {
    return id;
  }

  public void setId(long id) {
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
    return "SystemContent{" +
            "id=" + id +
            ", content='" + content + '\'' +
            '}';
  }
}
