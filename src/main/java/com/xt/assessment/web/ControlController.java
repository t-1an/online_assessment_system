package com.xt.assessment.web;

import com.xt.assessment.entity.Control;
import com.xt.assessment.service.ControlService;
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
public class ControlController {

    private final ControlService controlService;

    public ControlController(ControlService controlService) {
        this.controlService = controlService;
    }

    /**
     * 控制列表
     */
    @ResponseBody
    @RequestMapping(value = "/getControlList", method = RequestMethod.POST)
    public Map<String, Object> getControlList(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(3);

        List<Control> list = controlService.getControlList();

        map.put("code", Constants.SUCCESS_CODE);
        map.put("msg", Constants.SUCCESS_MSG);
        map.put("data", list);
        return map;
    }

    /**
     * 新增控制
     */
    @ResponseBody
    @RequestMapping(value = "/addControl", method = RequestMethod.POST)
    public Map<String, Object> addControl(@RequestBody Control control) {
        Map<String, Object> map = new HashMap<>(2);

        String msg = controlService.addControl(control);

        map.put("msg", msg);
        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }
        return map;
    }

    /**
     * 删除资产
     */
    @ResponseBody
    @RequestMapping(value = "/deleteControl", method = RequestMethod.POST)
    public Map<String, Object> deleteControl(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(3);

        String controlId = data.get("controlId");
        String msg = controlService.deleteControl(controlId);

        map.put("msg", msg);
        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }
        return map;
    }
}
