package com.xt.assessment.web;

import com.xt.assessment.entity.Risk;
import com.xt.assessment.entity.RiskLibrary;
import com.xt.assessment.service.RiskService;
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
public class RiskController {

    private final RiskService riskService;

    public RiskController(RiskService riskService) {
        this.riskService = riskService;
    }

    /**
     * 风险列表
     */
    @ResponseBody
    @RequestMapping(value = "/getRiskList", method = RequestMethod.POST)
    public Map<String, Object> getRiskList(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(3);

        String assessmentId = data.get("assessmentId");
        List<Risk> list = riskService.getRiskList(assessmentId);

        map.put("code", Constants.SUCCESS_CODE);
        map.put("msg", Constants.SUCCESS_MSG);
        map.put("data", list);
        return map;
    }

    /**
     * 风险详细
     */
    @ResponseBody
    @RequestMapping(value = "/getRisk", method = RequestMethod.POST)
    public Map<String, Object> getRisk(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(3);

        String riskId = data.get("riskId");
        Risk risk = riskService.getRisk(riskId);

        map.put("code", Constants.SUCCESS_CODE);
        map.put("msg", Constants.SUCCESS_MSG);
        map.put("data", risk);
        return map;
    }

    /**
     * 保存风险列表
     */
    @ResponseBody
    @RequestMapping(value = "/saveRisks", method = RequestMethod.POST)
    public Map<String, Object> saveRisks(@RequestBody List<Risk> risks) {
        Map<String, Object> map = new HashMap<>(2);

        String msg = riskService.saveRisks(risks);

        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }

        map.put("msg", msg);
        return map;
    }

    /**
     * 新增风险库
     */
    @ResponseBody
    @RequestMapping(value = "/saveRiskLibrary", method = RequestMethod.POST)
    public Map<String, Object> saveRiskLibrary(@RequestBody RiskLibrary riskLibrary) {
        Map<String, Object> map = new HashMap<>(2);

        String msg = riskService.saveRiskLibrary(riskLibrary);

        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }

        map.put("msg", msg);
        return map;
    }

    /**
     * 删除风险
     */
    @ResponseBody
    @RequestMapping(value = "/deleteRisk", method = RequestMethod.POST)
    public Map<String, Object> deleteRisk(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(2);

        String riskId = data.get("riskId");
        String msg = riskService.deleteRisk(riskId);

        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }

        map.put("msg", msg);
        return map;
    }

    /**
     * 删除风险库
     */
    @ResponseBody
    @RequestMapping(value = "/deleteRiskLibrary", method = RequestMethod.POST)
    public Map<String, Object> deleteRiskLibrary(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(2);

        String riskLibraryId = data.get("riskLibraryId");
        String msg = riskService.deleteRiskLibrary(riskLibraryId);

        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }

        map.put("msg", msg);
        return map;
    }

    /**
     * 风险库列表
     */
    @ResponseBody
    @RequestMapping(value = "/getRiskLibraryList", method = RequestMethod.POST)
    public Map<String, Object> getRiskLibraryList() {
        Map<String, Object> map = new HashMap<>(3);

        List<RiskLibrary> list = riskService.getRiskLibraryList();

        map.put("code", Constants.SUCCESS_CODE);
        map.put("msg", Constants.SUCCESS_MSG);
        map.put("data", list);
        return map;
    }
}
