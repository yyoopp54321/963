package com.example.zt.dao;

import com.example.zt.mapper.CollectionMapper;
import com.example.zt.pojo.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;


import java.util.List;

@Repository
public class CollectionDao {
    @Autowired
    CollectionMapper collectionMapper;
    public Integer addCollection(Collection collection){
        return collectionMapper.insert(collection);
    }
    public Integer deleteCollection(Integer id){
        return collectionMapper.deleteByPrimaryKey(id);
    }
    public Integer deleteCollectionList(List<Integer> ids){
        Example example=new Example(Collection.class);
        example.createCriteria().andEqualTo("id",ids);
        return  collectionMapper.deleteByExample(example);
    }
    public List<Collection> findCollectionByUserId(Integer uId){
        Example example=new Example(Collection.class);
        example.createCriteria().andEqualTo("uId",uId);
        return collectionMapper.selectByExample(example);
    }
}
