<%@page import="com.tech.blog.dao.Likedao"%>
<%@page import="com.tech.blog.dao.userdao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.entities.Category"%>
<%@page import="com.tech.blog.helper.connectionprovider"%>
<%@page import="com.tech.blog.entities.post"%>
<%@page import="com.tech.blog.dao.postdao"%>

<%@page import="com.tech.blog.entities.User"%>
<%@page errorPage="Error_page.jsp"%>
<% 
   User user = (User) session.getAttribute("currentUser");
if(user == null){
    response.sendRedirect("Login-page.jsp");
} 
else{
    
    
}




   %>
   
<%
int postId = Integer.parseInt(request.getParameter("post_id"));
postdao d = new postdao(connectionprovider.getConnection());
post p = d.getpostbypostid(postId);



    %>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=p.getPtitle()%></title>
          <!--css-->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
    <style>
  .banner-background{
      
       clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 100%, 70% 96%, 30% 100%, 0 94%, 0 1%);
   
  
  }
  .post-title{
      font-weight: 100;
      font-size: 30px;
  }  
  .post-content{
      font-weight: 100;
      font-size: 25px;
  }
  .post-userinfo{
      font-weight: 200;
      font-size: 20px;
  }
  .row-user{
   border:  2px solid #e2e2e2;  
   padding-top: 15px;
  }
  
  body{
      background: url(img/body.jpg);
      background-size: cover;
      background-attachment: fixed;
  }
  
 </style>
 <div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/hi_IN/sdk.js#xfbml=1&version=v16.0" nonce="oDq7jxOq"></script>
    </head>
    <body>
        
          <!--navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark primary-background">
    <a class="navbar-brand" href="index.jsp"><span class="fa fa-asterisk"></span> Techblog</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
          <a class="nav-link" href="profile.jsp"><span class="fa fa-bicycle"></span> Learn with shivam <span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <span class="fa fa-heart"></span> Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">programming language</a>
          <a class="dropdown-item" href="#">project implementation</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Data structure</a>
        </div>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="#"><span class="fa fa-address-book-o"></span> contact us</a>
      </li>
      
      <li class="nav-item">
          <a class="nav-link" href="#" data-toggle = "modal" data-target = "#add-post-modal"><span class="fa fa-asterisk"></span> Do Post</a>
      </li>
      
    
      
    </ul>
      <ul class="navbar-nav mr-right">
           <li class="nav-item">
          <!--<a href=""></a>-->
          <a class="nav-link" href="#!" data-toggle ="modal" data-target="#profile-modal"><span class="fa fa-user-circle"></span> <%= user.getName()%></a>
      </li>
          
          
            <li class="nav-item">
          <!--<a href=""></a>-->
          <a class="nav-link" href="LogoutServlet"><span class="fa fa-user-plus "></span> LogOut</a>
      </li>
          
      </ul>
      
      
      
      
      
  </div>
</nav>
      <!--navbar end-->
      
      <!--main content of  body-->
      <div class="conatiner">
          <div class="row my-4">
              <div class="col-md-8 offset-md-2">
                  
                  <div class="card">
                      <div class="card-header">
                          <h4 class="post-title"><%=p.getPtitle()%></h4>
                          
                      </div>
                          
                              <div class="card-body">
                                  
                           <img class="card-img-top mt-4" src="blog_pics/<%=p.getPic()%>"style="border-radius:10%; max-width: 350px; margin-left: 440px; margin-bottom: 20px; " alt="Card image cap">
                                  
                           
                           <div class="row my-4 row-user">
                               <div class="col-md-8">
                                   
                                     <%  userdao ds = new userdao(connectionprovider.getConnection());%>
                                       
                                   
                                   
                                   
                                   <p class="post-userinfo"><a href="#"><%= ds.userbyuserid(p.getUserid()).getName()%> </a>has posted</p>
                               </div>
                               <div class="col-md-4">
                                  <!--you have print here data afater data-->
                                   
                               </div>
                           </div>
                           
                                  
                           <p class="post-content"><%=p.getPcontent()%></p>
                                  
                                  <br>
                                  <br>
                                  <div class="post-code">
                                  <pre><%=p.getPcode()%></pre>
                                  </div>
                                  
                                  
                              </div>
                                  
                                  <div class="card-footer primary-background">
                                      <%
                                          
                               Likedao dl = new Likedao(connectionprovider.getConnection());
                               
                               

                                          %>
                                      
                                      
                                      
                                          <a href="#!" onclick="doLike(<%=p.getPid()%>,<%=user.getId()%>)" class="btn btn-outline-light btn-sm"><i class="fa fa-thumbs-o-up"></i><span class="like-counter"><%=dl.countlike(p.getPid())%><span></a>
                            
                                    <a href="#!" class="btn btn-outline-light btn-sm"><i class="fa fa-commenting-o"></i><span>20</span></a>
                                      
                                      
                                      
                                  </div>
                                          <div class="card-footer">
                                              
                                              
                                          <div class="fb-comments" data-href="http://localhost:8084/TechBlog/show_blog_page.jsp?post_id=<%=p.getPid()%>" data-width="" data-numposts="5"></div>    
                                              
                                          </div>
                                  
                                  
                                  
                      
                      
                  </div>
                  
              </div>
              
          </div>
          
      </div>
      
      
      
      
      
      
      
      
      
      <!--end of main body
      
      
      
      
      
      
      
      
      
        
 <!--profile Modal -->
