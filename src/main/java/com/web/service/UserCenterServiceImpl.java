package com.web.service;

import com.web.dao.UserInfoDao;
import com.web.repository.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service implements 示例
 */
@Service
public class UserCenterServiceImpl implements UserCenterService {
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        return userInfoDao.save(userInfo);
    }

    @Override
    public UserInfo findUserByUserId(String userId) {
        return userInfoDao.findByUserId(userId);
    }
}
