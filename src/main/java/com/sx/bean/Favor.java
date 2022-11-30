package com.sx.bean;

public class Favor {
    //主键
    private String id;
    //商品id
    private String goodId;
    //用户id
    private String userId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGoodId() {
    return goodId;
  }

  public void setGoodId(String goodId) {
    this.goodId = goodId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
