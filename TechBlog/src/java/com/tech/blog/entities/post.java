
package com.tech.blog.entities;

import java.sql.Timestamp;


public class post {
    private int pid;
    private String ptitle;
    private String pcontent;
    private String Pcode;
    private String pic;
    private Timestamp pdate;
    private int catid;
    private int userid;

    public post(int pid, String ptitle, String pcontent, String Pcode, String pic, Timestamp pdate, int catid ,int userid) {
        this.pid = pid;
        this.ptitle = ptitle;
        this.pcontent = pcontent;
        this.Pcode = Pcode;
        this.pic = pic;
        this.pdate = pdate;
        this.catid = catid;
        this.userid = userid; 
    }

    public post() {
    }

    public post(String ptitle, String pcontent, String Pcode, String pic, Timestamp pdate, int catid, int userid) {
        this.ptitle = ptitle;
        this.pcontent = pcontent;
        this.Pcode = Pcode;
        this.pic = pic;
        this.pdate = pdate;
        this.catid = catid;
        this.userid = userid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public String getPcode() {
        return Pcode;
    }

    public void setPcode(String Pcode) {
        this.Pcode = Pcode;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Timestamp getPdate() {
        return pdate;
    }

    public void setPdate(Timestamp pdate) {
        this.pdate = pdate;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
