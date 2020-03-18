package com.example.zt.request.commentRequest;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
@Data
public class AddCommentRequest {
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "comment_content")
    private String commentContent;


}
