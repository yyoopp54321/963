package com.example.zt.response.commentResponse;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class FindCommentResponse {
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "comment_content")
    private String commentContent;

    private Integer comments;

    @Column(name = "create_time")
    private Date createTime;
}
