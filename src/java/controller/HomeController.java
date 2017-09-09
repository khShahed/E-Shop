package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeController", urlPatterns = {"/", "/home"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        index(request, response);
    }

    /**
     * The index view is rendered from this method.
     */
    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
       String view = "Views/Home/index.jsp";
       request.getRequestDispatcher(view).forward(request, response);
    }
}
