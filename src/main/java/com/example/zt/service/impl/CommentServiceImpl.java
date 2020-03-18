package com.example.zt.service.impl;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.dao.BookDao;
import com.example.zt.dao.CommentDao;
import com.example.zt.dao.SecondCommentDao;
import com.example.zt.pojo.Book;
import com.example.zt.pojo.Comment;
import com.example.zt.pojo.SecondComment;
import com.example.zt.request.commentRequest.AddCommentRequest;
import com.example.zt.request.commentRequest.UpdateCommentRequest;
import com.example.zt.response.commentResponse.FindCommentResponse;
import com.example.zt.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    SecondCommentDao secondCommentDao;

    @Override
    public SzpJsonResult addComment(AddCommentRequest Request) {
        Comment comment = new Comment();
        comment.setBookId(Request.getBookId());
        comment.setUserId(Request.getUserId());
        comment.setCommentContent(Request.getCommentContent());
        comment.setCreateTime(new Date());
        Integer integer = commentDao.addComment(comment);
        if (integer==1){
            addBookComments(Request.getBookId());
            return SzpJsonResult.ok();
        }
        return SzpJsonResult.errorException("添加失败");
    }

    private void addBookComments(Integer id) {
        Book book = bookDao.findBookById(id);
        book.setComments(book.getComments()+1);
        bookDao.updateBook(book);

    }
    @Override
    public SzpJsonResult deleteCommentById(Integer id) {
        Integer integer = commentDao.deleteCommentById(id);
        if (integer==1){
            List<SecondComment> secondComments = secondCommentDao.FindSecondComment(id);
            for (int i=0;i<secondComments.size();i++) {
                secondCommentDao.deleteSecondComment(secondComments.get(i).getId());
            }
            Comment oneComment = commentDao.findOneComment(id);
            Book book = bookDao.findBookById(oneComment.getBookId());
            book.setComments(book.getComments()-1-secondComments.size());
            bookDao.updateBook(book);
            return SzpJsonResult.ok();
        }
        return SzpJsonResult.errorException("删除失败");
     
    }

    @Override
    public SzpJsonResult updateComment(UpdateCommentRequest request) {
        Comment comment = new Comment();
        comment.setCommentContent(request.getCommentContent());
        comment.setUpdateTime(new Date());
        Integer integer = commentDao.updateComment(comment);
        if (integer==1){
            return SzpJsonResult.ok();
        }
        return SzpJsonResult.errorException("更新失败");
    }

    @Override
    public List<FindCommentResponse> findComment(Integer bookId) {
        List<Comment> list = commentDao.findComment(bookId);
        return showCommentAll(list);
    }
    private List<FindCommentResponse> showCommentAll(List<Comment> commentList){
        List<FindCommentResponse> list=new ArrayList<>();
        for (Comment comment:commentList){
            FindCommentResponse findCommentResponse = new FindCommentResponse();
            BeanUtils.copyProperties(comment,findCommentResponse);
            list.add(findCommentResponse);
        }
        return list;
    }
}
