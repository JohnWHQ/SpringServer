package com.web.service;

import com.web.repository.UserInfo;

public interface UserCenterService {
    UserInfo saveUserInfo(UserInfo userInfo);
    UserInfo findUserByUserId(String UserId);
}
