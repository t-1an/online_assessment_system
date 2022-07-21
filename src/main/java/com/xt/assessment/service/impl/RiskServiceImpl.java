package com.xt.assessment.service.impl;

import com.xt.assessment.dao.RiskDao;
import com.xt.assessment.entity.Risk;
import com.xt.assessment.entity.RiskLibrary;
import com.xt.assessment.service.RiskService;
import com.xt.assessment.utils.CommonUtils;
import com.xt.assessment.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/23
 */
@Service
public class RiskServiceImpl implements RiskService {

    private final RiskDao riskDao;
    private final CommonUtils commonUtils;

    public RiskServiceImpl(CommonUtils commonUtils, RiskDao riskDao) {
        this.commonUtils = commonUtils;
        this.riskDao = riskDao;
    }

    /**
     * 保存风险列表
     *
     * @param risks 风险列表
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveRisks(List<Risk> risks) {
        try {
            if (risks.size() > 0) {
                for (Risk risk : risks) {
                    risk.setRiskId(commonUtils.getUUID());
                }
                riskDao.saveRisks(risks);
            }

            return Constants.SUCCESS_MSG;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 获取风险列表
     *
     * @param assessmentId 评估ID
     * @return 风险列表
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Risk> getRiskList(String assessmentId) {
        return riskDao.getRiskList(assessmentId);
    }

    /**
     * 风险详细信息
     *
     * @param riskId 风险ID
     * @return 风险
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Risk getRisk(String riskId) {
        return riskDao.getRisk(riskId);
    }

    /**
     * 保存风险库
     *
     * @param riskLibrary 风险库
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveRiskLibrary(RiskLibrary riskLibrary) {
        try {
            riskLibrary.setRiskLibraryId(commonUtils.getUUID());
            riskDao.saveRiskLibrary(riskLibrary);

            return Constants.SUCCESS_MSG;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 获取风险库列表
     *
     * @return 风险库列表
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<RiskLibrary> getRiskLibraryList() {
        return riskDao.getRiskLibraryList();
    }

    /**
     * 删除风险
     *
     * @param riskId 风险ID
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String deleteRisk(String riskId) {
        try {
            riskDao.deleteRisk(riskId);

            return Constants.SUCCESS_MSG;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 删除风险库
     *
     * @param riskLibraryId 风险库ID
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String deleteRiskLibrary(String riskLibraryId) {
        try {
            riskDao.deleteRiskLibrary(riskLibraryId);

            return Constants.SUCCESS_MSG;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
