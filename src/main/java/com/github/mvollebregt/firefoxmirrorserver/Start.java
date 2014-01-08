package com.github.mvollebregt.firefoxmirrorserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Start {
  
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();
        context.setDescriptor("/WEB-INF/web.xml");
        context.setResourceBase("src/main/webapp");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        server.setHandler(context);

        server.start();
        server.join();
    }
}
