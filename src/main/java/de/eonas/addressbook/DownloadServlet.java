package de.eonas.addressbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpServletResponse r = getHttpServletResponse(resp);
        r.setContentType("text/plain");
        r.setHeader("Cache-Control", "max-age=3600");
        PrintWriter writer = r.getWriter();
        writer.write("OK");
        writer.close();
    }

    private HttpServletResponse getHttpServletResponse(HttpServletResponse resp) throws ServletException {
        try {
            Method getResponse = resp.getClass().getMethod("getResponse");
            Object response = getResponse.invoke(resp);
            return (HttpServletResponse) response;
        }
        catch (Exception e ) {
            throw new ServletException(e);
        }
    }
}
