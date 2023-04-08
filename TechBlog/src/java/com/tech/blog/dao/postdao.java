
package com.tech.blog.dao;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.tech.blog.entities.Category;
import com.tech.blog.entities.post;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class postdao {
    Connection con;

    public postdao(Connection con) {
        this.con = con;
    }
       
    public ArrayList<Category> getcategories(){
        ArrayList<Category> list = new ArrayList<>();
        try{
            
            
            
            String q = "select * from categories ";
            Statement st = this .con.createStatement();
            ResultSet set = st.executeQuery(q);
            while(set.next()){
                int cid = set.getInt("cid");
               String name = set.getString("name");
               String description = set.getString("description");
               Category  c = new Category(cid,name,description);
               list.add(c);
               
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        return list;
    }
    
    public boolean savePost(post p){
        boolean f = false;
        try{
           String q = "insert into post (ptitle,pcontent,pcode,ppic,catid,userid)values(?,?,?,?,?,?)";
                  PreparedStatement pstmt = con.prepareStatement(q);
                  pstmt.setString(1,p.getPtitle());
                  pstmt.setString(2, p.getPcontent());
                  pstmt.setString(3, p.getPcode());
                  pstmt.setString(4, p.getPic());
                  pstmt.setInt(5, p.getCatid());
                  pstmt.setInt(6, p.getUserid());
                  
                  pstmt.executeUpdate();
                   f= true;
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    
//  getallpost method
    
    public List<post>getallposts(){
        List<post> list = new ArrayList<>();
        //fetch all the post
        try{
            PreparedStatement p = con.prepareStatement("select *from post order by pid desc");
             ResultSet set = p.executeQuery();
             while(set.next())
             {
                 int pid = set.getInt("pid");
                 String ptitle = set.getString("ptitle");
                 String pcontent = set.getString("pcontent");
                 String pcode = set.getString("pcode");
                 String ppic = set.getString("ppic");
                 Timestamp datetime = set.getTimestamp("pdata");
                 int catid = set.getInt("catid");
                 int userid = set.getInt("userid");
                 post ppost = new post(pid, ptitle, pcontent, pcode, ppic, datetime, catid, userid);
                 list.add(ppost);
                 
             }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return list;
        
    }
    
    
  // list of post
   public List<post> getpostid(int catId){
       List<post> list = new ArrayList<>();
        //fetch all the post by id
        try{
            PreparedStatement p = con.prepareStatement("select *from post where catId =?");
            p.setInt(1,catId);
             ResultSet set = p.executeQuery();
             while(set.next())
             {
                 int pid = set.getInt("pid");
                 String ptitle = set.getString("ptitle");
                 String pcontent = set.getString("pcontent");
                 String pcode = set.getString("pcode");
                 String ppic = set.getString("ppic");
                 Timestamp datetime = set.getTimestamp("pdata");
                
                 int userid = set.getInt("userid");
            
                 post ppost = new post(pid, ptitle, pcontent, pcode, ppic, datetime,catId, userid);
                 list.add(ppost);
                 
             }
            
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        return list;
        
       
      
   } 
   
   
 public post getpostbypostid(int postid)
 {
     post post123 = null;
     String q = "select * from post where pid =?";
     try{
     PreparedStatement p = this.con.prepareStatement(q);
     p.setInt(1,postid);
     
     ResultSet set1 = p.executeQuery();
     
     if(set1.next()){
         
         
              int pid = set1.getInt("pid");
                 String ptitle = set1.getString("ptitle");
                 String pcontent = set1.getString("pcontent");
                 String pcode = set1.getString("pcode");
                 String ppic = set1.getString("ppic");
                 Timestamp datetime = set1.getTimestamp("pdata");
                 int cid = set1.getInt("catid");
                
                 int userid = set1.getInt("userid");
            
                 post123 = new post(pid, ptitle, pcontent, pcode, ppic, datetime,cid, userid);
         
         
         
         
         
     }
     
     
     
     }
     catch(Exception e){
         e.printStackTrace();
         
     }
     return post123;
     
 }  
   
   

}
