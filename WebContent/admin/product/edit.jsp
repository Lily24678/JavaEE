<%--
  Created by IntelliJ IDEA.
  User: smates
  Date: 2020/11/27
  Time: 上午11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="update_contain">
    <iframe name="form_iframe" style="display: none;"></iframe>
    <iframe name="form_iframe2" style="display: none;"></iframe>
    <form action="${pageContext.request.contextPath}/file" enctype="multipart/form-data" method="post"
          target="form_iframe2" id="file_form"></form>
    <form action="${pageContext.request.contextPath}/mg/product?method=edit" method="post" target="form_iframe"
          id="edit_form">
        <table>
            <caption>商品管理-编辑</caption>
            <tbody>
            <tr>
                <td>商品名称</td>
                <td><input type="text" name="pname" value="${bean.pname}" required="required"></td>
            </tr>
            <tr>
                <td>商城价</td>
                <td><input type="number"  name="market_price" value="${bean.market_price}" min="0" required="required"></td>
            </tr>
            <tr>
                <td>售价</td>
                <td><input type="number" name="shop_price" value="${bean.shop_price}" min="0" required="required"></td>
            </tr>
            <tr>
                <td>商品图片</td>
                <td>
                    <input type="file" accept="image/*" form="file_form" name="file" required="required">
                    <br>
                    <img src="/imgUrl/${bean.pimage}" alt="无法查看请联系管理员" width="60px" height="60px"/>
                </td>
                <input type="hidden" name="pimage" value="${bean.pimage}"/>
            </tr>
            <tr>
                <td>更新日期</td>
                <td><input type="date" name="pdate" value="${bean.pdate}" required="required"></td>
            </tr>
            <tr>
                <td>是否热门</td>
                <td>
                    <select name="is_hot" required="required">
                        <option value="1" <c:if test="${bean.is_hot==1}">selected="selected"</c:if>>是</option>
                        <option value="0" <c:if test="${bean.is_hot==0}">selected="selected"</c:if>>否</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>是否下架</td>
                <td>
                    <select name="pflag" required="required">
                        <option value="0" <c:if test="${bean.pflag==0}">selected="selected"</c:if>>否</option>
                        <option value="1" <c:if test="${bean.pflag==1}">selected="selected"</c:if>>是</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>商品描述</td>
                <td>
                    <textarea name="pdesc" ows="4" cols="50" required="required">${bean.pdesc}</textarea>
                </td>
            </tr>
            <tr>
                <td>商品类目</td>
                <td>
                    <select name="categoryid" required="required">

                    </select>
                </td>
            </tr>
            <tr>
                <input type="hidden" name="pid" value="${bean.pid}">
                <td colspan="2"><input type="submit" value="保存"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<script>
    $(function () {
        $.post("${pageContext.request.contextPath}/mg/product",{method:"findCategroy"},function (result){
            const x = document.querySelector("select[name='categoryid']");
            $(result).each(function (index,item){
                const option = document.createElement("option");
                option.text=item.cname;
                option.value=item.cid;
                if ("${bean.category.cid}"==item.cid){
                    option.selected="selected";
                }
                try{
                    // 对于更早的版本IE8
                    x.add(option,x.options[null]);
                }catch (e){
                    x.add(option,null);
                }
            });
        },"json");
    });

    $("#edit_form").submit(function () {
        const url = $(this).attr("action");
        $.ajax({
            url: "${pageContext.request.contextPath}/file",
            type: 'POST',
            data: new FormData(document.getElementById("file_form")),
            processData: false,
            contentType: false,
            success:function (result){
                if (""!=result)$("input[name='pimage']").val(result);
                $.post(url,$("#edit_form").serialize(),function (data){
                    $("#main_content").html(data);
                });
            },
            error:function (xhr,status,error){
                window.alert("文件上传失败");
            }
        });
        return false;
    });
</script>
