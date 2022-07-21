package com.xt.assessment.service;

import com.xt.assessment.entity.Asset;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
public interface AssetService {

    /**
     * 新增资产
     *
     * @param asset 资产
     * @return msg
     */
    String addAsset(Asset asset);

    /**
     * 获取资产列表
     *
     * @return 资产列表
     */
    List<Asset> getAssetList();

    /**
     * 删除资产
     *
     * @param assetId 资产Id
     * @return msg
     */
    String deleteAsset(String assetId);

    /**
     * 查看资产
     *
     * @param assetId 资产Id
     * @return asset
     */
    Asset getAsset(String assetId);
}
