package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName UserRepository
 * @description 注释
 * @date 2019/8/27 21:06
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);

    // QuerySyntaxException: user is not mapped  注意query里面的表名和字段名都是java类实体的名称，而不是字段名称，不然就报错
    @Modifying
    @Query("update User set nickName = 'bear' where id in :ids")
    void updateByIds(@Param(value = "ids") List<Long> ids);
}
