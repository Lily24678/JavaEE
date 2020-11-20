# 自定义注解
> - (com.lsy.code.annotations)
> - 核心运行类的作用

# Servlet3.0
## 1.与Servlet2.5相比，Servlet3.0提供了三个新特性
1. 注解开发
2. 文件上传 
3. 异步请求 
## 2.Servlet3.0注解开发
- @WebServlet
- @WebListener
- @WebFilter（执行的顺序按实现类名的首字母排序）
- @MultipartConfig：证明客户端提交的表单数据是由多部分组成的。文件上传的servlet必须加上这个注解，Servlet3.0中的某些方法才有效
