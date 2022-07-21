package com.xt.assessment.service;

import com.xt.assessment.entity.Risk;
import com.xt.assessment.entity.RiskLibrary;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
public interface RiskService {

    /**
     * 保存风险列表
     *
     * @param risks 风险列表
     * @return msg
     */
    String saveRisks(List<Risk> risks);

    /**
     * 获取风险列表
     *
     * @param assessmentId 评估ID
     * @return 风险列表
     */
    List<Risk> getRiskList(String assessmentId);

    /**
     * 风险详细信息
     *
     * @param riskId 风险ID
     * @return 风险
     */
    Risk getRisk(String riskId);

    /**
     * 删除风险
     *
     * @param riskId 风险ID
     * @return msg
     */
    String deleteRisk(String riskId);

    /**
     * 保存风险库
     *
     * @param riskLibrary 风险库
     * @return msg
     */
    String saveRiskLibrary(RiskLibrary riskLibrary);

    /**
     * 获取风险库列表
     *
     * @return 风险库列表
     */
    List<RiskLibrary> getRiskLibraryList();

    /**
     * 删除风险库
     *
     * @param riskLibraryId 风险库ID
     * @return msg
     */
    String deleteRiskLibrary(String riskLibraryId);

}
