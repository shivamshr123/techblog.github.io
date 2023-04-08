
package com.tech.blog.dao;
//import java.sql.Connection;
import java.sql.*;
public class Likedao {
    Connection con;

    public Likedao(Connection con) {
        this.con = con;
    }
    
    
    
    public boolean insertLike(int pid, int uid)
    {
        boolean f = false;
        try{
            String q = "insert into Like1(pid,uid)values(?,?)";
            PreparedStatement pst = this.con.prepareStatement(q);
            //values set
            pst.setInt(1,pid);
            pst.setInt(2,uid);
            
            pst.executeUpdate();
             f=true;
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
        
        
        
    }
    
    
    public  int countlike(int pid){
        int count=0;
        String q = " select count(*)from Like1 where pid =?";
        try{
            PreparedStatement p =this.con.prepareStatement(q);
            p.setInt(1, pid);
            ResultSet set = p.executeQuery();
            if(set.next())
            {
                count= set.getInt("count(*)");
                
            }
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        return count;
    }
    
    
    
    
    public boolean isliked(int pid,int uid){
        boolean f = false;
        try{
            PreparedStatement pt = this.con.prepareStatement("select *from Like1 where pid=? and uid =?");
            pt.setInt(1,pid);
            pt.setInt(2,uid);
            
            ResultSet set = pt.executeQuery();
            if(set.next()){
                f=true;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        return f;
    }    
    
    
public boolean deletLike(int pid, int uid){
    boolean f = false;
    
    
    try{
        PreparedStatement pst = this.con.prepareStatement("delete from like1 where pid = ? and uuid =?");
        pst.setInt(1,pid);
        pst.setInt(2, uid);
        pst.executeUpdate();
        f=true;
        
        
    }catch(Exception e){
        e.printStackTrace();
        
    }
    
  return f;  
}
    
    
}
