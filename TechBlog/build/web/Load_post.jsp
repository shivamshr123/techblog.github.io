<%--<%@page import="javafx.scene.input.KeyCode.I"%>--%>
<%@page import="com.tech.blog.entities.User"%>
<%@page import="com.tech.blog.dao.Likedao"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.entities.post"%>
<%@page import="com.tech.blog.dao.postdao"%>
<%@page import="com.tech.blog.helper.connectionprovider"%>
<!--this is load post page..-->


<div class="row">
    
<%
    User uu = (User)session.getAttribute("currentUser");
    
    
    
    
    
    
   Thread.sleep(1000);
  postdao p2 = new postdao(connectionprovider.getConnection()); 
  int cid = Integer.parseInt(request.getParameter("cid"));
  List<post> posts = null;
  if(cid ==0){
      posts = p2.getallposts();
  }
  else{
      posts= p2.getpostid(cid);
  }
  
 if(posts.size()==0){
     
     out.println("<h3 class='display-3 text-center'>NO Post int this Category...</h3>");
     return;
 }  

      for(post p :posts){
  %>
         
          
          <div class="col-md-6 mt-2">
              <div class="card">
                  <img class="card-img-top" src="blog_pics/<%=p.getPic()%>" style="border-radius:20%; max-width: 400px; margin-left: 90px; margin-top: 30px;" alt="Card image cap">
                  <div class="card-body">
                      <b><%= p.getPtitle()%></b>
                        <p><%= p.getPcontent()%></p>
                     
                      
                      
                  </div>
                        <div class="card-footer bg-primary text-center">
                           <%
                               Likedao dl =new Likedao(connectionprovider.getConnection());
                               

                               %>
                           
                               <a href="#!" onclick="doLike(<%=p.getPid()%>,<%=uu.getId()%>)" class="btn btn-outline-light btn-sm"><i class="fa fa-thumbs-o-up"></i><span class="like-counter"><%=dl.countlike(p.getPid())%></span></a>
                             <a href="show_blog_page.jsp?post_id=<%= p.getPid()%>" class="btn btn-outline-light btn-sm">Read More</a>
                            <a href="#!" class="btn btn-outline-light btn-sm"><i class="fa fa-commenting-o"></i><span>20</span></a>
                            
                        </div>    
                  
              </div>
              
              
              
          </div>
          
          
          
          
          
          
 <%
   }
%>
</div>