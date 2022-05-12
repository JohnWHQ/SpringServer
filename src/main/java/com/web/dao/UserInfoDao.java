package com.web.dao;

import com.web.repository.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * DAO层示例
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
    @Query(value = "select * from user_info where user_id=?1", nativeQuery = true)
    UserInfo findByUserId(String userId);
}
