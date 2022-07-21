package com.xt.assessment.service.impl;

import com.xt.assessment.dao.AssetDao;
import com.xt.assessment.entity.Asset;
import com.xt.assessment.service.AssetService;
import com.xt.assessment.utils.CommonUtils;
import com.xt.assessment.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {
    private final CommonUtils commonUtils;
    private final AssetDao assetDao;

    public AssetServiceImpl(CommonUtils commonUtils, AssetDao assetDao) {
        this.commonUtils = commonUtils;
        this.assetDao = assetDao;
    }


    /**
     * 新增资产
     *
     * @param asset 资产
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String addAsset(Asset asset) {
        String msg = Constants.SUCCESS_MSG;
        try {
            asset.setAssetId(commonUtils.getUUID());
            asset.setRegisterDate(new Date());
            assetDao.addAsset(asset);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    /**
     * 获取资产列表
     *
     * @return 资产列表
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Asset> getAssetList() {
        return assetDao.getAssetList();
    }

    /**
     * 删除资产
     *
     * @param assetId 资产Id
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String deleteAsset(String assetId) {
        String msg = Constants.SUCCESS_MSG;
        try {
            assetDao.deleteAsset(assetId);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    /**
     * 查看资产
     *
     * @param assetId 资产Id
     * @return asset
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Asset getAsset(String assetId) {
        return assetDao.getAsset(assetId);
    }
}
