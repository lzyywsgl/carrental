# 汽车租赁系统

## 所用技术

> * Spring
> * SpringMVC
> * Mybatis
> * LayUI
> * dtree
> * echarts

## 开发环境

> * 操作系统：Windows 10
> * 编程语言：Java
> * JDK: 1.8 
> * 开发工具：IntelliJ IDEA
> * 版本控制工具：Git
> * 项目构建：Maven 3.5.3
> * 服务器：Tomcat 7.5
> * 数据库：MySQL 5.1.6
> * 数据库管理工具：Navicat 15
> * 代码托管平台：GitHub

## 项目整体功能

#### 一、业务模块
##### 1、客户管理
- [x]  客户列表                                            

- [x]  客户分页和模糊查询

- [x]  客户添加、修改、删除

- [x]  导出客户数据

##### 2、车辆管理
- [x]  车辆列表

- [x]  车辆车辆分页和模糊查询

- [x]  车辆添加、修改、删除

##### 3、业务管理
- [x]  汽车出租  
  1、根据客户身份证查询所有未出租的车辆信息  
  2、进行出租

- [ ]  出租单管理  
  1、多条件的模糊查询和分页  
  2、出租单的修改、删除、导出

- [ ]  汽车入库

- [ ]  检查单管理  
  1、多条件模糊查询和分页  
  2、检查单修改  
  3、导出检查单

##### 4、统计分析
- [ ]  客户男女比例图

- [ ]  月出租量统计

- [ ]  销售员业绩统计

- [ ]  出租车辆类型统计

#### 二、系统模块
##### 1、用户登陆
- [x]  校验用户名和密码

- [x]  登陆成功将登陆信息写入登陆日志

- [x]  未登录进行拦截

##### 2、菜单管理
- [x]  全查询菜单和根据左边的树查询不同菜单

- [x]  菜单的添加、修改、删除

##### 3、角色管理
- [x]  全查询角色和模糊查询

- [x]  角色的添加、修改、删除

##### 4、用户管理
- [x]  全查询用户和模糊查询

- [x]  用户的添加、修改、删除以及重置密码

##### 5、数据源的监控(druid monitor)