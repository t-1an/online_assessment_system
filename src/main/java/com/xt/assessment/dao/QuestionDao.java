package com.xt.assessment.dao;

import com.xt.assessment.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */

@Repository
public interface QuestionDao {
    /**
     * 查询所有的Question,返回List<Question>
     *
     * @param questions 问题列表
     */
    void saveQuestionList(List<Question> questions);

    /**
     * 根据模板ID删除对应的问题
     *
     * @param templateId 模板ID
     */
    void deleteQuestionByTemplateId(String templateId);

    /**
     * 根据评估ID删除对应的问题
     *
     * @param assessmentId 评估ID
     */
    void deleteQuestionByAssessmentId(String assessmentId);

    /**
     * 根据模板ID查询问题
     *
     * @param templateId 模板ID
     * @return 问题列表
     */
    List<Question> getQuestionListByTemplateId(String templateId);

    /**
     * 根据评估ID查询问题
     *
     * @param assessmentId 模板ID
     * @return 问题列表
     */
    List<Question> getQuestionListByAssessmentId(String assessmentId);

    /**
     * 更新问题列表答案
     *
     * @param questions 问题列表
     */
    void updateQuestionList(List<Question> questions);
}
