# 一、输出结果的封装



## 1.1 resultmap

resultMap标签可以建立查询的列名和实体类的属性名称不一致时建立对应关系。从而实现封装。 在select标签中使用resultMap属性指定引用即可。同时resultMap可以实现将查询结果映射为复杂类型的pojo，比如在查询结果映射对象中包括pojo和list实现一对一查询和一对多查询。

<!-- 建立User实体和数据库表的对应关系





## 1.2 #{} 和 ${} 的区别

#{}表示一个占位符号 通过#{}可以实现preparedStatement向占位符中设置值，自动进行java类型和jdbc类型转换，#{}可以有效防止sql注入。 #{}可以接收简单类型值或pojo属性值。 如果parameterType传输单个简单类型值，#{}括号中可以是value或其它名称。

 ${}表示拼接sql串 通过${}可以将parameterType 传入的内容拼接在sql中且不进行jdbc类型转换， ${}可以接收简单类型值或pojo属性值，如果parameterType传输单个简单类型值，${}括号中只能是value。



## 1.3 jdbc 和 Mybatis编程的比较与区别



1. 数据库链接创建、释放频繁造成系统资源浪费从而影响系统性能，如果使用数据库链接池可解决此问题。 

   解决： 在SqlMapConfig.xml中配置数据链接池，使用连接池管理数据库链接。

2. Sql语句写在代码中造成代码不易维护，实际应用sql变化的可能较大，sql变动需要改变java代码。 

   解决： 将Sql语句配置在XXXXmapper.xml文件中与java代码分离。 

3. 向sql语句传参数麻烦，因为sql语句的where条件不一定，可能多也可能少，占位符需要和参数对应。

    解决： Mybatis自动将java对象映射至sql语句，通过statement中的parameterType定义输入参数的类型。 

4. 对结果集解析麻烦，sql变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成pojo对象解析比较方便。 

   解决： Mybatis自动将sql执行结果映射至java对象，通过statement中的resultType定义输出结果的类型。

# 二、配置文件

```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 配置properties
        可以在标签内部配置连接数据库的信息。也可以通过属性引用外部配置文件信息
        resource属性： 常用的
            用于指定配置文件的位置，是按照类路径的写法来写，并且必须存在于类路径下。
        url属性：
            是要求按照Url的写法来写地址
            URL：Uniform Resource Locator 统一资源定位符。它是可以唯一标识一个资源的位置。
            它的写法：
                http://localhost:8080/mybatisserver/demo1Servlet
                协议      主机     端口       URI

            URI:Uniform Resource Identifier 统一资源标识符。它是在应用中可以唯一定位一个资源的。
    -->
    <properties url="file:///D:/IdeaProjects/day02_eesy_01mybatisCRUD/src/main/resources/jdbcConfig.properties">
       <!-- <property name="driver" value="com.mysql.jdbc.Driver"></property>
        <property name="url" value="jdbc:mysql://localhost:3306/eesy_mybatis"></property>
        <property name="username" value="root"></property>
        <property name="password" value="1234"></property>-->
    </properties>

    <!--使用typeAliases配置别名，它只能配置domain中类的别名 -->
    <typeAliases>
        <!--typeAlias用于配置别名。type属性指定的是实体类全限定类名。alias属性指定别名，当指定了别名就再区分大小写 
        <typeAlias type="com.itheima.domain.User" alias="user"></typeAlias>-->

        <!-- 用于指定要配置别名的包，当指定之后，该包下的实体类都会注册别名，并且类名就是别名，不再区分大小写-->
        <package name="com.itheima.domain"></package>
    </typeAliases>

    <!--配置环境-->
    <environments default="mysql">
        <!-- 配置mysql的环境-->
        <environment id="mysql">
            <!-- 配置事务 -->
            <transactionManager type="JDBC"></transactionManager>

            <!--配置连接池-->
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"></property>
                <property name="url" value="${jdbc.url}"></property>
                <property name="username" value="${jdbc.username}"></property>
                <property name="password" value="${jdbc.password}"></property>
            </dataSource>
        </environment>
    </environments>
    <!-- 配置映射文件的位置 -->
    <mappers>
        <!--<mapper resource="com/itheima/dao/IUserDao.xml"></mapper>-->
        <!-- package标签是用于指定dao接口所在的包,当指定了之后就不需要在写mapper以及resource或者class了 -->
        <package name="com.itheima.dao"></package>
    </mappers>
</configuration>
```



## 1.1 properties （属性）

两种配置方式

**第一种**：

```
            <properties>
                <!-- 配置连接数据库的4个基本信息 -->
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/chatroom"/>
                <property name="username" value="root"/>
                <property name="password" value="admin123"/>
            </properties>

配置DataSource标签时：
           <dataSource type="POOLED">
                <!-- 配置连接数据库的4个基本信息 -->
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/chatroom"/>
                <property name="username" value="root"/>
                <property name="password" value="admin123"/>
            </dataSource>
```

**第二种:   在classpath下定义db.properties文件**

```java
            jdbc.driver=com.mysql.jdbc.Driver 
            jdbc.url=jdbc:mysql://localhost:3306/chatroom 
            jdbc.username=root 
            jdbc.password=admin123
```



## 1.2 typeAliases (类型别名)

> 在SqlMapConfig.xml中配置：
>
> ```java
>  <typeAliases> 
>  		<!-- 单个别名定义 --> 
>  		<typeAlias alias="user" type="com.itheima.domain.User"/> 
>  		<!-- 批量别名定义，扫描整个包下的类，别名为类名（首字母大写或小写都可以） --> 
>  		<package name="com.itheima.domain"/> <package name="其它包"/> 
>  </typeAliases>
> ```



## 1.3 mappers (映射器)

### 1.3.1  mapper resource=" " 



```
<mapper resource="dao/IUserDao.xml"/>
```



### 1.3.2  mapper class=" "

```
<mapper class="dao.IUserDao"/>
```

**注： 此种方法要求mapper接口名称和mapper映射文件名称相同，且放在同一个目录中**



### 1.3.3  package name=" "

```
<package name="dao.mapper"/>
```

**注： 此种方法要求mapper接口名称和mapper映射文件名称相同，且放在同一个目录中**

