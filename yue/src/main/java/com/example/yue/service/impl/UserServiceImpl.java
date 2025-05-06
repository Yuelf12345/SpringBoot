package com.example.yue.service.impl;
import com.example.yue.entity.User;
import com.example.yue.entity.dto.UserDTO;
import com.example.yue.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.yue.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     * @param user
     */
    @Override
    public User addUser(UserDTO user) {
        User  userObj = new User();
        BeanUtils.copyProperties(user, userObj);
        return userMapper.save(userObj);
    }
    /**
     * 根据id查询用户
     * @param userId
     */
    @Override
    public User getUser(Integer userId) {
        return userMapper.findById(userId).orElseThrow(()->{
            throw new IllegalArgumentException("用户不存在");
        });
    }
    /**
     * 更新用户
     * @param user
     */
    @Override
    public User updateUser(UserDTO user) {
        User  userObj = new User();
        BeanUtils.copyProperties(user, userObj);
        return userMapper.save(userObj);
    }
    /**
     * 删除用户
     * @param userId
     */
    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteById(userId);
    }
}
