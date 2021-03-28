package cn.zcbigdata.mybits_demo.entity;

/**学生选题连表
 * @author admin
 */
public class StudentTitleVo {
    private Long stuTitleId;
    private String name;
    private String sno;
    private String cno;
    private String content;//学生选择的毕设题目
    private String status;//状态

    public Long getStuTitleId() {
        return stuTitleId;
    }

    public void setStuTitleId(Long stuTitleId) {
        this.stuTitleId = stuTitleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentTitleVo{" +
                "stuTitleId=" + stuTitleId +
                ", name='" + name + '\'' +
                ", sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
