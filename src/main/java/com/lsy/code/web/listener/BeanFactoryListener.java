package com.lsy.code.web.listener;

import com.lsy.code.utils.BeanFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.InputStream;
import java.util.List;

public class BeanFactoryListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        InputStream is = BeanFactoryListener.class.getClassLoader().getResourceAsStream("applicationContext.xml");
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(is);
            List<Element> list = document.selectNodes("//bean[@id]");
            for (Element element : list
            ) {
                BeanFactory.getMap().put(element.attributeValue("id"), element.attributeValue("class"));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
