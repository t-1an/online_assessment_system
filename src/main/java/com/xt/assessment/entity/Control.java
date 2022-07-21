package com.xt.assessment.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/20
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Control {
    /**
     * 控制ID
     */
    private String controlId;
    /**
     * 控制名称
     */
    private String controlName;
    /**
     * 状态 0待处理 1活动状态 2已归档
     */
    private Integer controlStatus;
    /**
     * 描述
     */
    private String comment;
    /**
     * 控制框架
     */
    private Integer controlFrame;
    /**
     * 控制类别
     */
    private Integer controlType;
    /**
     * 实施指南
     */
    private String controlDirection;

}