package com.csdj.serviceimpl;



import com.csdj.common.name;
import com.csdj.dao.UserMapper;
import com.csdj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserMapper userMapper;

    @Override
    public List<name> getAllUser()
    {
        return userMapper.selectAll();
    }
}
