package com.xt.assessment.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

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
public class Logic {
    private String logicId;
    private Integer id;
    private String logicTitle;
    private String templateId;
    private String assessmentId;
    private List<Map<String, Object>> conditions;
    private String conditionString;
    private List<Map<String, Object>> actions;
    private String actionString;
    private String type;

}