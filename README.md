GeneratorTest
=============
MyBatis Generator 的源码学习

运行Generator生成代码主要的处理有以下三步：
1、数据库内省
2、基于数据库内省所获得数据的代码生成
3、合并或保存生成的文件

以上三步均在MyBatisGenerator类的generate方法中体现

默认的，对重复生成的xml文件是合并而不是替换，不知道作者是基于什么考量，但很容易引起一些错误
在IntrospectedTableMyBatis3Impl类的218行，修改倒数第二个参数为false即可