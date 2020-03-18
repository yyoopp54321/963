package com.example.zt.service;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.request.secondCommentRequest.AddSecondCommentRequest;
import com.example.zt.request.secondCommentRequest.UpdateSecondCommentRequest;
import com.example.zt.response.secondCommentResponse.FindSecondCommentResponse;

import java.util.List;

public interface SecondCommentService {
    SzpJsonResult addSecondComment(AddSecondCommentRequest request);
    SzpJsonResult deleteSecondCommentById(Integer id);
    SzpJsonResult  updateSecondComment(UpdateSecondCommentRequest request);
    List<FindSecondCommentResponse> findSecondComment(Integer commentId);
}
