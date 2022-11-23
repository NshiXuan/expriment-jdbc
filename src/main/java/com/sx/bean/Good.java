package com.sx.bean;

public class Good extends BaseBean {
  private String goodName;
  private String goodPrice;
  private String goodImg;

  public String getGoodName() {
    return goodName;
  }

  public void setGoodName(String goodName) {
    this.goodName = goodName;
  }

  public String getGoodPrice() {
    return goodPrice;
  }

  public void setGoodPrice(String goodPrice) {
    this.goodPrice = goodPrice;
  }

  public String getGoodImg() {
    return goodImg;
  }

  public void setGoodImg(String goodImg) {
    this.goodImg = goodImg;
  }

  @Override
  public String toString() {
    return "Good{" +
            "id='" + getId() + '\'' +
            "goodName='" + goodName + '\'' +
            ", goodPrice='" + goodPrice + '\'' +
            ", goodImg='" + goodImg + '\'' +
            '}';
  }
}
