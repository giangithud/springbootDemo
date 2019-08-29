package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.dao.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        // do insert
        /*userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));*/

        // do update
        User updateUser = userRepository.findByUserName("aa1");
        updateUser.setEmail("aa1@123.com");
        userRepository.save(updateUser);
        Assert.assertEquals(3, userRepository.findAll().size());


        List<Long> idList = new ArrayList<>();
        idList.add(12L);
        userRepository.updateByIds(idList);
        // 拼接的sql：where user0_.user_name=? or user0_.email=?  这种功能真尿性
        // Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
        // userRepository.delete(userRepository.findByUserName("aa1"));
    }
}
