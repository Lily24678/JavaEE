# JavaWEB三大核心组件
## Servlet
使用步骤：
- 1、实现Servlet接口。
- 2、将实现类配置到服务器中。web.xml
> 通用servlet（BaseServlet）

## Listener
>- 事件源：Servlet中的三个域对象,ServletContext,HttpSession,ServletRequest.
>- 监听器：自定义类实现8个接口.
>- 事件源和监听器的绑定：配置.

WEB中的监听器共有三类八种(监听三个域对象):
- 一类：监听三个域对象的创建和销毁的监听器:ServletContextListener,HttpSessionListener,ServletRequestListener
- 二类：监听三个域对象的属性变更的监听器(属性添加,移除,替换):ServletContextAttributeListener,HttpSessionAttributeListener,ServletRequestAttributeListener
- 三类：监听HttpSession中的JavaBean的状态改变(绑定,解除绑定,钝化,活化):HttpSessionBindingListener,HttpSessionActivationListener

使用步骤：
- 1、实现监听器接口。
- 2、将实现类配置到服务器中。web。xml【第三类不需要配置】

## Filter
使用步骤：
- 1、实现Filter接口。
- 2、将实现类配置到服务器中。web.xml

#  网络编程
- TCP
- UDP


# JAVA 基础
## JAVA 的类
- 1. Properties
- 2. Class、ClassLoader

# 网页布局
- 1. 表格布局。例：layout_table.html
- 2. div+css 布局。 例：layout_div+css.html
- 3. 框架布局（frame，分frameset 和iframe）

# Demo案例
- ServletUtils(cookie)
- utils.js(纯js代码：)
1. 处理中文乱码（GenericEncodingFilter）
2. 实现自动登录（LoginFilter）
3. 注册、登录，输入用户名和密码后（异步校验）。
4. 实现文件的下载与上传(commons-fileupload-xxx.jar,commons-io-xxx.jar)
```
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.4</version>
</dependency>
```
5. 实现登录校验
6. 阻止通过Url直接访问服务器上的静态文件
7. CSRF攻击与防御

#JSP????? vs EL表达式？？？
- <%@ page session="true"%>:知识点----session与cookie的关系(request.getSession)


#待定
- JSP?????vs EL表达式？？？
