package com.lsy.code.web.servlet.fore;

import com.lsy.code.dao.CategoryDao;
import com.lsy.code.dao.ProductDao;
import com.lsy.code.domain.BeanPage;
import com.lsy.code.domain.Category;
import com.lsy.code.domain.Product;
import com.lsy.code.utils.BaseServlet;
import com.lsy.code.utils.BeanFactory;
import com.lsy.code.utils.CookieUtils;
import com.lsy.code.utils.StringUtils;
import net.sf.json.JSONArray;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServlet extends BaseServlet {
    private static final CacheManager cacheManager = CacheManagerBuilder.newCacheManager(new XmlConfiguration(ProductServlet.class.getClassLoader().getResource("ehcache.xml")));

    static {
        cacheManager.init();
    }


    public void findCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        ArrayList<Category> categories = findInChcache();
        response.getWriter().println(JSONArray.fromObject(categories));
    }

    public String indexpage(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, SQLException, InvocationTargetException {
        String cid = request.getParameter("cid");
        if (StringUtils.isBlank(cid)) cid = findInChcache().get(0).getCid();
        ProductDao productDao = (ProductDao) BeanFactory.getInstance("productDao");
        Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));//start with 1
        int totalCount = productDao.countByCid(cid).intValue();
        BeanPage<Product> beanPage = new BeanPage<>();
        beanPage.setSize(9);
        beanPage.setCurrentPage(currentPage);
        beanPage.setTotalCount(totalCount);
        beanPage.setTotalPage(totalCount % beanPage.getSize() == 0 ? totalCount / beanPage.getSize() : totalCount / beanPage.getSize() + 1);
        List<Product> list = productDao.findByCid(cid, (currentPage - 1) * beanPage.getSize(), beanPage.getSize());
        beanPage.setList(list);
        request.setAttribute("beanPage", beanPage);
        request.setAttribute("pageurl", "product");
        return "/fore/index.jsp";
    }

    public String productpage(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, SQLException, InvocationTargetException {
        String pid = request.getParameter("pid");
        ProductDao productDao = (ProductDao) BeanFactory.getInstance("productDao");
        Product product = productDao.findByPid(pid);
        request.setAttribute("product", product);

        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtils.getCookie(cookies, "history");
        if (null == cookie) {//没有浏览记录
            Cookie c = new Cookie("history", pid);
            c.setPath(request.getContextPath() + "/fore/product");
            c.setMaxAge(24 * 60 * 60 * 1);
            response.addCookie(c);
        } else {
            String[] split = cookie.getValue().split("-");
            List<String> list = new ArrayList<>(Arrays.asList(split));
            if (list.contains(pid)) {//是第一次浏览
                list.remove(pid);
            } else {
                if (12 <= list.size()) {// 当前长度已经到最大长度
                    list.remove(list.size() - 1);
                }
            }
            list.add(0, pid);
            Cookie c = new Cookie("history", String.join("-", list));
            c.setPath(request.getContextPath() + "/fore/product");
            c.setMaxAge(24 * 60 * 60 * 1);
            response.addCookie(c);
        }
        return "/fore/product_info.jsp";
    }

    public void findpimage(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException, SQLException, InvocationTargetException {
        ProductDao productDao = (ProductDao) BeanFactory.getInstance("productDao");
        Product product = productDao.findByPid(request.getParameter("pid"));
        response.sendRedirect("/imgUrl/" + product.getPimage());
    }

    public String clearhistory(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtils.getCookie(cookies, "history");
        if (null != cookie) {
            cookie.setValue("");
            cookie.setPath(request.getContextPath() + "/fore/product");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "/fore/product?method=indexpage&currentPage=1";
    }

    /**
     * 获取商品分类目录，缓存机制ehcache
     */
    private ArrayList<Category> findInChcache() throws SQLException {
        Cache<String, ArrayList> cache = cacheManager.getCache("categoryCache", String.class, ArrayList.class);
        ArrayList<Category> list = cache.get("list");
        if (null == list) {
            CategoryDao categoryDao = (CategoryDao) BeanFactory.getInstance("categoryDao");
            cache.put("list", (ArrayList) categoryDao.findAll());
        }
        return cache.get("list");
    }
}

