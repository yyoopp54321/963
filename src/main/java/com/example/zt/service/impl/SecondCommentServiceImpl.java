package com.example.zt.service.impl;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.dao.BookDao;
import com.example.zt.dao.CommentDao;
import com.example.zt.dao.SecondCommentDao;
import com.example.zt.pojo.Book;
import com.example.zt.pojo.Comment;
import com.example.zt.pojo.SecondComment;
import com.example.zt.request.secondCommentRequest.AddSecondCommentRequest;
import com.example.zt.request.secondCommentRequest.UpdateSecondCommentRequest;

import com.example.zt.response.secondCommentResponse.FindSecondCommentResponse;
import com.example.zt.service.SecondCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SecondCommentServiceImpl implements SecondCommentService {
    @Autowired
    SecondCommentDao secondCommentDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    CommentDao commentDao;
    @Override
    public SzpJsonResult addSecondComment(AddSecondCommentRequest request) {
        SecondComment secondComment = new SecondComment();
        secondComment.setCommentContent(request.getCommentContent());
        secondComment.setCommentId(request.getCommentId());
        secondComment.setUserId(request.getUserId());
        secondComment.setCreateTime(new Date());
        Integer integer = secondCommentDao.addSecondComment(secondComment);
        if (integer==1){
            addCommentComments(request.getCommentId());
            return SzpJsonResult.ok(integer);
        }
        return SzpJsonResult.errorException("添加失败");
    }

    private void addCommentComments(Integer id) {
        Comment oneComment = commentDao.findOneComment(id);
        oneComment.setComments(oneComment.getComments()+1);
        commentDao.updateComment(oneComment);
        Book book = bookDao.findBookById(oneComment.getBookId());
        book.setComments(book.getComments()+1);
        bookDao.updateBook(book);
    }


    @Override
    public SzpJsonResult deleteSecondCommentById(Integer id) {
        Integer integer = secondCommentDao.deleteSecondComment(id);
        if (integer==1){
            return SzpJsonResult.ok();
        }
        return SzpJsonResult.errorException("删除失败");

    }


    @Override
    public SzpJsonResult updateSecondComment(UpdateSecondCommentRequest request) {
        SecondComment secondComment = new SecondComment();
        secondComment.setCommentContent(request.getCommentContent());
        secondComment.setUpdateTime(new Date());
        Integer integer = secondCommentDao.updateSecondComment(secondComment);
        if (integer==1){
            return SzpJsonResult.ok();
        }
        return SzpJsonResult.errorException("更新失败");
    }

    @Override
    public List<FindSecondCommentResponse> findSecondComment(Integer commentId) {
        List<SecondComment> secondComments = secondCommentDao.FindSecondComment(commentId);
       return showSecondCommentAll(secondComments);

    }
    private List<FindSecondCommentResponse> showSecondCommentAll(List<SecondComment> secondComments){
        List<FindSecondCommentResponse> list=new ArrayList<>();
        for (SecondComment comment:secondComments){
            FindSecondCommentResponse findSecondCommentResponse = new FindSecondCommentResponse();
            BeanUtils.copyProperties(comment,findSecondCommentResponse);
            list.add(findSecondCommentResponse);
        }
        return list;
    }
}
