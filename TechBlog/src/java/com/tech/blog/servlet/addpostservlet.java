/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.blog.servlet;

import com.tech.blog.dao.postdao;
import com.tech.blog.entities.User;
import com.tech.blog.entities.post;
import com.tech.blog.helper.connectionprovider;
import com.tech.blog.helper.helper;
import java.io.File;
//import com.tech.blog.entities.post;
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
public class addpostservlet extends HttpServlet {

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
           
            int cid = Integer.parseInt(request.getParameter("cid"));
             String p = request.getParameter("pTitle");
              String pContent = request.getParameter("pContent");
               String pcode = request.getParameter("pCode");
               Part part = request.getPart("pic");
               // user id
               HttpSession session = request.getSession();
               
               User user  =(User) session.getAttribute("currentUser");
               
           
               
             
           // out.println("your post title is "+p);
//           out.println(part.getSubmittedFileName());
//           out.println(pContent);
            
          // out.println("pcode");
             
        post p1 = new post(p , pContent, pcode, part.getSubmittedFileName(), null, cid, user.getId()); 
           
        postdao dao = new postdao(connectionprovider.getConnection());
           if(dao.savePost(p1)){
              
//                String path = request.getRealPath("/")+"blog_pics"+File.separator+part.getSubmittedFileName();
//                helper.saveFile(part.getInputStream(), path);
                 out.println("done");
           }
           else{
            out.println("error");
        }
            
//            out.println("<h1>Servlet addpostservlet at " + request.getContextPath() + "</h1>");
           
          
            
            
            
           
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
