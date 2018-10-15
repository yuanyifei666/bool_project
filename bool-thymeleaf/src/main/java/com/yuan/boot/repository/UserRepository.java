package com.yuan.boot.repository;

import com.yuan.boot.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户的数据访问层
 */
public interface UserRepository {

    /** 实现添加或者更新用户信息**/
    public void saveOrUpdate(User user)throws Exception;

    /** 实现根据用户的id删除相应的用户信息**/
    public void deleteById(Integer id)throws Exception;


    /**查询所有的用户列表 **/
    public List<User> findAll()throws Exception;


    /** 根据用户的id得到相应的用户户信息**/
    public User findBuId(Integer id)throws Exception;

}
