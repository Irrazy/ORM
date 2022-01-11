纯mybatis---连接pgsql
步骤：
1.新建空maven工程
2.在pom.xml中导入资源
  Junit测试工具
  MyBatis核心Jar包
  postgresql 驱动-
   Lombok工具
   Log4j测试工具

3.在Java文件夹下新建pojo包，放入实体类
4.在resources文件夹下新建log4j.properties--声明日志记录级别
                    新建mybatis.xml--配置开发环境信息
                    新建jdbc-config.properties--提取mybatis.xml配置信息，解耦  所以要在mybatis.xml上方导入这个属性文件

5.在test文件夹新建test测试包，新建SessionTest测试类--测试连接：init()、testSession()、 destory()方法
6.在java文件中新建util包，新建MyBatisUtil类，将获取数据库连接的操作封装在一个util类中，方便后期维护与使用

7.实现增删改查
  7.1 映射模式mapper.xml实现增删改查
     在resources文件夹下
        创建映射文件存放的包——com.lzy.mapper
        创建User的映射文件——UserMapper.xml
        编写映射文件--增删改查
        将映射文件添加到mybatis.xml配置文件中
             在<configuration>标签对中添加
              <mappers>
                <mapper resource="com/tjise/mapper/UserMapper.xml"></mapper>
              </mappers>

  7.2 使用mapper接口实现增删改查
     在java文件夹下新建一个存放mapper接口的包（包名要与下方UserMapper的映射文件相同）
     新建一个mapper接口(类名要与下方UserMapper的名称相同)并编写其中的映射接口方法
     用了Mapper接口代理方法开发，所以UserMapper.xml映射文件中的namespace属性值改为mapper接口UserMapper的完整包名
     新建测试类MapperTest




8.一些待验证
  <!-- 多条件查询利用map类型
        默认的参数类型是map-->
    <select id="findUserByPassword" resultType="com.lzy.pojo.User">
        select * from user where score between #{minScore} and #{maxScore}
    </select>
