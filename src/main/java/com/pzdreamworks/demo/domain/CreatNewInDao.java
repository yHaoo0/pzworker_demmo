package com.pzdreamworks.demo.domain;

public class CreatNewInDao {
    public static Visitor visitor(String ip, String name){
        return new Visitor(ip, name);
    }

    public static LikeLog likeLog(String ip, int id){
        return new LikeLog(ip, id);
    }
}
