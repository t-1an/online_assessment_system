package com.xt.assessment.dao;

import com.xt.assessment.entity.Logic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */

@Repository
public interface LogicDao {
    /**
     * 保存逻辑列表
     *
     * @param logics 逻辑列表
     */
    void saveLogicList(List<Logic> logics);

    /**
     * 根据模板ID删除对应的逻辑
     *
     * @param templateId 模板ID
     */
    void deleteLogicByTemplateId(String templateId);

    /**
     * 根据评估ID删除对应的逻辑
     *
     * @param assessmentId 评估ID
     */
    void deleteLogicByAssessmentId(String assessmentId);

    /**
     * 根据模板ID获取逻辑
     *
     * @param templateId 模板ID
     * @return 逻辑列表
     */
    List<Logic> getLogicListByTemplateId(String templateId);

    /**
     * 根据评估ID获取逻辑
     *
     * @param assessmentId 评估ID
     * @return 逻辑列表
     */
    List<Logic> getLogicListByAssessmentId(String assessmentId);


}
