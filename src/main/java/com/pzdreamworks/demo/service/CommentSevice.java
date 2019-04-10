package com.pzdreamworks.demo.service;

import com.pzdreamworks.demo.dao.CommentDao;
import com.pzdreamworks.demo.domain.Comment;
import com.pzdreamworks.demo.domain.CreatNewInDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CommentSevice {
    @Autowired
    private CommentDao commentDao;

    public List<Comment> getComments(int postId, int page, int size){
        int head = (page - 1)*size;
        List<Comment> comments = commentDao.findCommentsByBlogPostAndFloorReplyBetween(postId, head, head + size);
        Collections.sort(comments);
        return comments;
    }

    public void deleteComment(int commentId){
        commentDao.deleteById(commentId);
    }

    public List<Comment> addComment(int postId, int floor, String name, String context, int size){
        Comment newComent;
        int page;
        int countByPost = commentDao.countByBlogPost(postId);
        int countByFloor = commentDao.countByBlogPostAndFloor(postId, floor);

        if(countByPost >= floor){
            newComent = CreatNewInDao.creadNewComment(postId, name, floor, countByFloor, context);
            page = floor / size + 1;
        }else {
            newComent = CreatNewInDao.creadNewComment(postId, name, countByPost + 1, countByFloor, context);
            page = 1;
        }
        commentDao.save(newComent);

        return getComments(postId, page, size);
    }


}
