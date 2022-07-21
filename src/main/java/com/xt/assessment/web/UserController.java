package com.xt.assessment.web;

import com.alibaba.fastjson.JSONObject;
import com.xt.assessment.entity.User;
import com.xt.assessment.service.UserService;
import com.xt.assessment.utils.CommonUtils;
import com.xt.assessment.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
@Controller
public class UserController {
    private final UserService userService;
    private final CommonUtils commonUtils;

    public UserController(UserService userService, CommonUtils commonUtils) {
        this.userService = userService;
        this.commonUtils = commonUtils;
    }


    /**
     * <P>注册接口 </p>
     *
     * @param user： 映射的实体对象，result：参数校验的结果对象
     * @return JSON字符串
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register(@Valid @RequestBody User user, BindingResult result) {
        Map<String, Object> map = new HashMap<>(2);
        if (result.hasErrors()) {
            //获得第第一个错误
            FieldError error = result.getFieldErrors().get(0);
            //将错误信息放入msg
            map.put("msg", error.getDefaultMessage());
            map.put("code", 2);
            return map;
        }
        //user校验合法
        //看看邮箱有没有被用过
        User user0 = userService.queryUserByEmail(user.getEmail());
        if (user0 == null) {
            //new user
            user.setId(commonUtils.getUUID()).setPassword(commonUtils.encodeByMd5(user.getPassword())).setCreateTime(new Date()).setLastLoginTime(null).setStatus(0).setRandomCode(commonUtils.getUUID());
            if (userService.insertUser(user)) {
                //insert user success
                //发送激活邮件
                map.put("code", 0);
                map.put("msg", "ok");
                map.put("data", 0);
            } else {
                map.put("code", 1);
                map.put("msg", "insert database fail");
            }
        } else {
            //user exists
            //user not activate
            if (user0.getStatus() == 0) {
                user.setId(user0.getId()).setPassword(commonUtils.encodeByMd5(user.getPassword())).setCreateTime(user0.getCreateTime()).setLastLoginTime(null).setStatus(0).setRandomCode(commonUtils.getUUID());
                if (userService.updateUser(user)) {
                    map.put("code", 0);
                    map.put("msg", "ok");
                    map.put("data", 2);
                } else {
                    map.put("code", 1);
                    map.put("msg", "update database fail");
                }
            } else if (user0.getStatus() == 1) {
                //用户已激活
                map.put("code", 0);
                map.put("msg", "ok");
                map.put("data", 1);
            } else {
                map.put("code", 1);
                map.put("msg", "error data");
            }
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response, @Valid @RequestBody User user, BindingResult result) {
        Map<String, Object> map = new HashMap<>(3);

        //登录只需检验email和password
        if (result.hasErrors()) {
            //获得第第一个错误
            FieldError error = result.getFieldErrors().get(0);
            //将错误信息放入msg
            map.put("msg", error.getDefaultMessage());
            map.put("code", 2);
            return map;
        }
        //校验完毕
        User user0 = userService.queryUserByEmail(user.getEmail());
        // this user not exist
        if (user0 == null) {
            map.put("code", 0);
            map.put("msg", "user is not exists");
            JSONObject json = new JSONObject();
            json.put("result", 2);
            map.put("data", json);
        } else {
            //password is right
            if (user0.getPassword().equals(commonUtils.encodeByMd5(user.getPassword()))) {
                map.put("code", 0);
                JSONObject json = new JSONObject();
                if (user0.getStatus() == 1) {
                    //is activated
                    response.setHeader("token", request.getSession().getId());
                    map.put("msg", "ok");
                    json.put("result", 0);
                    json.put("token", request.getSession().getId());
                    json.put("username", user0.getUsername());
                    json.put("email", user0.getEmail());
                    //登录成功，将user存入session中
                    request.getSession().setAttribute("admin", user0);
                    //update user last login time
                    user0.setLastLoginTime(new Date());
                    userService.updateUser(user0);
                } else {
                    json.put("result", 3);
                    map.put("msg", "email is not activate");
                }
                map.put("data", json);
            } else {
                //error password
                map.put("code", 0);
                map.put("msg", "password error");
                JSONObject json = new JSONObject();
                json.put("result", 1);
                map.put("data", json);
            }
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/logout")
    public Map<String, Object> logout(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(2);

        //使当前session无效
        request.getSession().invalidate();
        map.put("code", Constants.SUCCESS_CODE);
        map.put("msg", Constants.SUCCESS_MSG);

        return map;
    }

}
