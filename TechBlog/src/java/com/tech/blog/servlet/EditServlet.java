
package com.tech.blog.servlet;

import com.tech.blog.dao.userdao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.connectionprovider;
import com.tech.blog.helper.helper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author admin
 */
@MultipartConfig
public class EditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            String email = request.getParameter("user_email");
            String name = request.getParameter("user_name");
            String pass = request.getParameter("user_pass"); 
            String about = request.getParameter("user_about");
            
            Part part = request.getPart("image");
            String imagename = part.getSubmittedFileName();
            
            
//            get the user from the session


    HttpSession se = request.getSession();
     User user = (User)se.getAttribute("currentUser");
     user.setEmail(email);
     user.setPassword(pass);
     user.setProfile(imagename);
     user.setName(name);
     String oldFile = user.getProfile();
     user.setAbout(about);
            
//            update database
userdao obj1 = new userdao(connectionprovider.getConnection());
   boolean ans =  obj1.getupdate(user);
   if(ans){
//       out.println("updated to db");
       
       String path = request.getRealPath("/")+"Pic"+File.separator+user.getProfile();
        String oldpath = request.getRealPath("/")+"Pic"+File.separator+oldFile;
        if(!oldpath.equals("default.png")){
       helper.deleteFile(oldpath);
        }
       
       if(helper.saveFile(part.getInputStream(),path)){
           out.println("Profile Updated ...!");
            Message msg = new Message("Profile deatils Upated !","success","alert-success");
               se.setAttribute("msg", msg);
           
       }
   
       
       else{
           out.println("file not save successfully");
           
            Message msg = new Message("something went wrong !","error","alert-danger");
               se.setAttribute("msg", msg);
           
       
   }
       
       
       
       
       
   }
   else{
       out.println("not updated");
        Message msg = new Message("something went wrong !","error","alert-danger");
               se.setAttribute("msg", msg);
            
        }

   
   response.sendRedirect("profile.jsp");
            
            
            
            
//            out.println("<h1>Servlet EditServlet at " + request.getContextPath() + "</h1>");
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