<div class="modal fade" id="profile-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header primary-background text-white text-center">
          <h5 class="modal-title" id="exampleModalLabel">TechBlog</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="conatiner text-center">
              <img src="Pic/<%= user.getProfile()%>" class="img-fluid" style="border-radius:50%; max-width: 200px;"/>
              <br>
              
              <h5 class="modal-title" id="exampleModalLabel"><%= user.getName()%></h5>
              <!--details!-->
              <div id="profile-detail">      
      <table class="table">
 
  <tbody>
    <tr>
      <th scope="row">ID:</th>
      <td><%= user.getId()%></td>
     
     
    </tr>
    <tr>
      <th scope="row">Email:</th>
      <td><%= user.getEmail()%></td>
     
    </tr>
    <tr>
      <th scope="row">Gender:</th>
      <td><%=user.getGender()%></td>
      
    </tr>
    <tr>
      <th scope="row">Status:</th>
      <td><%=user.getAbout()%></td>
      
    </tr>
   
   
  </tbody>
</table>
              </div>
      
      
      <!--profile edit-->
      <div id="profile-edit " >
          <h2 class="mt-2"> please Edit carefully!!</h2>
          <!--enctype for image--> 
          <form action ="EditServlet" method="post" enctype="multipart/form-data">
              <table class="table" >
                  <tr>
                      <td>ID :</td>
                      <td><%=user.getId()%></td>
                  </tr>
                  <tr>
                      <td>Email :</td>
                      <td><input type="email" class="form-control" name=" user_email" value="<%=user.getEmail()%>"></td>
                  </tr>
                  <tr>
                      <td>Name :</td>
                      <td><input type="text" class="form-control" name=" user_name" value="<%=user.getName()%>"></td>
                  </tr>
                  <tr>
                      <td>Password :</td>
                      <td><input type="password" class="form-control" name=" user_pass" value="<%=user.getPassword()%>"></td>
                  </tr>
                  <tr>
                      <td>Status :</td>
                      <td>
                          <textarea rows="3" class = "form-control" name = "user_about">
                              <%= user.getAbout()%>
                          </textarea>
                      </td>
                  </tr>
                  <tr>
                      <td>New profile :</td>
                      <td>
                          <input type="file" name =" image" class=" form-control">
                      </td>
                  </tr>
                  
                  
                  
                  
              </table>
                          <div class="conainer">
                              <button type="submit" class="btn btn-outline-primary">Save</button>
                          </div>
              
          </form>
          
          
      </div>
      
              
              
          </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button id="edit-profile-button" type="button" class="btn btn-primary">Edit</button>
      </div>
    </div>
  </div>
</div>

<!--end of modal-->



  <!--add post modal-->
  
  <!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="add-post-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Provide the post detail</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <form action="addpostservlet" method="post" id="add-post-form">
              <div class="form-group">
                  <select class="form-control" name="cid">
                       <option selected disabled>---Select Category---</option>
                       <% 
                       postdao d1 = new postdao(connectionprovider.getConnection());
                       ArrayList<Category> list = d1.getcategories();
                       for(Category c:list){
                           
                       
                       
                       
                       %>
                       <option value="<%= c.getCid()%>"><%=c.getName()%></option>
                  
                  <%
                      }
                      %>
                      
              </select>
                  
              </div>
              
              
              
              
              <div class = "form-group">
                  <input name="pTitle" type="text" placeholder="Enter post title" class="form-control">
              </div>
              <div class = "form-group">
                  <textarea name="pContent" class="form-control" style="height: 200px;" placeholder="Enter your content" class = "form-control"></textarea>
                  
              </div>
              <div class = "form-group">
                  <textarea name="pCode" class="form-control" style="height:200px;" placeholder="Enter your programm(If Any)" class = "form-control"></textarea>
                  
              </div>
              
              <div  class="form-group">
                  <label>Select your Pic</label><br>
                  <input type="file" name="pic">
                  
              </div>
                      <div class="container text-center" >
                          <button type="submit" class="btn btn-outline-primary">Post</button>
                          
                      </div>
              
              
              
              
              
          </form>
          
          
          
          
      </div>
     
    </div>
  </div>
</div>
  
  
  
  <!--end post modal-->
  <!--javascript-->
       

<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
 
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<script src="js/myjs.js" type="text/javascript"></script>
        
<script>
 $(document).ready(function(){
     let editStatus = false;
     
     $('#edit-profile-button').click(function(){
         
//         alert("button clicked");
   if(editStatus ==false){
       
       $("#profile-detail").hide()
     
     $("#profile-edit").show()
     editStatus = true;
     $(this).text("Back");
   }
   else{
       $("#profile-detail").show()
     $("#profile-edit").hide()
     editStatus = false;
     $(this).text("Edit");
     
   }
     






     })
 })   
    
    
 </script>
 
 <!--now add post js using ajax-->
 
 
 <script>
     $(document).ready(function(){
        
        $("#add-post-form").on("submit",function(event){
            //this is called when form is submitted
            event.preventDefault();
//            console.log("done");
            let form = new FormData(this);
           //now requesting to server
           
           $.ajax({
               url:"addpostservlet",
               type:"POST",
               data:form,
               success:function(data,textStatus,jqXHR){
                   
                   //console.log(data);
                   if(data.trim() == 'done'){
                      swal("Good job!","saved successfully","success");
                   }
                   else{
                       swal("Error!","Something went wrong try again...","error");
                   }
                   
               },
               error:function (jqXHR,textStatus,errorThrown){
                   
               },
               processData :false,
               contentType:false
           })
            
            
        })
        
        
     })
     
     
     
     
     
     
 </script>

       
      
      
      
        
        
        
       
    </body>
</html>
