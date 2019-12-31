package com.yhh.springsecurity.jettydbbasicauthentication.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuthoritiesMapper {
    List<String> selectByUsername(String username);

    int insert(Authorities record);

    int insertSelective(Authorities record);
}