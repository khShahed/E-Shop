package controller;

import entities.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.CategoryServices;

@WebServlet(name = "CategoryController", urlPatterns = {"/category/*"})
public class CategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * This method will invoke action methods based on the request url pattern.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String action = request.getRequestURI().split("/")[3];
        System.out.println("the URI is: "+request.getRequestURI());
        String view = "";
        
        switch (action) 
        {
            case "insert":
                view = this.insertAction(request, response);
                break;
            case "edit":
                view = this.editAction(request, response);
                break;
            case "delete":
                view = this.deleteAction(request, response);
                break;
            case "search":
                view = this.searchAction(request, response);
                break;
            case "get":
                view = this.getAction(request, response);
                break;
            case "index":
                view = this.getAllAction(request, response);
                break;
        }  
        getServletContext().getRequestDispatcher(view).forward(request, response);
    }

    private String insertAction(HttpServletRequest request, HttpServletResponse response) 
    {
        String view = "";
        
        if(request.getMethod().equalsIgnoreCase("GET"))
        {
            /**
             * the url for rendering view must start in the following format.
             */
            view = "/Views/category/add.jsp";
            List<Category> categoryList = new CategoryServices().getAll();
            request.setAttribute("categoryList", categoryList);
            return view;
        }
        else
        {
            Category category = new Category();
            
            category.setName(request.getParameter("name"));
            category.setDescription(request.getParameter("description"));
            category.setParentId(Integer.parseInt(request.getParameterValues("parentId")[0]));
            
            CategoryServices service =new CategoryServices();
            service.insert(category);
            
            view = "/messageDisplay.jsp";
            String message = "category created";
            /**
             * in the following link . = /shop/category
             */
            String redirectLink = "./index";
            String redirectPath = "Go to Category Index";
            
            request.setAttribute("message", message);
            request.setAttribute("redirectLink", redirectLink);
            request.setAttribute("redirectPath", redirectPath);
            return view;
        }
        
    }

    private String editAction(HttpServletRequest request, HttpServletResponse response) 
    {
        String view = "";
        return view;
    }

    private String deleteAction(HttpServletRequest request, HttpServletResponse response)
    {
        String view = "";
        return view;
    }

    private String searchAction(HttpServletRequest request, HttpServletResponse response) 
    {
        String view = "";
        return view;
    }

    private String getAction(HttpServletRequest request, HttpServletResponse response) 
    {
        String view = "";
        return view;
    }

    private String getAllAction(HttpServletRequest request, HttpServletResponse response) 
    {
        String view = "";
        
        if(request.getMethod().equalsIgnoreCase("GET"))
        {
            view = "/Views/category/index.jsp";
            
            List<Category> categoryList = new CategoryServices().getAll();
            request.setAttribute("categoryList", categoryList);
            /**
             * the following attribute is for a link to back home.
             */
            request.setAttribute("context", "/shop/");
        }
        return view;
    }


}
