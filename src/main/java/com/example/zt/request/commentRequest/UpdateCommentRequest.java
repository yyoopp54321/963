package com.example.zt.request.commentRequest;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
@Data
public class UpdateCommentRequest {
    @Column(name = "comment_content")
    private String commentContent;



}
