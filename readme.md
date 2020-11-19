# 一、JavaWEB三大核心组件
## 1. Servlet
使用步骤：
- 1、实现Servlet接口。
- 2、将实现类配置到服务器中。web.xml
> 通用servlet（BaseServlet）

## 2. Listener
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

## 3. Filter
使用步骤：
- 1、实现Filter接口。
- 2、将实现类配置到服务器中。web.xml

# 二、网络编程
- TCP
- UDP


# 三、、JAVA 基础
## JAVA 的类
- Properties
- Class、ClassLoader


# 四、Demo案例
## 1. 实现的功能
- ServletUtils(cookie)
- utils.js(纯js代码：)
1. 处理中文乱码（GenericEncodingFilter）
> 1. get请求下，接收出现中文乱码的原因：tomcat服务器对uri的处理编码与浏览器编码不一致
> 2. 在get请求下，tomcat8.8.59不需要做中文乱码处理，tomcat7需要做中文乱码处理.
> 3. 查看tomcat的url编码：在webapps/docs/config/http.html下有URIEncoding说明，根据此处说明可以更改Tomcat对URI的接收编码（Tomcat8.5.59在conf下catalina.properties追加org.apache.catalina.STRICT_SERVLET_COMPLIANCE=true）
2. 实现自动登录(设置cookie有效期即可)
3. 实现 注册、登录功能
4. 实现文件的下载与上传(commons-fileupload-xxx.jar,commons-io-xxx.jar)
```
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.4</version>
</dependency>
```
5. 实现历史浏览功能
6. 实现购物车功能
7. 实现图片验证码
8. 阻止通过Url直接访问服务器上的静态文件，简单的防御CSRF攻击
9. 实现登录校验（LoginFilter）

## 2. JSP
1. JSP 的应用（/demo/jsp/）
2. JSTL标签库与EL表达式的结合使用（/demo/jst_el/）

## 3. session依赖cookie，如果浏览器禁用了cookie的解决办法
（/demo/disable_cookie/）


# 五、网页布局
1. 表格布局。例：layout_table.html
2. div+css 布局。 例：layout_div+css.html
3. 框架布局（frame，分frameset 和iframe）

# 六、HTTP
## 请求头
### Referer
- 作用:
    1. 防盗链.网站为了保护自己的资源，可以通过Referer头检测出从哪里链接到当前的网页或资源，一旦检测到不是通过本站的链接进行的访问，可以进行阻止访问或者跳转到指定的页面.
    2. 直接在浏览器的地址栏中输入一个资源的URL地址，那么这种请求是不会包含 Referer  字段的，因为这是一个“凭空产生”的 HTTP  请求，并不是从一个地方链接过去的。


