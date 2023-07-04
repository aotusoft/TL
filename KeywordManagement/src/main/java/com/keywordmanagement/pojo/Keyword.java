package com.keywordmanagement.pojo;


public class Keyword {

  private long id;
  private String name;
  private String type;
  private java.sql.Date createDate;


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


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public java.sql.Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Date createDate) {
    this.createDate = createDate;
  }

}
