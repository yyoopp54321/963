package com.example.zt.dao;

import com.example.zt.mapper.BookMapper;
import com.example.zt.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class BookDao {
    @Autowired
    BookMapper bookMapper;
    public Integer updateBook(Book book){
        return bookMapper.updateByPrimaryKey(book);
    }
    public Book findBookById(Integer id){
        return bookMapper.selectByPrimaryKey(id);
    }

    public List<Book> findBookByName(String name) {
        Example example = new Example(Book.class);
        example.createCriteria().andLike("bName", "%" + name + "%");
        return bookMapper.selectByExample(example);
    }

    //通过作者查找书籍
    public List<Book> findBookByAuthor(String author){
        Example example = new Example(Book.class);
        example.createCriteria().andLike("author","%"+author+"%");
        return bookMapper.selectByExample(example);
    }

    //删除书籍
    public Integer deleteBookById(Integer id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    //获取全部书籍
    public List<Book> getAllBooks(){
        return bookMapper.selectAll();
    }

    //阅读书籍
    public Integer readBook(Integer flag)
    {
        return 1;
    }
}
