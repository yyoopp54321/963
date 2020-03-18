package com.example.zt.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_collection")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "b_id")
    private Integer bId;

    @Column(name = "u_id")
    private Integer uId;

    @Column(name = "b_name")
    private String bName;

    @Column(name = "b_img")
    private String bImg;

    @Column(name = "b_price")
    private BigDecimal bPrice;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return b_id
     */
    public Integer getbId() {
        return bId;
    }

    /**
     * @param bId
     */
    public void setbId(Integer bId) {
        this.bId = bId;
    }

    /**
     * @return u_id
     */
    public Integer getuId() {
        return uId;
    }

    /**
     * @param uId
     */
    public void setuId(Integer uId) {
        this.uId = uId;
    }

    /**
     * @return b_name
     */
    public String getbName() {
        return bName;
    }

    /**
     * @param bName
     */
    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    /**
     * @return b_img
     */
    public String getbImg() {
        return bImg;
    }

    /**
     * @param bImg
     */
    public void setbImg(String bImg) {
        this.bImg = bImg == null ? null : bImg.trim();
    }

    /**
     * @return b_price
     */
    public BigDecimal getbPrice() {
        return bPrice;
    }

    /**
     * @param bPrice
     */
    public void setbPrice(BigDecimal bPrice) {
        this.bPrice = bPrice;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}