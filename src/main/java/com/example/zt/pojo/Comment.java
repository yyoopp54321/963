package com.example.zt.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "write_id")
    private Integer writeId;

    @Column(name = "receive_id")
    private Integer receiveId;

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
     * @return comment_content
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * @param commentContent
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    /**
     * @return write_id
     */
    public Integer getWriteId() {
        return writeId;
    }

    /**
     * @param writeId
     */
    public void setWriteId(Integer writeId) {
        this.writeId = writeId;
    }

    /**
     * @return receive_id
     */
    public Integer getReceiveId() {
        return receiveId;
    }

    /**
     * @param receiveId
     */
    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
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