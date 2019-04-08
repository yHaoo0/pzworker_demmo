package com.pzdreamworks.demo.service;

import com.pzdreamworks.demo.dao.VisitorDao;
import com.pzdreamworks.demo.domain.CreatNewInDao;
import com.pzdreamworks.demo.domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {
    @Autowired
    private VisitorDao visitorDao;

    /**
     * 从ip中查询使用该ip被注册，如果没有，使用name注册一个新的ip
     * @param ip
     * @param name
     * @return
     */
    public Visitor addVisitor(String ip, String name){
        Visitor result = visitorDao.findByIp(ip);

        if(result == null){
            result = visitorDao.save(CreatNewInDao.visitor(ip, name));
        }
        return result;
    }

    /**
     * 从ip中查询一个游客对象。因为会存在返回null，建议使用getVisitor(ip, name)
     * @param ip
     * @return  当ip没注册的时候，返回null
     */
    public Visitor getVisitor(String ip){
        return visitorDao.findByIp(ip);
    }
}
