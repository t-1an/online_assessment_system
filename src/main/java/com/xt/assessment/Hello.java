package com.xt.assessment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
@RestController
@Slf4j
public class Hello {


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String hello(HttpServletRequest request) {
        request.getSession().setAttribute("key", "1234");
        System.out.println(request.getSession().getId());
        log.info("test url");
        return "Hello SpringBoot!";
    }

    @RequestMapping(value = "/test/admin", method = RequestMethod.GET)
    public String testAdmin() {
        return "Hello admin";
    }

    @RequestMapping(value = "nologin")
    public String noLogin() {
        return "you haven't login!";
    }

}
