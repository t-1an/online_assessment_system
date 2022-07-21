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
public class RiskLibrary {
    /*
     * 风险库Id
     * */
    private String riskLibraryId;
    /*
    * 风险模版
    * */
    private String module;
    /*
     * 风险名称
     * */
    private String name;
    /*
     * 风险描述
     * */
    private String description;
    /*
     * 固有风险级别
     * */
    private Integer inherentLevel;
    /*
     * 目标风险级别
     * */
    private Integer targetLevel;
    /*
     * 类别
     * */
    private String type;
    /*
     * 威胁
     * */
    private Integer threaten;
    /*
     * 漏洞
     * */
    private String leak;
    /*
     * 处理计划
     * */
    private String plan;
    /*
     * 状态
     * */
    private Integer status;
}