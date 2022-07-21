package com.xt.assessment.dao;

import com.xt.assessment.entity.Assessment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/6
 */

@Repository
public interface AssessmentDao {

    /**
     * 保存评估
     *
     * @param assessment 评估
     */
    void saveAssessment(Assessment assessment);

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
     */
    void deleteAssessment(String assessmentId);

    /**
     * 根据ID获取评估问卷
     *
     * @param assessmentId 评估ID
     * @return 评估
     */
    Assessment getAssessment(String assessmentId);

    /**
     * 更新评估
     *
     * @param assessment 评估
     */
    void updateAssessment(Assessment assessment);
}
