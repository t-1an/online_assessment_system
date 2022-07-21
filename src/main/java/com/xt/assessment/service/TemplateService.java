package com.xt.assessment.service;

import com.xt.assessment.entity.Template;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/6
 */

public interface TemplateService {

    /**
     * 查询所有模板
     *
     * @return 模板列表
     */
    List<Template> getTemplateList();

    /**
     * 保存模板
     *
     * @param template 模板
     * @return msg
     */
    String saveTemplate(Template template);

    /**
     * 删除模板
     *
     * @param templateId 模板ID
     * @return msg
     */
    String deleteTemplate(String templateId);

    /**
     * 根据templateId获取模板详情
     *
     * @param templateId 模板ID
     * @return 模板
     */
    Template getTemplate(String templateId);

    /**
     * 修改模板状态
     *
     * @param templateId     模板ID
     * @param templateStatus 0草稿 -1失效 1发布
     * @return msg
     */
    String changeTemplateStatus(String templateId, int templateStatus);
}
