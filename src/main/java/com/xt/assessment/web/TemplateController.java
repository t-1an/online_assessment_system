package com.xt.assessment.web;

import com.xt.assessment.entity.Template;
import com.xt.assessment.service.TemplateService;
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
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    /**
     * 查询所有模板
     */
    @ResponseBody
    @RequestMapping(value = "/getTemplateList", method = RequestMethod.GET)
    public Map<String, Object> getTemplateList() {
        Map<String, Object> map = new HashMap<>(3);

        List<Template> list = templateService.getTemplateList();

        map.put("code", Constants.SUCCESS_CODE);
        map.put("msg", Constants.SUCCESS_MSG);
        map.put("data", list);
        return map;
    }

    /**
     * 保存模板
     */
    @ResponseBody
    @RequestMapping(value = "/saveTemplate", method = RequestMethod.POST)
    public Map<String, Object> saveTemplate(@RequestBody Template template) {
        Map<String, Object> map = new HashMap<>(2);

        String msg = templateService.saveTemplate(template);

        map.put("msg", msg);

        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }

        return map;
    }

    /**
     * 删除模板
     */
    @ResponseBody
    @RequestMapping(value = "/deleteTemplate", method = RequestMethod.POST)
    public Map<String, Object> deleteTemplate(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(2);

        String msg = templateService.deleteTemplate(data.get("templateId"));

        map.put("msg", msg);

        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }

        return map;
    }

    /**
     * 根据templateId获取模板详情
     */
    @ResponseBody
    @RequestMapping(value = "/getTemplate", method = RequestMethod.POST)
    public Map<String, Object> getTemplate(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(3);

        Template template = templateService.getTemplate(data.get("templateId"));

        map.put("code", Constants.SUCCESS_CODE);
        map.put("msg", Constants.SUCCESS_MSG);
        map.put("data", template);
        return map;
    }

    /**
     * 发布模板
     */
    @ResponseBody
    @RequestMapping(value = "/publishTemplate", method = RequestMethod.POST)
    public Map<String, Object> publishTemplate(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(2);

        String msg = templateService.changeTemplateStatus(data.get("templateId"), 1);

        map.put("msg", msg);

        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }

        return map;
    }
}
