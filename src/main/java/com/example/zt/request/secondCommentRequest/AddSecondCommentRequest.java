package com.example.zt.request.secondCommentRequest;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class AddSecondCommentRequest {
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "comment_content")
    private String commentContent;



}
