package com.xt.assessment.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/21
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Assessment {
    /**
     * 评估ID
     */
    private String assessmentId;
    /**
     * 评估名称
     */
    private String assessmentName;
    /**
     * 模板ID，根据此模板创建的评估
     */
    private String templateId;
    /**
     * 评估描述
     */
    private String description;
    /**
     * 评估状态
     * 0未评估 -1已失效 1已评估
     */
    private Integer assessmentStatus;
    /**
     * 评估创建人
     */
    private String assessmentCreator;
    /**
     * 评估人
     */
    private String toUser;
    /**
     * 评估人邮箱
     */
    private String toEmail;
    /**
     * 审核人
     */
    private String toUser2;
    /**
     * 审核人邮箱
     */
    private String toEmail2;
    /**
     * 创建日期
     */
    private Date assessmentCreateDate;
    /**
     * 问题列表
     */
    private List<Question> questions;
    /**
     * 逻辑列表
     */
    private List<Logic> logics;

}
