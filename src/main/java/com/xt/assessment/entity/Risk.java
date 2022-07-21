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
public class Risk {
    /**
     * 风险ID
     */
    private String riskId;
    /**
     * 评估Id
     */
    private String assessmentId;
    /**
     * 评估名称
     */
    private String assessmentName;
    /**
     * id 用于页面排序
     */
    private Integer id;
    /**
     * 描述
     */
    private String description;
    /**
     * 评分
     */
    private Integer score;
    /**
     * 状态 0未解决 1已解决 -1已失效
     */
    private Integer riskStatus;
    /**
     * 留言
     */
    private String comment;
}