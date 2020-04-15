package com.james.admin.dao;

import com.james.admin.domain.Users;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UsersMapper {

    Users selectUsersByUserNameAndPassword(Users users);

}