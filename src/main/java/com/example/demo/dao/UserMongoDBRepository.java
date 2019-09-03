package com.example.demo.dao;

import com.example.demo.entity.User;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName UserMongoDBRepository
 * @description 注释
 * @date 2019/9/3 22:13
 */
public interface UserMongoDBRepository {
    public void saveUser(User user);
    public User findUserByUserName(String userName);
    void deleteUserById(Long id);

    long updateUser(User user);
}
