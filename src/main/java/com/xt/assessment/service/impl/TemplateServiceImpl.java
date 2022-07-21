package com.xt.assessment.service.impl;

import com.xt.assessment.dao.TemplateDao;
import com.xt.assessment.entity.Logic;
import com.xt.assessment.entity.Question;
import com.xt.assessment.entity.Template;
import com.xt.assessment.service.LogicService;
import com.xt.assessment.service.QuestionService;
import com.xt.assessment.service.TemplateService;
import com.xt.assessment.utils.CommonUtils;
import com.xt.assessment.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/6
 */
@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateDao templateDao;

    @Autowired
    private QuestionService questionService;
    @Autowired
    private LogicService logicService;
    @Autowired
    private CommonUtils commonUtils;


    /**
     * 查询所有模板
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Template> getTemplateList() {
        return templateDao.getTemplateList();
    }

    /**
     * 保存模板
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveTemplate(Template template) {
        String templateId = template.getTemplateId();
        String msg = Constants.SUCCESS_MSG;

        try {
            if (null == templateId || "".equals(templateId)) {
                //保存
                templateId = commonUtils.getUUID();
                template.setTemplateId(templateId);

                templateDao.saveTemplate(template);
                msg = questionService.saveQuestionList(template.getQuestions(), templateId, Constants.TEMPLATE);
                if (Constants.SUCCESS_MSG.equals(msg)) {
                    msg = logicService.saveLogicList(template.getLogics(), templateId, Constants.TEMPLATE);
                }
            } else {
                //更新
                templateDao.updateTemplate(template);
            }
            return msg;
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    /**
     * 删除模板
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String deleteTemplate(String templateId) {
        try {
            templateDao.deleteTemplate(templateId);
            String msg = questionService.deleteQuestionById(templateId, Constants.TEMPLATE);
            if (Constants.SUCCESS_MSG.equals(msg)) {
                msg = logicService.deleteLogicById(templateId, Constants.TEMPLATE);
            }
            return msg;

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 根据templateId获取模板详情
     *
     * @param templateId 模板ID
     * @return 模板
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Template getTemplate(String templateId) {
        Template template = templateDao.getTemplate(templateId);
        List<Question> questions = questionService.getQuestionList(templateId, Constants.TEMPLATE);
        List<Logic> logics = logicService.getLogicList(templateId, Constants.TEMPLATE);
        template.setQuestions(questions);
        template.setLogics(logics);
        return template;
    }

    /**
     * 转换模板状态
     *
     * @param templateId     模板ID
     * @param templateStatus 状态
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String changeTemplateStatus(String templateId, int templateStatus) {
        try {
            templateDao.changeTemplateStatus(templateId, templateStatus);
            return Constants.SUCCESS_MSG;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
