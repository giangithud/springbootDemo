package com.example.demo.mapper.test2;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName UserMapper
 * @description 注释
 * @date 2019/8/29 23:11
 */
//@Mapper
@Repository("userMapper2")
public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "nickName",  column = "nick_name"),
            @Result(property = "passWord", column = "pass_word")
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "nickName",  column = "nick_name"),
            @Result(property = "passWord", column = "pass_word")
    })
    User getOne(Long id);

    @Insert("INSERT INTO user(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(User user);

    @Update("UPDATE user SET user_name=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);


    List<User> getAllXml();

    User getOneXml(@Param("id") Long id);

    void insertXml(User user);

    void updateXml(User user);

    void deleteXml(Long id);

}
