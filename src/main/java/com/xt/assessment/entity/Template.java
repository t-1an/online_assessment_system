package com.xt.assessment.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/6
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Template {
    /**
     * 模板ID
     */
    private String templateId;
    /**
     * 模板名称
     */
    private String templateName;
    /**
     * 模板描述
     */
    private String description;
    /**
     * 模板状态
     * 0草稿 1已发布 -1已失效
     */
    private Integer templateStatus;
    /**
     * 模板创建人
     */
    private String templateCreator;
    /**
     * 模板创建日期
     */
    private Date templateCreateDate;
    /**
     * 问题列表
     */
    private List<Question> questions;
    /**
     * 逻辑列表
     */
    private List<Logic> logics;

}
