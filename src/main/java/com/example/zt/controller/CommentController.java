package com.example.zt.controller;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.pojo.User;
import com.example.zt.request.commentRequest.AddCommentRequest;
import com.example.zt.request.commentRequest.UpdateCommentRequest;
import com.example.zt.response.commentResponse.FindCommentResponse;
import com.example.zt.service.CommentService;
import com.example.zt.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
 @Autowired
    CommentService commentService;
    @PostMapping(value = "add/comment")
    public SzpJsonResult addComment(@RequestBody AddCommentRequest Request){
        User currentUser = SessionUtil.getUser();
        if (null == currentUser) {
            return SzpJsonResult.errorException("请先登录");
        }
        return commentService.addComment(Request);

    }
    @DeleteMapping(value = "delete/comment")
    public SzpJsonResult deleteCommentById(@RequestParam Integer id){
        User currentUser = SessionUtil.getUser();
        if (null == currentUser) {
            return SzpJsonResult.errorException("请先登录");
        }
        return commentService.deleteCommentById(id);

    }
    @PutMapping(value = "update/comment")
    public  SzpJsonResult  updateComment(@RequestBody UpdateCommentRequest request){
        User currentUser = SessionUtil.getUser();
        if (null == currentUser) {
            return SzpJsonResult.errorException("请先登录");
        }
        return commentService.updateComment(request);
    }
    @GetMapping(value = "find/comment")
    public List<FindCommentResponse> findComment(@RequestParam Integer bookId){
        return commentService.findComment(bookId);
    }
}
