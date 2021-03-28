package cn.zcbigdata.mybits_demo.entity;

public class ReportPaperVo {
    private long ope_title_id;
    private String sno;
    private String name;
    private String cno;
    private String content;//开题报告内容
    private String remark;//教师评语
    private String status;//状态

    public long getOpe_title_id() {
        return ope_title_id;
    }

    public void setOpe_title_id(long ope_title_id) {
        this.ope_title_id = ope_title_id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "OpeningReportVo{" +
                "ope_title_id=" + ope_title_id +
                ", sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", cno='" + cno + '\'' +
                ", content='" + content + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
