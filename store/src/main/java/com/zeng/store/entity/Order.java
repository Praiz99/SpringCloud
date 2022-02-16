package com.zeng.store.entity;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/10/21:24
 * @Description:
 */
/**订单实体类*/
public class Order extends BaseEntity{
    private Integer oid;
    private  Integer uid;
    private  Long totalPrice;//订单总价格
    private Integer status;//'状态：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成'
    private Date orderTime;//下单时间
    private Date payTime;//支付时间
    //一个订单对应着一个收货地址
    private Address recvAddress;
    //一个订单对应着多个商品详情
    private List<OrderItem> orderItems;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Address getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(Address recvAddress) {
        this.recvAddress = recvAddress;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;

        Order order = (Order) o;

        if (getOid() != null ? !getOid().equals(order.getOid()) : order.getOid() != null) return false;
        if (getUid() != null ? !getUid().equals(order.getUid()) : order.getUid() != null) return false;
        if (getTotalPrice() != null ? !getTotalPrice().equals(order.getTotalPrice()) : order.getTotalPrice() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(order.getStatus()) : order.getStatus() != null) return false;
        if (getOrderTime() != null ? !getOrderTime().equals(order.getOrderTime()) : order.getOrderTime() != null)
            return false;
        if (getPayTime() != null ? !getPayTime().equals(order.getPayTime()) : order.getPayTime() != null) return false;
        if (getRecvAddress() != null ? !getRecvAddress().equals(order.getRecvAddress()) : order.getRecvAddress() != null)
            return false;
        return getOrderItems() != null ? getOrderItems().equals(order.getOrderItems()) : order.getOrderItems() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getOid() != null ? getOid().hashCode() : 0);
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getTotalPrice() != null ? getTotalPrice().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getOrderTime() != null ? getOrderTime().hashCode() : 0);
        result = 31 * result + (getPayTime() != null ? getPayTime().hashCode() : 0);
        result = 31 * result + (getRecvAddress() != null ? getRecvAddress().hashCode() : 0);
        result = 31 * result + (getOrderItems() != null ? getOrderItems().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", orderTime=" + orderTime +
                ", payTime=" + payTime +
                ", recvAddress=" + recvAddress +
                ", orderItems=" + orderItems +
                '}';
    }
}
