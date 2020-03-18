package com.example.zt.request.secondCommentRequest;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class UpdateSecondCommentRequest {

    @Column(name = "comment_content")
    private String commentContent;

}
