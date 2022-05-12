package com.web.dao;

import com.web.repository.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * Created by wanghanqi on 2019/11/01.
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
    @Query(value = "select * from user_info where user_id=?1", nativeQuery = true)
    UserInfo findByUserId(String userId);
}
