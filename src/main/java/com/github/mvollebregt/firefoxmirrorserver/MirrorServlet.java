package com.github.mvollebregt.firefoxmirrorserver;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet that handles all incoming requests.
 */
public class MirrorServlet extends HttpServlet {

    private byte[] cachedContent = new byte[0];

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().write(cachedContent);
        resp.getOutputStream().close();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cachedContent = IOUtils.toByteArray(req.getInputStream());
    }
}
