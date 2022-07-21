package com.xt.assessment.dao;

import com.xt.assessment.entity.Template;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/6
 */

@Repository
public interface TemplateDao {

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
     */
    void saveTemplate(Template template);

    /**
     * 更新模板
     *
     * @param template 模板
     */
    void updateTemplate(Template template);

    /**
     * 删除模板
     *
     * @param templateId 模板ID
     */
    void deleteTemplate(String templateId);

    /**
     * 根据模板ID查询模板详细信息
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
     */
    void changeTemplateStatus(@Param("templateId") String templateId, @Param("templateStatus") int templateStatus);
}
