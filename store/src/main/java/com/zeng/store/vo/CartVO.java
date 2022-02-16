package com.zeng.store.vo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/08/17:17
 * @Description:
 */

import org.omg.PortableInterceptor.INACTIVE;

/**购物车数据的VO类*/
public class CartVO {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private String image;
    private String title;
    private Long price;
    private Long realPrice;
    private Integer num;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Long realPrice) {
        this.realPrice = realPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartVO)) return false;

        CartVO cartVO = (CartVO) o;

        if (getCid() != null ? !getCid().equals(cartVO.getCid()) : cartVO.getCid() != null) return false;
        if (getUid() != null ? !getUid().equals(cartVO.getUid()) : cartVO.getUid() != null) return false;
        if (getPid() != null ? !getPid().equals(cartVO.getPid()) : cartVO.getPid() != null) return false;
        if (getImage() != null ? !getImage().equals(cartVO.getImage()) : cartVO.getImage() != null) return false;
        if (getTitle() != null ? !getTitle().equals(cartVO.getTitle()) : cartVO.getTitle() != null) return false;
        if (getPrice() != null ? !getPrice().equals(cartVO.getPrice()) : cartVO.getPrice() != null) return false;
        if (getRealPrice() != null ? !getRealPrice().equals(cartVO.getRealPrice()) : cartVO.getRealPrice() != null)
            return false;
        return getNum() != null ? getNum().equals(cartVO.getNum()) : cartVO.getNum() == null;
    }

    @Override
    public int hashCode() {
        int result = getCid() != null ? getCid().hashCode() : 0;
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getPid() != null ? getPid().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getRealPrice() != null ? getRealPrice().hashCode() : 0);
        result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", realPrice=" + realPrice +
                ", num=" + num +
                '}';
    }
}
