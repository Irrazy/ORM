1.此demo为重新集成mp代码生成器+内置分页+性能分析spy(打印sql语句)
  后添加乐观锁配置



2.步骤
 1 新建一个空的initialize project
 2 导入需要的pom依赖和插件
 3 配置application.properties/yml ,新建spy.properties配置spy插件相关
 4 在main\test\java\com.lzy文件夹下新建mp代码生成器文件--CodeGenerator.class(一样的代码，改自己具体配置即可)
 5.点击运行CodeGenerator.class即可生成controller、mapper、pojo、serviece(和serviceImpl)包以及包内文件代码
 6.配置分页插件
    a.相关依赖导入
    b.新建config包，创建MybatisPlusConfig文件
    c.配置分页的拦截器组件
    d.在具体的controller文件中写入具体分页查询方法
 7.mp实现乐观锁
    a.在MybatisPlusConfig文件中配置乐观锁插件
    b.在数据库表中增加version版本号字段
    c.在pojo实体类中增加version字段，添加注解@version
    d.在具体的controller文件中写入具体乐观锁测试方法