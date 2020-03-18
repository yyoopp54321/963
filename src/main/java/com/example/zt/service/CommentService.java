package com.example.zt.service;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.request.commentRequest.AddCommentRequest;
import com.example.zt.request.commentRequest.UpdateCommentRequest;
import com.example.zt.response.commentResponse.FindCommentResponse;

import java.util.List;

public interface CommentService {
    SzpJsonResult addComment(AddCommentRequest Request);
    SzpJsonResult deleteCommentById(Integer id);
    SzpJsonResult  updateComment(UpdateCommentRequest request);
     List<FindCommentResponse> findComment(Integer bookId);
}
