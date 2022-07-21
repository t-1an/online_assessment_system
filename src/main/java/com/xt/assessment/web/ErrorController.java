package com.xt.assessment.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 * @Description: 错误处理页
 */

@Controller
@RequestMapping("/error")
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {
    @Override
    public String getErrorPath() {
        return "error";
    }
}
