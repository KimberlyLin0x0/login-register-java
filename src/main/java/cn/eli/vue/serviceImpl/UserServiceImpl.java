package cn.eli.vue.serviceImpl;


import cn.eli.vue.entity.User;
import cn.eli.vue.entity.UserMapper;
import cn.eli.vue.service.UserService;
import cn.eli.vue.utils.SecurityEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    private User user;

    @Override
    public List<User> getAllUser() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public List<User> getUserByName(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<User> users = this.userMapper.selectByExample(example);
        return users;
    }

    public List<User> getUserByNameAndPWD(String username,String password) {
        ;
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<User> users = this.userMapper.selectByExample(example);
//        criteria.andEqualTo("password",password);
        if(users != null && SecurityEncode.verify(password,users.get(0).getPassword())){
            return users;
        }
        return null;
    }

    @Override
    public int addUser(User user) {
        String securePassword = SecurityEncode.generate(user.getPassword());
        user.setPassword(securePassword);
        int succCount = userMapper.insertSelective(user);//避免添加空值
        return succCount;
    }
}
