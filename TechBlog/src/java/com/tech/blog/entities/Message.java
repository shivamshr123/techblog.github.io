
package com.tech.blog.entities;



public class Message
{
    private String content;
    private String type;
    private String Cssclass;
    
    //constructor

    public Message(String content, String type, String Cssclass) {
        this.content = content;
        this.type = type;
        this.Cssclass = Cssclass;
    }
//getter and setter
 public String getContent(){
     
        return content;
        
    }
public void setContent(String content) {
    
        this.content = content;
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCssclass() {
        return Cssclass;
    }

    public void setCssclass(String Cssclass) {
        this.Cssclass = Cssclass;
    }

   
    
    
    
    
    
}
