package com.xt.assessment.service;

import com.xt.assessment.entity.Logic;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
public interface LogicService {

    /**
     * 保存逻辑列表
     *
     * @param logics 规则列表
     * @param id     评估/模板ID
     * @param type   评估/模板
     * @return msg
     */
    String saveLogicList(List<Logic> logics, String id, String type);

    /**
     * 根据模板ID删除问题
     *
     * @param id   评估/模板ID
     * @param type 评估/模板
     * @return msg
     */
    String deleteLogicById(String id, String type);

    /**
     * 根据模板ID获取问题
     *
     * @param id   评估/模板ID
     * @param type 评估/模板
     * @return msg
     */
    List<Logic> getLogicList(String id, String type);
}
