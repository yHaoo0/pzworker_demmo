
package com.pzdreamworks.demo.service;

import com.pzdreamworks.demo.dao.LikeLogDao;
import com.pzdreamworks.demo.domain.CreatNewInDao;
import com.pzdreamworks.demo.domain.LikeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeLogService {
    @Autowired
    private LikeLogDao likeLogDao;

    /**
     * 添加点赞
     * @param ip    游客的ip地址
     * @param postId    被点赞的博文id
     * @return  当点赞添加到日记中，返回true，否则返回false
     */
    public boolean addLike(String ip, int postId){
        try{
            likeLogDao.save(CreatNewInDao.likeLog(ip, postId));
            return true;
        }catch (Exception e){

        }
        return false;
    }

    /**
     * 取消点赞
     * @param ip    游客的ip地址
     * @param postId    被点赞的博文id
     * @return  当点赞从日记中取消，返回true，否则返回false
     */
    public boolean cancelLike(String ip, int postId){
        LikeLog likeLog = likeLogDao.findByIpAndPostId(ip, postId);
        if(likeLog != null){
            likeLogDao.delete(likeLog);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 从log计数某个博文被点赞的次数
     * @param postId    博文id
     * @return  博文被点赞的次数
     */
    public int count(int postId){
        return likeLogDao.countByPostId(postId);
    }

}
