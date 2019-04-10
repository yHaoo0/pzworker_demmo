package com.pzdreamworks.demo.dao;

import com.pzdreamworks.demo.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {
     public List<Comment> findCommentsByBlogPostAndFloorReplyBetween(int blogPost, int head, int tail);
     public List<Comment> findCommentsByName(String name);
     public int countByBlogPostAndFloor(int postId, int floor);
     public int countByBlogPost(int postId);
}
