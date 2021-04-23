# 网上商城案例
1. 工厂类，替代每次方法到要new 对象().method(Object... args)【BeanFactoryListener、BeanFactory】
2. jsp页面如何显示本地磁盘路径的图片？决办法：配置虚拟路径。在在tomcat/conf/server.xml文件中进行配置：在Host标签下配置
```
<Context crossContext="true" debug="0" docBase="/home/smates/temp/JavaEE_Demo/uploadfile" path="/imgUrl" reloadable="true"/> 
```
3. zTree 是一个依靠 jQuery 实现的多功能 “树插件”。http://www.treejs.cn/v3/main.php#_zTreeInfo
4. commons-beanutils
5. C3PO
6. commons-dbutils
7. json-lib
> 调用JSONArray.fromObject(Object)异常引起：在java.sql.Date.getHours方法上（该方法位于Data.java的187行)发生了java.lang.IllegalArgumentException异常。解决办法：jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor(){})【见com.lsy.code.web.servlet.management.CategoryServlet的findProduct方法】
8. 发送邮件【mail.jar】【MailUtils】
9. ehcache


## 后台管理
- 页面布局：div+css
- 数据交互：jsp
- 功能实现：
1. 后台管理的登陆(自动登陆、记住密码、校验码)
2. 后台管理用户、用户、商品类目、商品、订单的增删改查（增改的时候加入令牌机制，防止重复提交）

## 前台展示
- 页面布局：bootstrap
- 数据交互：jsp
- 功能实现：
1. 登陆
2. 注册（用户激活_邮箱）
3. 浏览记录
4. 购物车
5. 订单（订单的支付功能【了解】）
6. 商品的目录显示（ehcache）

## 存在的问题
1. 购物车：购物车信息是存在于session中，会出现如下情况：在同一台浏览器上，A登陆过后，B登陆，B的购物车中会有A的购物车内容。
> 解决思路：将购物车与用户绑定。