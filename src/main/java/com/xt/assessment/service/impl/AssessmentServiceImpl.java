package com.xt.assessment.service.impl;

import com.xt.assessment.dao.AssessmentDao;
import com.xt.assessment.entity.*;
import com.xt.assessment.service.*;
import com.xt.assessment.utils.CommonUtils;
import com.xt.assessment.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/6
 */
@Service
public class AssessmentServiceImpl implements AssessmentService {
    private final AssessmentDao assessmentDao;
    private final TemplateService templateService;
    private final QuestionService questionService;
    private final LogicService logicService;
    private final RiskService riskService;
    private final CommonUtils commonUtils;

    public AssessmentServiceImpl(AssessmentDao assessmentDao, TemplateService templateService, QuestionService questionService, LogicService logicService, RiskService riskService, CommonUtils commonUtils) {
        this.assessmentDao = assessmentDao;
        this.templateService = templateService;
        this.questionService = questionService;
        this.logicService = logicService;
        this.riskService = riskService;
        this.commonUtils = commonUtils;
    }


    /**
     * 启动评估
     *
     * @param assessment 评估
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String activeAssessment(Assessment assessment) {
        String assessmentId = commonUtils.getUUID();
        //获取模板
        Template template = templateService.getTemplate(assessment.getTemplateId());

        //将当前模板问题&逻辑存入评估表
        try {
            assessment.setAssessmentId(assessmentId);
            assessment.setQuestions(template.getQuestions());
            assessment.setLogics(template.getLogics());
            assessment.setAssessmentStatus(0);

            assessmentDao.saveAssessment(assessment);
            String msg = questionService.saveQuestionList(template.getQuestions(), assessmentId, Constants.ASSESSMENT);
            if (Constants.SUCCESS_MSG.equals(msg)) {
                msg = logicService.saveLogicList(template.getLogics(), assessmentId, Constants.ASSESSMENT);
            }
            return msg;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 评估列表
     *
     * @return 评估列表
     */
    @Override
    public List<Assessment> getAssessmentList() {
        return assessmentDao.getAssessmentList();
    }

    /**
     * 删除评估
     *
     * @param assessmentId 评估ID
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String deleteAssessment(String assessmentId) {
        try {
            assessmentDao.deleteAssessment(assessmentId);
            String msg = questionService.deleteQuestionById(assessmentId, Constants.ASSESSMENT);
            if (Constants.SUCCESS_MSG.equals(msg)) {
                msg = logicService.deleteLogicById(assessmentId, Constants.ASSESSMENT);
            }
            return msg;

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    /**
     * 根据ID获取评估问卷
     *
     * @param assessmentId 评估ID
     * @return 评估
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Assessment getAssessment(String assessmentId) {
        Assessment assessment = assessmentDao.getAssessment(assessmentId);
        List<Question> questions = questionService.getQuestionList(assessmentId, Constants.ASSESSMENT);
        List<Logic> logics = logicService.getLogicList(assessmentId, Constants.ASSESSMENT);
        assessment.setQuestions(questions);
        assessment.setLogics(logics);
        return assessment;

    }

    /**
     * 保存评估问卷 1保存问题答案 2 保存风险列表
     *
     * @param assessment 评估
     * @param risks      风险列表
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveAssessment(Assessment assessment, List<Risk> risks) {
        try {
            assessment.setAssessmentStatus(1);
            assessmentDao.updateAssessment(assessment);
            String msg = questionService.updateQuestionList(assessment.getQuestions());
            if (Constants.SUCCESS_MSG.equals(msg)) {
                msg = riskService.saveRisks(risks);
            }
            return msg;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
