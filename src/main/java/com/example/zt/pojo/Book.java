package com.example.zt.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "b_name")
    private String bName;

    private String author;

    @Column(name = "cate_id")
    private Integer cateId;

    @Column(name = "b_img")
    private String bImg;

    @Column(name = "b_price")
    private Double bPrice;

    @Column(name = "book_content")
    private String bookContent;

    @Column(name = "g_brief")
    private String gBrief;

    @Column(name = "g_state")
    private Short gState;

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
     * @return cate_id
     */
    public Integer getCateId() {
        return cateId;
    }

    /**
     * @param cateId
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
    public Double getbPrice() {
        return bPrice;
    }

    /**
     * @param bPrice
     */
    public void setbPrice(Double bPrice) {
        this.bPrice = bPrice;
    }

    /**
     * @return book_content
     */
    public String getBookContent() {
        return bookContent;
    }

    /**
     * @param bookContent
     */
    public void setBookContent(String bookContent) {
        this.bookContent = bookContent == null ? null : bookContent.trim();
    }

    /**
     * @return g_brief
     */
    public String getgBrief() {
        return gBrief;
    }

    /**
     * @param gBrief
     */
    public void setgBrief(String gBrief) {
        this.gBrief = gBrief == null ? null : gBrief.trim();
    }

    /**
     * @return g_state
     */
    public Short getgState() {
        return gState;
    }

    /**
     * @param gState
     */
    public void setgState(Short gState) {
        this.gState = gState;
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