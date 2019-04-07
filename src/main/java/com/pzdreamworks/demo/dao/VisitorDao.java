package com.pzdreamworks.demo.dao;

import com.pzdreamworks.demo.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorDao extends JpaRepository<Visitor, Integer> {
    public Visitor findByIp(String ip);
}
