package cn.zcbigdata.mybits_demo.entity;


public class Admin {

  private long id;
  private String name;
  private String password;
  private String con;
  private String flag;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getCon() {
    return con;
  }

  public void setCon(String con) {
    this.con = con;
  }


  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  @Override
  public String toString() {
    return "Admin{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", con='" + con + '\'' +
            ", flag='" + flag + '\'' +
            '}';
  }
}
