package xyz.shi.shop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.shi.shop.common.Result;
import xyz.shi.shop.common.user.UserBO;
import xyz.shi.shop.user.mapper.UserMapper;
import xyz.shi.shop.user.pojo.User;
import xyz.shi.shop.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result findUser(Long id) {
        User user = userMapper.selectById(id);
        if (user == null){
            return Result.success(null);
        }
        UserBO userBO = new UserBO();
        userBO.setAccount(user.getAccount());
        userBO.setId(user.getId());
        return Result.success(userBO);
    }
}