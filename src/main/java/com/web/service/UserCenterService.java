package com.web.service;

import com.web.repository.UserInfo;

/**
 * service interface 示例
 */
public interface UserCenterService {
    UserInfo saveUserInfo(UserInfo userInfo);
    UserInfo findUserByUserId(String UserId);
}
