<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/12/1
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
第${beanPage.currentPage}/${ beanPage.totalPage }页，&nbsp;&nbsp;总记录数：${beanPage.totalCount}，&nbsp;&nbsp;每页显示：${beanPage.size}&nbsp;&nbsp;
<br/>
<c:if test="${beanPage.currentPage!=1}">
    <a href="javascript:$('#main_content').load('${pageContext.request.contextPath}/mg/${pageurl}?method=listpage&currentPage=1');">首页</a>&nbsp;&nbsp;
    <a href="javascript:$('#main_content').load('${pageContext.request.contextPath}/mg/${pageurl}?method=listpage&currentPage=${beanPage.currentPage-1}');">上一页</a>&nbsp;&nbsp;
</c:if>
<c:forEach var="i" begin="1" end="${ beanPage.totalPage }">
    <c:if test="${ beanPage.currentPage == i }">
        [${ i }]
    </c:if>
    <c:if test="${ beanPage.currentPage != i }">
        <a href="javascript:$('#main_content').load('${ pageContext.request.contextPath }/mg/${pageurl}?method=listpage&currentPage=${i}')">[${ i }]</a>
    </c:if>
</c:forEach>
<c:if test="${beanPage.currentPage!=beanPage.totalPage}">
    <a href="javascript:$('#main_content').load('${pageContext.request.contextPath}/mg/${pageurl}?method=listpage&currentPage=${beanPage.currentPage+1}');">下一页</a>&nbsp;&nbsp;
    <a href="javascript:$('#main_content').load('${pageContext.request.contextPath}/mg/${pageurl}?method=listpage&currentPage=${beanPage.totalPage}');">尾页</a>&nbsp;&nbsp;
</c:if>
