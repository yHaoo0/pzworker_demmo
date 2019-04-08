package com.pzdreamworks.demo.controller;

import com.pzdreamworks.demo.domain.LikeLog;
import com.pzdreamworks.demo.domain.Visitor;
import com.pzdreamworks.demo.service.LikeLogService;
import com.pzdreamworks.demo.service.VisitorService;
import com.pzdreamworks.demo.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class VisitorController {

    @Autowired
    private VisitorService visitorService;
    @Autowired
    private LikeLogService likeLogService;

    @PostMapping(name = "get_vistor_name")
    public HashMap getVistorName(HttpServletRequest request){
        HashMap result = new HashMap();
        String ip = IpUtil.getIpAddr(request);
        Visitor visitor = visitorService.getVisitor(ip);

        if(visitor == null){
            result.put("hava_name", false);
        }else {
            result.put("have_name", true);
            result.put("name", visitor.getName());
        }

        result.put("core", 200);
        return result;
    }

    @PostMapping(name = "add_vistor")
    public HashMap addVistor(HttpServletRequest request, String name){
        HashMap result = new HashMap();
        String ip = IpUtil.getIpAddr(request);

        Visitor visitor = visitorService.addVisitor(ip, name);
        if(visitor.getName().equals(name)){
            result.put("is_new_visitor", true);
        }else {
            result.put("is_new_visitor", false);
        }

        result.put("name", visitor.getName());
        result.put("core", 200);
        return result;
    }
}
