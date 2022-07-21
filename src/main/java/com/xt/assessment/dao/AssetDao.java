package com.xt.assessment.dao;

import com.xt.assessment.entity.Asset;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetDao {

    /**
     * 新增资产
     *
     * @param asset 资产
     */
    void addAsset(Asset asset);

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
     */
    void deleteAsset(String assetId);

    /**
     * 查看资产
     *
     * @param assetId 资产Id
     * @return asset
     */
    Asset getAsset(String assetId);
}
