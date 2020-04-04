package cn.eli.vue.controller;

import cn.eli.vue.api.CommonResult;
import cn.eli.vue.api.IErrorCode;
import cn.eli.vue.entity.User;
import cn.eli.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Eli Shaw
 * @Date: 2019-11-14 11:33:26
 * @Description：
 */
@RestController
public class LoginController {

    @Autowired
    UserService userservice;

    @RequestMapping(value = "admin/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody cn.eli.vue.entity.User user) {
        if(user != null && user.getUsername().trim().length() > 0 && user.getPassword().trim().length() > 0) {
            List<User> users = userservice.getUserByNameAndPWD(user.getUsername(), user.getPassword());
            if(users != null && users.size() > 0){
                 return CommonResult.success(user.getUsername());
            }
        }
        return CommonResult.validateFailed();
    }

    @RequestMapping(value = "admin/register", method = RequestMethod.POST)
    public CommonResult register(@RequestBody cn.eli.vue.entity.User user) {
        int succCount = userservice.addUser(user);
        System.out.println(succCount);
        if (succCount > 0)
            return CommonResult.success(user.getUsername());
        else
            return CommonResult.validateFailed();
    }

}
