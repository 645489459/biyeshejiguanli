package cn.zcbigdata.mybits_demo.entity;

//最终论文以及教师评分表
public class FinalPaper {

  private long id;
  private String sno;
  private String content;//最终论文内容
  private String remark;//教师评分
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

  public void setContent(String cnotent) {
    this.content = cnotent;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "FinalPaper{" +
            "id=" + id +
            ", sno='" + sno + '\'' +
            ", cnotent='" + content + '\'' +
            ", remark='" + remark + '\'' +
            '}';
  }
}
