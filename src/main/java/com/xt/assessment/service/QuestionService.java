package com.xt.assessment.service;

import com.xt.assessment.entity.Question;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
public interface QuestionService {

    /**
     * 保存问题列表（新建模板）
     *
     * @param questions 问题列表
     * @param id        评估/模板ID
     * @param type      评估/模板
     * @return msg
     */
    String saveQuestionList(List<Question> questions, String id, String type);

    /**
     * 更新问题列表答案
     *
     * @param questions 问题列表
     * @return msg
     */
    String updateQuestionList(List<Question> questions);

    /**
     * 根据ID删除问题
     *
     * @param id   评估/模板ID
     * @param type 评估/模板
     * @return msg
     */
    String deleteQuestionById(String id, String type);

    /**
     * 根据ID获取问题
     *
     * @param id   评估/模板ID
     * @param type 评估/模板
     * @return 问题列表
     */
    List<Question> getQuestionList(String id, String type);
}
