package com.xt.assessment.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xt.assessment.dao.QuestionDao;
import com.xt.assessment.entity.Question;
import com.xt.assessment.service.QuestionService;
import com.xt.assessment.utils.CommonUtils;
import com.xt.assessment.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;
    private final CommonUtils commonUtils;

    public QuestionServiceImpl(QuestionDao questionDao, CommonUtils commonUtils) {
        this.questionDao = questionDao;
        this.commonUtils = commonUtils;
    }


    /**
     * 保存问题列表（新建模板）
     *
     * @param questions 问题列表
     * @param id        评估/模板ID
     * @param type      评估/模板
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveQuestionList(List<Question> questions, String id, String type) {
        try {
            for (Question question : questions) {
                List<Map<String, Object>> options = question.getOptions();
                String optionString = JSON.toJSONString(options);

                question.setQuestionId(commonUtils.getUUID());
                question.setType(type);

                if (Constants.TEMPLATE.equals(type)) {
                    question.setTemplateId(id);
                } else if (Constants.ASSESSMENT.equals(type)) {
                    question.setAssessmentId(id);
                }

                question.setCreateTime(new Date());
                question.setOptionString(optionString);
            }
            questionDao.saveQuestionList(questions);
        } catch (Exception e) {
            return e.getMessage();
        }

        return Constants.SUCCESS_MSG;
    }

    /**
     * 更新问题列表答案
     *
     * @param questions 问题列表
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateQuestionList(List<Question> questions) {
        try {
            for (Question question : questions) {
                if ("radio".equals(question.getQuestionType()) && question.getAnswerInt() != null) {
                    question.setAnswerString(question.getAnswerInt().toString());
                } else if ("checkbox".equals(question.getQuestionType()) && question.getAnswerList() != null) {
                    question.setAnswerString(JSON.toJSONString(question.getAnswerList()));
                }
            }
            questionDao.updateQuestionList(questions);
            return Constants.SUCCESS_MSG;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 根据ID删除问题
     *
     * @param id   评估/模板ID
     * @param type 评估/模板
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String deleteQuestionById(String id, String type) {
        try {
            if (Constants.TEMPLATE.equals(type)) {
                questionDao.deleteQuestionByTemplateId(id);
            } else if (Constants.ASSESSMENT.equals(type)) {
                questionDao.deleteQuestionByAssessmentId(id);
            }

            return Constants.SUCCESS_MSG;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 根据ID获取问题
     *
     * @param id   评估/模板ID
     * @param type 评估/模板
     * @return 问题列表
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Question> getQuestionList(String id, String type) {
        List<Question> questions = null;

        if (Constants.TEMPLATE.equals(type)) {
            questions = questionDao.getQuestionListByTemplateId(id);
        } else if (Constants.ASSESSMENT.equals(type)) {
            questions = questionDao.getQuestionListByAssessmentId(id);
        }

        if (questions != null && questions.size() > 0) {
            for (Question question : questions) {
                String optionString = question.getOptionString();
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> options = (List<Map<String, Object>>) JSONObject.parse(optionString);

                String answerString = question.getAnswerString();

                if ("radio".equals(question.getQuestionType())) {
                    if (answerString == null || "".equals(answerString)) {
                        question.setAnswerInt(null);
                    } else {
                        question.setAnswerInt(Integer.parseInt(answerString));
                    }
                } else if ("checkbox".equals(question.getQuestionType())) {
                    if (answerString == null || "".equals(answerString)) {
                        question.setAnswerList(new ArrayList<>());
                    } else {
                        @SuppressWarnings("unchecked")
                        List<Integer> answer = (List<Integer>) JSONObject.parse(answerString);
                        question.setAnswerList(answer);
                    }

                }
                question.setOptions(options);

            }
        }

        return questions;
    }
}
