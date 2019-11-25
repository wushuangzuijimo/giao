package com.woniuxy.serviceimpl;

import com.woniuxy.dao.UserMapper;
import com.woniuxy.domain.User;
import com.woniuxy.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;



@Service
@Transactional
public class IUserServiceImpl implements IUserService {

    @Resource
    private UserMapper usermapper;

    @Override
    public List<User> findAll() {

        List<User> list= usermapper.findAll();

        for (User user : list) {

            System.out.println(user);
        }
        return list;
    }

    @Override
    public void save(User user){


        usermapper.insert(user);

    }

    @Override
    public void update(User user) {
        usermapper.updateByPrimaryKey(user);


    }

    @Override
    public void delete(Integer uid) {

        usermapper.deleteByPrimaryKey(uid);

    }

    @Override
    public User findOne(Integer uid) {


        User user = usermapper.selectByPrimaryKey(uid);

        return user;
    }
}