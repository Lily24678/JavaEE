<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/25
  Time: 上午10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
</style>
<div id="top">
    <table>
        <tr>
            <td colspan="3"><img src="${pageContext.request.contextPath}/images/top_100.jpg" alt="图片无法查看，请联系管理员" width="100%" height="74px"></td>
        </tr>
        <tr>
            <td style="width: 20%;">
            <script>
                const myArray=new Array(6);
                myArray[0]="星期日"
                myArray[1]="星期一"
                myArray[2]="星期二"
                myArray[3]="星期三"
               myArray[4]="星期四"
                myArray[5]="星期五"
                myArray[6]="星期六"
                const currDate = new Date();
                document.write(currDate.getFullYear());
                document.write("年");
                document.write(currDate.getMonth());
                document.write("月");
                document.write(currDate.getDate())
                document.write("日");
                document.write("&nbsp;&nbsp;&nbsp;");
                document.write(myArray[currDate.getDay()])
            </script>
            </td>
            <td><a href="${pageContext.request.contextPath}/admin/index.jsp">登陆页</a></td>
            <td style="width: 20%;">用户名：${cookie.username.value}</td>
        </tr>
    </table>
</div>
