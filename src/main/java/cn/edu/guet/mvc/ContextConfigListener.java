package cn.edu.guet.mvc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URISyntaxException;
import java.util.Map;

public class ContextConfigListener implements ServletContextListener {
    // Public constructor is required by servlet spec
    public ContextConfigListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
        try {
            Map<String, ControllerMapping> controllerMapping = new Configuration().config();
            /*
            request：请求 session：会话 application：全局作用域
             */
            sce.getServletContext().setAttribute("cn.guet.web.controller", controllerMapping);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
    }
}
