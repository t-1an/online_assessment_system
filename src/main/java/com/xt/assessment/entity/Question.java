package com.xt.assessment.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
public class Question {

    /**
     * 问题ID
     */
    private String questionId;
    /**
     * 问题标号，用于前端排序
     */
    private Integer id;
    /**
     * 模板ID
     */
    private String templateId;
    /**
     * 评估ID
     */
    private String assessmentId;
    /**
     * 问题创建时间
     */
    private Date createTime;
    /**
     * 问题类型：
     * 'radio' 单选
     * 'checkbox' 多选
     * 'text' 填空
     * 'mark' 评分
     */
    private String questionType;
    /**
     * 问题标题
     */
    private String questionTitle;
    /**
     * 问题描述
     */
    private String description;
    /**
     * 问题的选项：[{"id":0, "optionTitle":"123"}]
     */
    private List<Map<String, Object>> options;
    /**
     * 问题的选项：用于存储数据库
     */
    private String optionString;
    /**
     * 是否可见 1可见 0隐藏
     */
    private Integer visible;
    /**
     * 是否必选 1是 0否
     */
    private Integer questionRequired;
    /**
     * 文本行数
     */
    private Integer row;
    /**
     * 评分最大数值
     */
    private Integer score;
    /**
     * 评估 | 模板
     */
    private String type;
    /**
     * 答案 用于存储
     */
    private String answerString;
    /**
     * 多选答案为list<int>
     */
    private List<Integer> answerList;
    /**
     * 单选答案为int
     */
    private Integer answerInt;
}