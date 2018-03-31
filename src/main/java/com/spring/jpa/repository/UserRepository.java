package com.spring.jpa.repository;

import com.spring.jpa.model.UserInfo;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByName(String name);

    UserInfo findById(String id);

    UserInfo findByIdAndName(String id, String name);
}
