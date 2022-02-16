package com.zeng.store.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/14/12:57
 * @Description:
 */

import java.util.Date;

/**产品分类实体类*/
public class proCategory extends BaseEntity{
    private Integer id;
    private Integer parentId;
    private String name;
    private Integer status;
   private Integer sortOrder;
    private Integer isParent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof proCategory)) return false;
        if (!super.equals(o)) return false;

        proCategory that = (proCategory) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getParentId() != null ? !getParentId().equals(that.getParentId()) : that.getParentId() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getSortOrder() != null ? !getSortOrder().equals(that.getSortOrder()) : that.getSortOrder() != null)
            return false;
        return getIsParent() != null ? getIsParent().equals(that.getIsParent()) : that.getIsParent() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getParentId() != null ? getParentId().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getSortOrder() != null ? getSortOrder().hashCode() : 0);
        result = 31 * result + (getIsParent() != null ? getIsParent().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "proCategory{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", sortOrder=" + sortOrder +
                ", isParent=" + isParent +
                '}';
    }
}
