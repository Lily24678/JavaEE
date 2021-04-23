<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/25
  Time: 上午11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    #welcome {
        display: flex;
        justify-content: center;
        height: 100%;
    }

    #welcome > form:first-child {
        position: absolute;
        top: 50%;
        transform: translate(0, -50%);
    }
</style>
<div id="welcome">
    <form action="javascript:void(0);" name="welcome_form" method="post" nsubmit="return false;" target="welcome_form_iframe">
        <table>
            <tr>
                <td><h1>系统首页</h1></td>
            </tr>
            <tr>
                <td><h2>登陆成功</h2></td>
            </tr>
        </table>
    </form>
    <iframe name="welcome_form_iframe" style="display:none;"></iframe>
</div>
