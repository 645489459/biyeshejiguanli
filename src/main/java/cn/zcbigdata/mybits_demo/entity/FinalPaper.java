package cn.zcbigdata.mybits_demo.entity;


public class FinalPaper {

  private long id;
  private String sno;
  private String cnotent;
  private String remark;


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
    return cnotent;
  }

  public void setCnotent(String cnotent) {
    this.cnotent = cnotent;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public String toString() {
    return "FinalPaper{" +
            "id=" + id +
            ", sno='" + sno + '\'' +
            ", cnotent='" + cnotent + '\'' +
            ", remark='" + remark + '\'' +
            '}';
  }
}
