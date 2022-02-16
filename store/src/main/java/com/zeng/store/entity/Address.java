package com.zeng.store.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/04/19:40
 * @Description:
 */

import java.io.Serializable;

/**收货地址实体类*/
public class Address extends BaseEntity implements Serializable {
    private Integer aid;//收货地址id
    private Integer uid;//归属的用户id
    private String name;//收货人姓名
    private String provinceName;//省-名称
    private String provinceCode;//省-行政代号
    private String cityName;//市-名称
    private String cityCode;//市-行政代号
    private String areaName;//区-名称
    private String areaCode;// 区-行政代号
    private String zip;//邮政编码
    private String address;//详细地址
    private String phone;//手机
    private String tel;//固话
    private String tag;//标签
    private Integer isDefault;//是否默认地址 0-不默认 1-默认

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }



    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        if (!super.equals(o)) return false;

        Address address1 = (Address) o;

        if (getAid() != null ? !getAid().equals(address1.getAid()) : address1.getAid() != null) return false;
        if (getUid() != null ? !getUid().equals(address1.getUid()) : address1.getUid() != null) return false;
        if (getName() != null ? !getName().equals(address1.getName()) : address1.getName() != null) return false;
        if (getProvinceName() != null ? !getProvinceName().equals(address1.getProvinceName()) : address1.getProvinceName() != null)
            return false;
        if (getProvinceCode() != null ? !getProvinceCode().equals(address1.getProvinceCode()) : address1.getProvinceCode() != null)
            return false;
        if (getCityName() != null ? !getCityName().equals(address1.getCityName()) : address1.getCityName() != null)
            return false;
        if (getCityCode() != null ? !getCityCode().equals(address1.getCityCode()) : address1.getCityCode() != null)
            return false;
        if (getAreaName() != null ? !getAreaName().equals(address1.getAreaName()) : address1.getAreaName() != null)
            return false;
        if (getAreaCode() != null ? !getAreaCode().equals(address1.getAreaCode()) : address1.getAreaCode() != null)
            return false;
        if (getZip() != null ? !getZip().equals(address1.getZip()) : address1.getZip() != null) return false;
        if (getAddress() != null ? !getAddress().equals(address1.getAddress()) : address1.getAddress() != null)
            return false;
        if (getPhone() != null ? !getPhone().equals(address1.getPhone()) : address1.getPhone() != null) return false;
        if (getTel() != null ? !getTel().equals(address1.getTel()) : address1.getTel() != null) return false;
        if (getTag() != null ? !getTag().equals(address1.getTag()) : address1.getTag() != null) return false;
        return getIsDefault() != null ? getIsDefault().equals(address1.getIsDefault()) : address1.getIsDefault() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getAid() != null ? getAid().hashCode() : 0);
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getProvinceName() != null ? getProvinceName().hashCode() : 0);
        result = 31 * result + (getProvinceCode() != null ? getProvinceCode().hashCode() : 0);
        result = 31 * result + (getCityName() != null ? getCityName().hashCode() : 0);
        result = 31 * result + (getCityCode() != null ? getCityCode().hashCode() : 0);
        result = 31 * result + (getAreaName() != null ? getAreaName().hashCode() : 0);
        result = 31 * result + (getAreaCode() != null ? getAreaCode().hashCode() : 0);
        result = 31 * result + (getZip() != null ? getZip().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getTel() != null ? getTel().hashCode() : 0);
        result = 31 * result + (getTag() != null ? getTag().hashCode() : 0);
        result = 31 * result + (getIsDefault() != null ? getIsDefault().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", areaName='" + areaName + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", zip='" + zip + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", tag='" + tag + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}
