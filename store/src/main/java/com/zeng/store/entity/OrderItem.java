package com.zeng.store.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/10/21:33
 * @Description:
 */
/**订单中对应的商品详情实体类*/
public class OrderItem extends BaseEntity{
    private Integer id;
    private Integer oid;
    private Integer num;
    //一个商品详情对应着一个商品实体
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        if (!super.equals(o)) return false;

        OrderItem orderItem = (OrderItem) o;

        if (getId() != null ? !getId().equals(orderItem.getId()) : orderItem.getId() != null) return false;
        if (getOid() != null ? !getOid().equals(orderItem.getOid()) : orderItem.getOid() != null) return false;
        if (getNum() != null ? !getNum().equals(orderItem.getNum()) : orderItem.getNum() != null) return false;
        return getProduct() != null ? getProduct().equals(orderItem.getProduct()) : orderItem.getProduct() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getOid() != null ? getOid().hashCode() : 0);
        result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
        result = 31 * result + (getProduct() != null ? getProduct().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", oid=" + oid +
                ", num=" + num +
                ", product=" + product +
                '}';
    }
}
