package com.example.zt.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 书名
     */
    @Column(name = "b_name")
    private String bName;

    private String author;

    /**
     * 类别编号
     */
    @Column(name = "cate_id")
    private Integer cateId;

    @Column(name = "b_img")
    private String bImg;

    @Column(name = "b_price")
    private BigDecimal bPrice;

    /**
     * 内容
     */
    @Column(name = "b_content")
    private String bContent;

    /**
     * 简要
     */
    @Column(name = "b_brief")
    private String bBrief;

    /**
     * 评论
     */
    private Integer comments;

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
     * 获取书名
     *
     * @return b_name - 书名
     */
    public String getbName() {
        return bName;
    }

    /**
     * 设置书名
     *
     * @param bName 书名
     */
    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 获取类别编号
     *
     * @return cate_id - 类别编号
     */
    public Integer getCateId() {
        return cateId;
    }

    /**
     * 设置类别编号
     *
     * @param cateId 类别编号
     */
    public void setCateId(Integer cateId) {
        this.cateId = cateId;
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
     * 获取内容
     *
     * @return b_content - 内容
     */
    public String getbContent() {
        return bContent;
    }

    /**
     * 设置内容
     *
     * @param bContent 内容
     */
    public void setbContent(String bContent) {
        this.bContent = bContent == null ? null : bContent.trim();
    }

    /**
     * 获取简要
     *
     * @return b_brief - 简要
     */
    public String getbBrief() {
        return bBrief;
    }

    /**
     * 设置简要
     *
     * @param bBrief 简要
     */
    public void setbBrief(String bBrief) {
        this.bBrief = bBrief == null ? null : bBrief.trim();
    }

    /**
     * 获取评论
     *
     * @return comments - 评论
     */
    public Integer getComments() {
        return comments;
    }

    /**
     * 设置评论
     *
     * @param comments 评论
     */
    public void setComments(Integer comments) {
        this.comments = comments;
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