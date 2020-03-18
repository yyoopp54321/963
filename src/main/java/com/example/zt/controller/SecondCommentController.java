package com.example.zt.controller;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.pojo.User;
import com.example.zt.request.secondCommentRequest.AddSecondCommentRequest;
import com.example.zt.request.secondCommentRequest.UpdateSecondCommentRequest;
import com.example.zt.response.secondCommentResponse.FindSecondCommentResponse;
import com.example.zt.service.SecondCommentService;
import com.example.zt.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecondCommentController {
    @Autowired
    SecondCommentService secondCommentService;
    @PutMapping(value = "add/secondComment")
    public SzpJsonResult addSecondComment(@RequestBody AddSecondCommentRequest request){
        User currentUser = SessionUtil.getUser();
        if (null == currentUser) {
            return SzpJsonResult.errorException("请先登录");
        }
        return secondCommentService.addSecondComment(request);
    }
    @DeleteMapping(value = "delete/secondComment")
    public  SzpJsonResult deleteSecondCommentById(@RequestParam Integer id){
        User currentUser = SessionUtil.getUser();
        if (null == currentUser) {
            return SzpJsonResult.errorException("请先登录");
        }
        return  secondCommentService.deleteSecondCommentById(id);
    }
    @PutMapping(value = "update/secondComment")
    public SzpJsonResult  updateSecondComment(@RequestBody UpdateSecondCommentRequest request){
        User currentUser = SessionUtil.getUser();
        if (null == currentUser) {
            return SzpJsonResult.errorException("请先登录");
        }
        return secondCommentService.updateSecondComment(request);
    }
    @GetMapping(value = "find/secondComment")
    public List<FindSecondCommentResponse> findSecondComment(@RequestParam Integer commentId){

        return secondCommentService.findSecondComment(commentId);
    }
}
