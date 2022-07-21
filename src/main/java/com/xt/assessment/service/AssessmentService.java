package com.xt.assessment.service;

import com.xt.assessment.entity.Assessment;
import com.xt.assessment.entity.Risk;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/6
 */

public interface AssessmentService {

    /**
     * 启动评估
     *
     * @param assessment 评估
     * @return msg
     */
    String activeAssessment(Assessment assessment);

    /**
     * 评估列表
     *
     * @return 评估列表
     */
    List<Assessment> getAssessmentList();

    /**
     * 删除评估
     *
     * @param assessmentId 评估ID
     * @return msg
     */
    String deleteAssessment(String assessmentId);

    /**
     * 根据ID获取评估问卷
     *
     * @param assessmentId 评估ID
     * @return 评估
     */
    Assessment getAssessment(String assessmentId);

    /**
     * 保存评估问卷 1保存问题答案 2 保存风险列表
     *
     * @param assessment 评估
     * @param risks      风险列表
     * @return msg
     */
    String saveAssessment(Assessment assessment, List<Risk> risks);
}
