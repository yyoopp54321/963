package com.example.zt.service;

import com.example.zt.response.bookResponse.BookResponse;
import com.example.zt.response.bookResponse.ContentResponse;

import java.util.List;

/**
 * Author: zlp
 * Date: 2020-02-09 23:01
 * Description:
 */

public interface BookService {

    BookResponse findBookByName(String name, Integer pageNumber, Integer pageSize);

    BookResponse findBookByAuthor(String author, Integer pageNumber, Integer pageSize);

    Integer deleteBookById(Integer id);

    BookResponse getAllBooks(Integer pageNumber, Integer pageSize);

    List<ContentResponse> readBook(String str);
}
