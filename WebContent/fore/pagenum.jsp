<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/12/1
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br/><br/>
第${beanPage.currentPage}/${ beanPage.totalPage }页，&nbsp;&nbsp;总记录数：${beanPage.totalCount}，&nbsp;&nbsp;每页显示：${beanPage.size}&nbsp;&nbsp;
<c:if test="${beanPage.currentPage!=1}">
    <a href="${pageContext.request.contextPath}/fore/${pageurl}?method=indexpage&currentPage=1&cid=${cid}">首页</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/fore/${pageurl}?method=indexpage&currentPage=${beanPage.currentPage-1}&cid=${cid}">上一页</a>&nbsp;&nbsp;
</c:if>
<c:forEach var="i" begin="1" end="${ beanPage.totalPage }">
    <c:if test="${ beanPage.currentPage == i }">
        [${ i }]
    </c:if>
    <c:if test="${ beanPage.currentPage != i }">
        <a href="${ pageContext.request.contextPath }/fore/${pageurl}?method=indexpage&currentPage=${i}&cid=${cid}">[${ i }]</a>
    </c:if>
</c:forEach>
<c:if test="${beanPage.currentPage!=beanPage.totalPage}">
    <a href="${pageContext.request.contextPath}/fore/${pageurl}?method=indexpage&currentPage=${beanPage.currentPage+1}&cid=${cid}">下一页</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/fore/${pageurl}?method=indexpage&currentPage=${beanPage.totalPage}&cid=${cid}">尾页</a>&nbsp;&nbsp;
</c:if>
