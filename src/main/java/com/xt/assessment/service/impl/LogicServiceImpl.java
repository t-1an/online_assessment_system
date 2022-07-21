package com.xt.assessment.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xt.assessment.dao.LogicDao;
import com.xt.assessment.entity.Logic;
import com.xt.assessment.service.LogicService;
import com.xt.assessment.utils.CommonUtils;
import com.xt.assessment.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
@Service
public class LogicServiceImpl implements LogicService {
    private final LogicDao logicDao;
    private final CommonUtils commonUtils;

    public LogicServiceImpl(LogicDao logicDao, CommonUtils commonUtils) {
        this.logicDao = logicDao;
        this.commonUtils = commonUtils;
    }


    /**
     * 保存逻辑列表
     *
     * @param logics 规则列表
     * @param id     评估/模板ID
     * @param type   评估/模板
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveLogicList(List<Logic> logics, String id, String type) {
        if (logics.size() == 0) {
            return Constants.SUCCESS_MSG;
        }

        try {
            for (Logic logic : logics) {
                List<Map<String, Object>> conditions = logic.getConditions();
                String conditionString = JSON.toJSONString(conditions);
                List<Map<String, Object>> actions = logic.getActions();
                String actionString = JSON.toJSONString(actions);

                logic.setLogicId(commonUtils.getUUID());
                logic.setType(type);

                if (Constants.TEMPLATE.equals(type)) {
                    logic.setTemplateId(id);
                } else if (Constants.ASSESSMENT.equals(type)) {
                    logic.setAssessmentId(id);
                }

                logic.setConditionString(conditionString);
                logic.setActionString(actionString);
            }
            logicDao.saveLogicList(logics);
            return Constants.SUCCESS_MSG;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 根据模板ID删除问题
     *
     * @param id   评估/模板ID
     * @param type 评估/模板
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String deleteLogicById(String id, String type) {
        try {
            if (Constants.TEMPLATE.equals(type)) {
                logicDao.deleteLogicByTemplateId(id);
            } else if (Constants.ASSESSMENT.equals(type)) {
                logicDao.deleteLogicByAssessmentId(id);
            }

            return Constants.SUCCESS_MSG;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 根据模板ID获取问题
     *
     * @param id   评估/模板ID
     * @param type 评估/模板
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Logic> getLogicList(String id, String type) {
        List<Logic> logics = null;
        if (Constants.TEMPLATE.equals(type)) {
            logics = logicDao.getLogicListByTemplateId(id);
        } else if (Constants.ASSESSMENT.equals(type)) {
            logics = logicDao.getLogicListByAssessmentId(id);
        }
        if (logics != null && logics.size() > 0) {
            for (Logic logic : logics) {
                String conditionString = logic.getConditionString();
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> conditions = (List<Map<String, Object>>) JSONObject.parse(conditionString);
                logic.setConditions(conditions);

                String actionString = logic.getActionString();
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> actions = (List<Map<String, Object>>) JSONObject.parse(actionString);
                logic.setActions(actions);
            }
        }
        return logics;
    }
}
