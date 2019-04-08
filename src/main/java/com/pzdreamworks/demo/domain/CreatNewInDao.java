package com.pzdreamworks.demo.domain;

import java.util.Date;

public class CreatNewInDao {
    public static Comment creadNewComment(int blog_post, String name, int floor,
                                          int floor_reply, String text) {
        Date time = new Date();
        return new Comment(blog_post, name, floor, floor_reply, time, text, true);
    }

    public static Visitor visitor(String ip, String name) {
        return new Visitor(ip, name);
    }

    public static LikeLog likeLog(String ip, int id) {
        return new LikeLog(ip, id);
    }
}