package com.pzdreamworks.demo.service;

import com.pzdreamworks.demo.domain.CreatNewInDao;
import com.pzdreamworks.demo.domain.LikeLog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class LikeLogServiceTest {
    @Autowired
    public LikeLogService service;

    public LikeLog likeLog;
    public int count;

    @Before
    public void before() {
        likeLog = CreatNewInDao.likeLog("127.0.0.1", 0);
        count = service.count(0);
    }

    @Test
    public void addLike() {
        service.addLike(likeLog.getIp(), likeLog.getPostId());
        assertEquals(count + 1, service.count(likeLog.getPostId()));
    }

    @Test
    public void cancelLike() {
        service.cancelLike(likeLog.getIp(), likeLog.getPostId());
        assertEquals(count - 1, service.count(likeLog.getPostId()));
    }
}