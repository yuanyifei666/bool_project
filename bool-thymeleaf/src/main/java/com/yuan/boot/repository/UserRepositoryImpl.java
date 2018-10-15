package com.yuan.boot.repository;

import com.yuan.boot.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 操作用户信息的具体实现
 */
@Repository
public class UserRepositoryImpl implements  UserRepository {

    private  AtomicLong id =  new AtomicLong(); //递增生成用户的id
    private  ConcurrentHashMap map = new ConcurrentHashMap(); //用于保存用户的信息


    /**
     * 更新或者更新用户的信息
     * @param user
     * @throws Exception
     */
    public void saveOrUpdate(User user) throws Exception {
        //根据user参数判断是执行添加操作还是修改操作
        if (user != null && user.getId() == null){
           // 执行添加操作
            user.setId((int)id.get());
        }
        //把用户的信息更新到map中
        map.put(user.getId(),user);
    }

    /**
     * 根据用户的id删除用户的信息
     * @param id
     * @throws Exception
     */
    public void deleteById(Integer id) throws Exception {
        //根据用户的id删除用户的信息
        if (map.contains(id)){
            map.remove(id);
        }else
        {
             throw new RuntimeException("该用户不存在！");
        }
    }

    /**
     * 查询所有的用户列表
     * @return
     * @throws Exception
     */
    public List<User> findAll() throws Exception {
        //得到所有的用户信息
        Collection values = map.values();
        return (List<User>)values;
    }

    /**
     * 根据用户id查询用户的信息
     * @param id
     * @return
     * @throws Exception
     */
    public User findBuId(Integer id) throws Exception {
        if (map.contains(id)){
            return (User) map.get(id);
        }else
        {
            return null;
        }
    }
}
