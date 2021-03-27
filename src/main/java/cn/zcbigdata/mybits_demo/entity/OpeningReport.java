package cn.zcbigdata.mybits_demo.entity;

//开题报告表
public class OpeningReport {

  private long id;
  private String sno;
  private String content;//开题报告内容
  private String remark;//教师评语


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


  public String getCnotent() {
    return content;
  }

  public void setCnotent(String cnotent) {
    this.content = cnotent;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public String toString() {
    return "OpeningReport{" +
            "id=" + id +
            ", sno='" + sno + '\'' +
            ", cnotent='" + content + '\'' +
            ", remark='" + remark + '\'' +
            '}';
  }
}
