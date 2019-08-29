package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    /** 使用“#参数名”或者“#p参数index”  #p0 第一个参数  #userName 的方式在sb2已经无效了
     * 这个方法用于替换我们平常写的某个查询，先从redis里面查找，如果redis没有，则从DB查询结果再放到redis里面
     * */
    @Cacheable(value="springRedisCache", key="'petstore:signon:'+#p0", unless="#result==null")
    User findByUserName(String userName);

    /**
     * @Author guoxiong@igetwell.cn
     * @Description 适用于 在更新和删除的时候，清空缓存  Evict：赶出
     * @Date 14:40 2019/8/29
     * @Param [userName]
     * @return void
     **/
    @Modifying
    @Query("update User set nickName = 'bearCacheEvict'  where nickName = :userName")
    @CacheEvict(value="springRedisCache", key="'petstore:signon:'+#p0")
    void updateByUserName(@Param(value = "userName") String userName);

    User findByUserNameOrEmail(String username, String email);

    // QuerySyntaxException: user is not mapped  注意query里面的表名和字段名都是java类实体的名称，而不是字段名称，不然就报错
    @Modifying
    @Query("update User set nickName = 'bear' where id in :ids")
    void updateByIds(@Param(value = "ids") List<Long> ids);

}
