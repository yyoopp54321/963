package com.example.zt.mapper;

import com.example.zt.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends CommonMapper<Book> {
}