package com.pzdreamworks.demo.dao;

import com.pzdreamworks.demo.domain.LikeLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeLogDao extends JpaRepository<LikeLog, Integer> {
    public int countByPostId(int postId);
    public LikeLog findByIpAndPostId(String ip, int postId);
}
