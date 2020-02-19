# JavaWEB三大核心组件
## Servelet
使用步骤：
- 1、实现Servlet接口。
- 2、将实现类配置到服务器中。web.xml

## Listener
> 事件源：Servlet中的三个域对象,ServletContext,HttpSession,ServletRequest.
> 监听器：自定义类实现8个接口.
> 事件源和监听器的绑定：配置.

WEB中的监听器共有三类八种(监听三个域对象):
- 一类：监听三个域对象的创建和销毁的监听器:ServletContextListener,HttpSessionListener,ServletRequestListener
- 二类：监听三个域对象的属性变更的监听器(属性添加,移除,替换):ServletContextAttributeListener,HttpSessionAttributeListener,ServletRequestAttributeListener
- 三类：监听HttpSession中的JavaBean的状态改变(绑定,解除绑定,钝化,活化):HttpSessionBindingListener,HttpSessionActivationListener

使用步骤：
- 1、实现监听器。
- 2、将实现了配置到服务器中。web。xml【第三类不需要配置】

# Filter
