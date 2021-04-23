package com.lsy.code.web.servlet.management;

import com.lsy.code.dao.CategoryDao;
import com.lsy.code.dao.ProductDao;
import com.lsy.code.domain.BeanPage;
import com.lsy.code.domain.Category;
import com.lsy.code.domain.Product;
import com.lsy.code.utils.BeanFactory;
import com.lsy.code.utils.StringUtils;
import com.lsy.code.utils.vo.MessageHandler;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CategoryServlet extends BguserServlet {
    public String listpage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));//start with 1
        CategoryDao categoryDao = (CategoryDao) BeanFactory.getInstance("categoryDao");
        BeanPage<Category> beanPage = new BeanPage<Category>();
        beanPage.setCurrentPage(currentPage);
        int totalCount = categoryDao.count().intValue();
        beanPage.setTotalCount(totalCount);
        beanPage.setTotalPage(totalCount % beanPage.getSize() == 0 ? totalCount / beanPage.getSize() : totalCount / beanPage.getSize() + 1);
        beanPage.setList(categoryDao.find((currentPage - 1) * beanPage.getSize(), beanPage.getSize()));
        request.setAttribute("beanPage", beanPage);
        request.setAttribute("pageurl", "category");
        return "/admin/category/list.jsp";
    }

    public String addpage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("token", StringUtils.createStrByUUID());
        return "/admin/category/add.jsp";
    }

    public String editpage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String cid = request.getParameter("cid");
        CategoryDao categoryDao = (CategoryDao) BeanFactory.getInstance("categoryDao");
        request.setAttribute("bean", categoryDao.findByCid(cid));
        return "/admin/category/edit.jsp";
    }

    public void checkcname(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String cname = request.getParameter("cname");
        String cid = request.getParameter("cid");
        String type = request.getParameter("type");
        CategoryDao categoryDao = (CategoryDao) BeanFactory.getInstance("categoryDao");
        if ("add".equals(type)) {
            List<Category> list = categoryDao.findByCname(cname);
            if (0 < list.size()) {
                response.getWriter().println(JSONObject.fromObject(MessageHandler.createMsgFailure("类目名称重复")).toString());
                return;
            }
        }
        if ("edit".equals(type)) {
            List<Category> list = categoryDao.findByCnameAndCidNOt(cname, cid);
            if (0 < list.size()) {
                response.getWriter().println(JSONObject.fromObject(MessageHandler.createMsgFailure("类目名称重复")).toString());
                return;
            }
        }
        response.getWriter().println(JSONObject.fromObject(MessageHandler.createMsgSuccess("success")).toString());
    }

    /**
     * 令牌机制
     */
    public String add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, SQLException, IOException {
        String token = (String) request.getSession().getAttribute("token");
        // 清空session中的令牌:
        request.getSession().removeAttribute("token");
        // 判断是否是重复提交:
        if (!request.getParameter("token").equals(token)) {
            request.setAttribute("msg", "亲！您已经提交过！请不要重复提交了!");
            return "/msg.jsp";
        }
        Map<String, String[]> map = request.getParameterMap();
        Category category = new Category();
        BeanUtils.populate(category, map);
        category.setCid(StringUtils.createStrByUUID());
        CategoryDao categoryDao = (CategoryDao) BeanFactory.getInstance("categoryDao");
        categoryDao.add(category);
        return "/mg/category?method=listpage&currentPage=1";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, SQLException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Category category = new Category();
        BeanUtils.populate(category, map);
        CategoryDao categoryDao = (CategoryDao) BeanFactory.getInstance("categoryDao");
        categoryDao.update(category);
        return "/mg/category?method=listpage&currentPage=1";
    }

    public String del(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String cid = request.getParameter("cid");
        CategoryDao categoryDao = (CategoryDao) BeanFactory.getInstance("categoryDao");
        categoryDao.delByCid(cid);
        return "/mg/category?method=listpage&currentPage=1";
    }

    public void findProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        ProductDao productDao = (ProductDao) BeanFactory.getInstance("productDao");
        List<Product> list = productDao.findByCid(request.getParameter("cid"));
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

            @Override
            public Object processArrayValue(Object o, JsonConfig jsonConfig) {
                return simpleDateFormat.format(o);
            }

            @Override
            public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
                if (o != null) {
                    return simpleDateFormat.format(o);
                } else {
                    return null;
                }
            }
        });
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        response.getWriter().println(jsonArray);
    }
}
