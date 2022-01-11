package com.lzy.controller;

import com.lzy.pojo.Book;
import com.lzy.serviceImpl.BookServiceimpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: jdbc-template-demo
 * @description: BookController
 * @author: 作者
 * @create: 2021-12-24 10:47
 */
@RestController
@RequestMapping("/jdbc")
public class BookController {
    @Resource
    BookServiceimpl bookServiceimpl;

    //增
    @RequestMapping("/insertBook")
    public String insertBook(Book book){
        //book.setBid(null);
        book.setBname("java");
        book.setBcount(3L);
        book.setBauthor("JC");
        return bookServiceimpl.insert(book);
    }

    //批量增
    @RequestMapping("/insertBookList")
    public String insertList(){
        List<Object[]> list=new ArrayList<Object[]>();
        list.add(new Object[]{"Spring5",4L,"dorkily"});
        list.add(new Object[]{"Redis6",15L,"lieyu"});
        return bookServiceimpl.insertList(list);
    }

    //修改1
    @RequestMapping("/updateBook1")
    public String updateBook1(Book book){
        book.setBname("Spring6");
        book.setBcount(17L);
        book.setBauthor("kopi");
        return bookServiceimpl.update1(book,3L);
    }
    //修改2
    @RequestMapping("/updateBook2")
    public String updateBook2(){
        Object[] objects=new Object[]{"Spring4",16L,"kopi",3L};
        return bookServiceimpl.update2(objects);
    }

    //查询ById
    @RequestMapping("/selectBook")
    public Book selectBook(){
        return bookServiceimpl.select(2L);
    }

    //查询所有
    @RequestMapping("/selectAllBook")
    public List<Book> selectAllBook(){
        System.out.println(bookServiceimpl.selectAll());
        return bookServiceimpl.selectAll();
    }

    //聚合查询
    /**
     * JdbcTemplate中执行聚合查询的方法为queryForObject()方法,其参数如下:
     * String sql: SQL语句
     * Class<T> requiredType: 返回类型的字节码
     * @Nullable Object... args: SQL语句的参数
     */
    @RequestMapping("/selectBooks2")
    public List<Map<String, Object>> selectBooks2(){
        Object[] objects=new Object[]{10L};
        System.out.println(bookServiceimpl.selectBooks2(objects));
        return bookServiceimpl.selectBooks2(objects);
    }


}
