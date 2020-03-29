package com.example.wadud.servlet;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Running Hello Servlet doMethod");
    }


    @WebFilter(filterName = "helloFilter", urlPatterns = "/helloServlet")
    public static class HelloFilter implements Filter {
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("Executing doFilter method");
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("Done executing doFilter method");
        }
    }

    @WebListener
    public static class HelloListeners implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent sce) {
            System.out.println("Servlet Context Initialized");
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            System.out.println("Servlet Context Destroyed");
        }
    }
}
