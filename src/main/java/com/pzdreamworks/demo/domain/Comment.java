package com.pzdreamworks.demo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment implements Comparable<Comment>{
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "blog_post")
    private int blogPost;

    @Column(name = "visitor_name")
    private String name;

    @Column(name = "floor")
    private int floor;

    @Column(name = "floor_reply")
    private int floorReply;

    @Column(name = "comment_time")
    private Date time;

    @Column(name = "comment_text")
    private String text;

    @Column(name = "is_live")
    private boolean isLive;

    private Comment() {
    }

    protected Comment(int blogPost, String name, int floor, int floorReply,
                      Date time, String text, boolean isLive) {
        this.blogPost = blogPost;
        this.name = name;
        this.floor = floor;
        this.floorReply = floorReply;
        this.time = time;
        this.text = text;
        this.isLive = isLive;
    }



    public int getId() {
        return id;
    }

    public int getBlogPost() {
        return blogPost;
    }

    public String getName() {
        return name;
    }

    public int getFloor() {
        return floor;
    }

    public int getFloorReply() {
        return floorReply;
    }

    public Date getTime() {
        return time;
    }

    public String getText() {
        return text;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public int compareTo(Comment o) {
        if(this.floor < o.floor){
            return -1;
        }else if(this.floor > o.floor){
            return 1;
        }else {
            if(this.floorReply < o.floor){
                return -1;
            }else if(this.floorReply > o.floorReply){
                return 1;
            }else {
                return 0;
            }
        }
    }
}
