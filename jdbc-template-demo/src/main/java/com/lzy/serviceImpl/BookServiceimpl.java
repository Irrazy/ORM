package com.lzy.serviceImpl;

import com.lzy.pojo.Book;
import com.lzy.service.BookService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: jdbc-template-demo
 * @description: bookServiceimpl
 * @author: 作者
 * @create: 2021-12-24 10:45
 */
@Service
public class BookServiceimpl implements BookService {
    @Resource
    JdbcTemplate jdbcTemplate;
//增
    @Override
    public String insert(Book book) {
        String sql="insert into book(bname,bcount,bauthor) values (?,?,?);";
        int count = jdbcTemplate.update(sql,book.getBname(),book.getBcount(),book.getBauthor());
        if (count>0){
            return "sucessful";
        }else {
            return "erro";
        }
    }

    @Override
    public String insertList(List<Object[]> list) {
        String sql="insert into book(bname,bcount,bauthor) values (?,?,?);";
        int a[]=jdbcTemplate.batchUpdate(sql,list);
        if(a.length>0){
            return "sucessful";
        }else {
            return "erro";
        }
    }

    @Override
    public String update1(Book book,Long id) {
        String sql="update book set bname=?,bcount=?,bauthor=? where bid=?";
        int count = jdbcTemplate.update(sql,book.getBname(),book.getBcount(),book.getBauthor(),id);
        if (count>0){
            return "sucessful";
        }else {
            return "erro";
        }
    }

    @Override
    public String update2(Object[] objects) {
        String sql="update book set bname=?,bcount=?,bauthor=? where bid=?";
        int count = jdbcTemplate.update(sql,objects);
        if (count>0){
            return "sucessful";
        }else {
            return "erro";
        }
    }

    @Override
    public Book select(Long bid) {
        String sql="select * from book where bid=?";
        //其中RowMapper类类似于DBUtils的ResultSetHandler类,可以自己写一个实现类,但常用Spring框架内置的实现类BeanPropertyRowMapper<T>(T.class)
        List<Book> list1= jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class),bid);
        return list1.isEmpty() ? null:list1.get(0);
    }

    //查所有
    @Override
    public List<Book> selectAll() {
        String sql="select * from book ";
        List<Book> list1= jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        return list1;
    }

    @Override
    public List<Map<String, Object>> selectBooks2(Object[] objects) {
        String sql="select * from book where bcount > ?";
        List<Map<String, Object>> list1=jdbcTemplate.queryForList(sql,objects);
        return list1;
    }


}
