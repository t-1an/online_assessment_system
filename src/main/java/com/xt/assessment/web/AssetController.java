package com.xt.assessment.web;

import com.xt.assessment.entity.Asset;
import com.xt.assessment.service.AssetService;
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
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    /**
     * 资产列表
     */
    @ResponseBody
    @RequestMapping(value = "/getAssetList", method = RequestMethod.POST)
    public Map<String, Object> getAssetList(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(3);

        List<Asset> list = assetService.getAssetList();

        map.put("code", Constants.SUCCESS_CODE);
        map.put("msg", Constants.SUCCESS_MSG);
        map.put("data", list);
        return map;
    }

    /**
     * 新增资产
     */
    @ResponseBody
    @RequestMapping(value = "/addAsset", method = RequestMethod.POST)
    public Map<String, Object> addAsset(@RequestBody Asset asset) {
        Map<String, Object> map = new HashMap<>(2);

        String msg = assetService.addAsset(asset);

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
    @RequestMapping(value = "/deleteAsset", method = RequestMethod.POST)
    public Map<String, Object> deleteAsset(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(3);

        String assetId = data.get("assetId");
        String msg = assetService.deleteAsset(assetId);

        map.put("msg", msg);
        if (Constants.SUCCESS_MSG.equals(msg)) {
            map.put("code", Constants.SUCCESS_CODE);
        } else {
            map.put("code", 1);
        }
        return map;
    }

    /**
     * 查看资产
     */
    @ResponseBody
    @RequestMapping(value = "/getAsset", method = RequestMethod.POST)
    public Map<String, Object> getAsset(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<>(3);

        String assetId = data.get("assetId");
        Asset asset = assetService.getAsset(assetId);

        map.put("code", Constants.SUCCESS_CODE);
        map.put("msg", Constants.SUCCESS_MSG);
        map.put("data", asset);
        return map;
    }
}
