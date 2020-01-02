package com.yhh.springsecurity.basic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuthoritiesMapper {
    int insert(Authorities record);

    int insertSelective(Authorities record);

    List<String> selectAuthoritiesByUserName(String username);
}