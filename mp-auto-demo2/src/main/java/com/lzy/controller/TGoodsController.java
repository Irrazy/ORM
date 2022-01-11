package com.lzy.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzy.pojo.TGoods;
import com.lzy.service.impl.TGoodsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzy
 * @since 2021-12-17
 */
@RestController
@RequestMapping("/goods")
public class TGoodsController {
    @Resource
    private TGoodsServiceImpl tGoodsServiceImpl;

    @RequestMapping("/all")
    public List<TGoods> getAll(){
        return tGoodsServiceImpl.list();
    }
    @RequestMapping("/Gid")
    public TGoods getById(){
        return tGoodsServiceImpl.getById(14);
    }

    @RequestMapping("/insert")
    public Boolean insert(TGoods good){
        good.setName("jacket");
        good.setCount(8L);
        good.setNum("0017");
        Boolean a=tGoodsServiceImpl.save(good);
        return a;
    }




    //分页查询方法1
    /**
     * 分页查询
     * @param pageNo 起始页
     * @param pageSize 页数
     * @param good 类
     * @return 返回值
     */

    /*
     @GetMapping("/findAllPage1")
    //这里的pageNo就是起始页，0和1都是第一页
    public IPage<TGoods> findAllPage(@RequestParam(name = "pageNo", defaultValue = "4") Integer pageNo,
                                     @RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize, TGoods good){
        QueryWrapper<TGoods> queryWrapper = new QueryWrapper<>();
        //queryWrapper.lambda().eq(User::getAddress,"北京");
        Page<TGoods> tGoodsPage = new Page<>(pageNo, pageSize);
        IPage<TGoods> iPage = tGoodsServiceImpl.page(tGoodsPage, queryWrapper);
        return iPage;
    }
     */



//分页查询方法2
    @GetMapping("/findAllPage2")
     public IPage<TGoods> findAllPage2() {
        Page<TGoods> page = new Page<>(2,4);
        IPage<TGoods> tGoodsIPage=tGoodsServiceImpl.page(page);
     //Page<TGoods> employeePage = employeeMapper.selectPage(page, null);
          tGoodsIPage.getRecords().forEach(System.out::println);
          System.out.println("当前页：" + tGoodsIPage.getCurrent());
          System.out.println("总页数：" + tGoodsIPage.getPages());
          System.out.println("记录数：" + tGoodsIPage.getTotal());
     //System.out.println("是否有上一页：" + tGoodsIPage.hasPrevious());
     //System.out.println("是否有下一页：" + tGoodsIPage.hasNext());
        return tGoodsIPage;
     }

     //测试乐观锁
    @RequestMapping("/optimisticker")
    public String testOptimisticker(){
        //1.根据id查询商品
        TGoods good = tGoodsServiceImpl.getById(2);
        //2.修改数据，调用方法
        good.setCount(10L);
        Boolean i = tGoodsServiceImpl.updateById(good);
        if(i.equals(true)){
            return "sucessful";
        }
        return "erro";
    }



}

