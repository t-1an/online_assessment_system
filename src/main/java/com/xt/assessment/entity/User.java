package com.xt.assessment.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户名(昵称)
     */
    @Size(min = 2, max = 64, message = "昵称长度必须在2-64个字符")
    private String username;

    /**
     * MD5加密后的密码
     */
    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 64, message = "密码合理长度为必须6-64个字符")
    private String password;

    /**
     * 邮箱
     */
    @Email(message = "邮箱必须合法")
    @NotNull(message = "邮箱不能为空")
    private String email;

    /**
     * 注册时间
     */
    private Date createTime;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    /**
     * 状态值：0：未激活1：已激活
     */
    private Integer status;
    /**
     * 随机码，用于激活用户
     */
    private String randomCode;
}
