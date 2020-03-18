package com.example.zt.response.secondCommentResponse;

import lombok.Data;

import javax.persistence.Column;

@Data
public class FindSecondCommentResponse {
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "comment_content")
    private String commentContent;

}
