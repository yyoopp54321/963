package com.example.zt.dao;

import com.example.zt.mapper.SecondCommentMapper;
import com.example.zt.pojo.SecondComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class SecondCommentDao {
    @Autowired
    SecondCommentMapper secondCommentMapper;
    //增
    public Integer addSecondComment(SecondComment secondComment){
        return  secondCommentMapper.insert(secondComment);
    }
    //删
    public  Integer deleteSecondComment(Integer id){
        return secondCommentMapper.deleteByPrimaryKey(id);
    }

    //改
    public Integer updateSecondComment(SecondComment secondComment){
        return secondCommentMapper.updateByPrimaryKey(secondComment);
    }
    //查
    public List<SecondComment> FindSecondComment(Integer commentId){
        Example example=new Example(SecondComment.class);
        example.createCriteria().andEqualTo("commentId",commentId);
        return secondCommentMapper.selectByExample(example);
    }
}
