package com.lsy.code.web.servlet.management;

import com.lsy.code.dao.CategoryDao;
import com.lsy.code.dao.ProductDao;
import com.lsy.code.domain.BeanPage;
import com.lsy.code.domain.Category;
import com.lsy.code.domain.Product;
import com.lsy.code.utils.*;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProductServlet extends BaseServlet {
    public String listpage(HttpServletRequest request, HttpServletResponse response) throws SQLException, InvocationTargetException, IllegalAccessException {
        Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));//start with 1
        ProductDao productDao = (ProductDao) BeanFactory.getInstance("productDao");
        BeanPage<Product> beanPage = new BeanPage<Product>();
        beanPage.setCurrentPage(currentPage);
        int totalCount = productDao.count().intValue();
        beanPage.setTotalCount(totalCount);
        beanPage.setTotalPage(totalCount % beanPage.getSize() == 0 ? totalCount / beanPage.getSize() : totalCount / beanPage.getSize() + 1);
        beanPage.setList(productDao.find((currentPage - 1) * beanPage.getSize(), beanPage.getSize()));
        request.setAttribute("beanPage", beanPage);
        request.setAttribute("pageurl", "product");
        return "/admin/product/list.jsp";
    }

    public String addpage(HttpServletRequest request, HttpServletResponse response) {
        return "/admin/product/add.jsp";
    }

    public String editpage(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, SQLException, InvocationTargetException {
        ProductDao productDao = (ProductDao) BeanFactory.getInstance("productDao");
        Product product = productDao.findByPid(request.getParameter("pid"));
        request.setAttribute("bean", product);
        return "/admin/product/edit.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, SQLException {
        String cid = request.getParameter("categoryid");
        String pimage = request.getParameter("pimage");
        Map<String, String[]> map = request.getParameterMap();
        Product product = new Product();
        ConvertUtils.register(new MyDataConverter(), Date.class);
        BeanUtils.populate(product, map);
        product.setPid(StringUtils.createStrByUUID());
        Category category = new Category();
        category.setCid(cid);
        product.setCategory(category);
        ProductDao productDao = (ProductDao) BeanFactory.getInstance("productDao");
        productDao.add(product);
        return "/mg/product?method=listpage&currentPage=1";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, SQLException {
        String cid = request.getParameter("categoryid");
        Map<String, String[]> map = request.getParameterMap();
        Product product = new Product();
        ConvertUtils.register(new MyDataConverter(), Date.class);
        BeanUtils.populate(product, map);
        Category category = new Category();
        category.setCid(cid);
        product.setCategory(category);
        ProductDao productDao = (ProductDao) BeanFactory.getInstance("productDao");
        if(!productDao.findByPid(product.getPid()).getPimage().equals(product.getPimage()))FIleUtils.deleteFile(FIleUtils.uploadfileDir+productDao.findByPid(product.getPid()).getPimage());
        productDao.update(product);
        return "/mg/product?method=listpage&currentPage=1";
    }

    public String del(HttpServletRequest request, HttpServletResponse response) throws SQLException, InvocationTargetException, IllegalAccessException {
        ProductDao productDao = (ProductDao) BeanFactory.getInstance("productDao");
        FIleUtils.deleteFile(FIleUtils.uploadfileDir+productDao.findByPid(request.getParameter("pid")).getPimage());
        productDao.delByPid(request.getParameter("pid"));
        return "/mg/product?method=listpage&currentPage=1";
    }

    public void findCategroy(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        CategoryDao categoryDao = (CategoryDao) BeanFactory.getInstance("categoryDao");
        List<Category> list = categoryDao.findAll();
        response.getWriter().println(JSONArray.fromObject(list));
    }
}
