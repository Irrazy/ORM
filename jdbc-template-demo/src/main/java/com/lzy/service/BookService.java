package com.lzy.service;

import com.lzy.pojo.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    //增加
    public String insert(Book book);

    //批量插入
    public String insertList(List<Object[]> list);

    //改1
    public String update1(Book book,Long id);
    //改2
    public String update2(Object[] objects);

    //查ById
    public Book select(Long bid);

    //查所有
    public List<Book> selectAll();

    //聚合查询
    public List<Map<String, Object>> selectBooks2(Object[] objects);

}
