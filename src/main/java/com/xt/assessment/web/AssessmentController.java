package com.xt.assessment.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xt.assessment.entity.Assessment;
import com.xt.assessment.entity.Risk;
import com.xt.assessment.service.AssessmentService;
import com.xt.assessment.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/6
 */

@Controller
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    /**
     * 启动评估
     */
    @ResponseBody
    @RequestMapping(value = "/activeAssessment", method = RequestMethod.POST)
    public Map<String, Object> saveTemplate(@RequestBody Assessment assessment) {
        Map<String, Object> map = new HashMap<>(2);

        String msg = assessmentService.activeAssessment(assessment);

        map.put("msg", msg);

        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }

        return map;
    }

    /**
     * 评估列表
     */
    @ResponseBody
    @RequestMapping(value = "/getAssessmentList", method = RequestMethod.GET)
    public Map<String, Object> getAssessmentList() {
        Map<String, Object> map = new HashMap<>(3);

        List<Assessment> list = assessmentService.getAssessmentList();

        map.put("code", Constants.SUCCESS_CODE);
        map.put("msg", Constants.SUCCESS_MSG);
        map.put("data", list);
        return map;
    }

    /**
     * 删除评估
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAssessment", method = RequestMethod.POST)
    public Map<String, Object> deleteAssessment(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(2);

        String msg = assessmentService.deleteAssessment(data.get("assessmentId"));

        map.put("msg", msg);

        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }

        return map;
    }

    /**
     * 根据ID获取评估问卷
     */
    @ResponseBody
    @RequestMapping(value = "/getAssessment", method = RequestMethod.POST)
    public Map<String, Object> getAssessment(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(3);

        Assessment assessment = assessmentService.getAssessment(data.get("assessmentId"));

        map.put("code", Constants.SUCCESS_CODE);
        map.put("msg", Constants.SUCCESS_MSG);
        map.put("data", assessment);
        return map;
    }

    /**
     * 保存评估问卷
     */
    @ResponseBody
    @RequestMapping(value = "/saveAssessment", method = RequestMethod.POST)
    public Map<String, Object> saveAssessment(@RequestBody Map<String, Object> data) {
        Map<String, Object> map = new HashMap<>(2);


        Assessment assessment = JSON.parseObject(JSON.toJSONString(data.get("assessment")), Assessment.class);
        List<Risk> risks = JSON.parseObject(JSON.toJSONString(data.get("risks")), new TypeReference<List<Risk>>() {
        });

        String msg = assessmentService.saveAssessment(assessment, risks);
        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
            map.put("msg", Constants.SUCCESS_MSG);
        } else {
            map.put("code", 1);
            map.put("msg", msg);
        }

        return map;
    }
}
