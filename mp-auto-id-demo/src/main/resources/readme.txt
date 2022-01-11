1.此demo是mp+AutoGenerator+自定义Id生成（雪花算法+UUID）

步骤：
1.自动生成完成，生成文件
2.在生成的实体类的id上修改主键生成策略
         @TableId(value = "pid", type = IdType.ASSIGN_ID)----数值/string类型
         @TableId(value = "pid", type = IdType.ASSIGN_UUID)----雪花算法字符串型
3.数据库表中的id类型设置要一致，如果是需要自增型type = IdType.AUTO，可以设置自增bigInt型
