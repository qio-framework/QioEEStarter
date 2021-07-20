package dev.support;

import qio.Qio;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        try {

            ServletContext servletContext = sce.getServletContext();

            new Qio.Injector()
                    .devMode(true)//tells qio to initialize h2
                    .asEmbedded(true)//yes, as we are using the maven jetty plugin
                    .withContext(servletContext)//qio needs this to storage information to be used later
                    .withWebResources(new String[]{ "assets" })//any directory within webapps that will serve static content
                    .withPropertyFiles(new String[]{ "app.props" })//our properties files
                    .inject();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context destroyed...");
    }
}
