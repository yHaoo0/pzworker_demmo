package com.pzdreamworks.demo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "blog_post")
    private int blog_post;

    @Column(name = "visitor_name")
    private String name;

    @Column(name = "floor")
    private int floor;

    @Column(name = "floor_reply")
    private int floor_reply;

    @Column(name = "comment_time")
    private Date time;

    @Column(name = "comment_text")
    private String text;

    @Column(name = "is_live")
    private boolean isLive;

    private Comment() {
    }

    protected Comment(int blog_post, String name, int floor, int floor_reply,
                    Date time, String text, boolean isLive) {
        this.blog_post = blog_post;
        this.name = name;
        this.floor = floor;
        this.floor_reply = floor_reply;
        this.time = time;
        this.text = text;
        this.isLive = isLive;
    }



    public int getId() {
        return id;
    }

    public int getBlog_post() {
        return blog_post;
    }

    public String getName() {
        return name;
    }

    public int getFloor() {
        return floor;
    }

    public int getFloor_reply() {
        return floor_reply;
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
}
