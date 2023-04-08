
package com.tech.blog.dao;
import com.tech.blog.entities.User;
import java.sql.*;
//import static org.omg.CORBA.AnySeqHelper.insert;

public class userdao {
    private Connection con;

    public userdao(Connection con) {
        
        this.con = con;
        
    }
    
    // method insert user to data base
    public boolean saveUser(User user){
          boolean f = false;
        try{
            //user database
          
            String query = "insert into user(name,email, password,gender,about)values(?,?,?,?,?)";
            PreparedStatement pstnt =    this.con.prepareStatement(query);
            pstnt.setString(1,user.getName());
            pstnt.setString(2,user.getEmail());
             pstnt.setString(3,user.getPassword());
              pstnt.setString(4,user.getGender());
//              pstnt.setString(5,user.getDatetime());
               pstnt.setString(5,user.getAbout());
              
             pstnt.executeUpdate();
            
           f = true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
        
        
    }
    //get email and password
    
    public User getmailandpass(String email,String password){
        User user = null;
        try{
            String query = "select * from user  where email =? and password =?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,email);
            pstmt.setString(2,password);
            
         ResultSet set =    pstmt.executeQuery();
         if(set.next()){
             user = new User();
             //data from database take
             String name =set.getString("name");
             
//             set to user object
          user.setName(name);
          
          user.setId(set.getInt("Id"));
          user.setEmail(set.getString("email"));
          user.setPassword(set.getString("Password"));
          user.setGender(set.getString("gender"));
          user.setAbout(set.getString("about"));
          user.setProfile(set.getString("profile"));
             
         }
            
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        
        return user;
        
    }
    
    public boolean getupdate(User user){
        boolean f = false;
        try{
            
            String querry = "update user set name = ?,email=?,password = ?,gender = ?,about =?,profile=? where id = ?";
            
            PreparedStatement p = con.prepareStatement(querry);
            p.setString(1,user.getName());
            p.setString(2,user.getEmail());
            p.setString(3,user.getPassword());
            p.setString(4,user.getGender());
            p.setString(5,user.getAbout());
            p.setString(6,user.getProfile());
            p.setInt(7,user.getId());
            
            
            p.executeUpdate();
            f = true;
            
        }
        catch(Exception e){
           e.printStackTrace();
        }
        return f;
        
    }
    
    
  public User userbyuserid(int userid){
    User user = null;
     try{
          String q = "Select * from user where id =?";
      PreparedStatement ps = con.prepareStatement(q);
      ps.setInt(1,userid);
      ResultSet set = ps.executeQuery();
      if(set.next()){
           user = new User();
             //data from database take
          String name =set.getString("name");
             
//             set to user object
          user.setName(name);
          
          user.setId(set.getInt("Id"));
          user.setEmail(set.getString("email"));
          user.setPassword(set.getString("Password"));
          user.setGender(set.getString("gender"));
          user.setAbout(set.getString("aboout"));
          user.setProfile(set.getString("profile"));
          
          
          
          
      }
      
         
         
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }      
      return user;
      
  }  
    
    
    
    
    
}
