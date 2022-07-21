package com.xt.assessment.dao;

import com.xt.assessment.entity.Risk;
import com.xt.assessment.entity.RiskLibrary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */

@Repository
public interface RiskDao {
    /**
     * 保存风险列表
     *
     * @param risks 风险列表
     */
    void saveRisks(List<Risk> risks);

    /**
     * 删除风险
     *
     * @param riskId 风险ID
     */
    void deleteRisk(String riskId);

    /**
     * 获取风险列表
     *
     * @param assessmentId 评估ID
     * @return 风险列表
     */
    List<Risk> getRiskList(@Param("assessmentId") String assessmentId);

    /**
     * 获取风险列表
     *
     * @param riskId 风险ID
     * @return 风险
     */
    Risk getRisk(String riskId);

    /**
     * 保存风险库
     *
     * @param riskLibrary 风险库
     */
    void saveRiskLibrary(RiskLibrary riskLibrary);

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
     */
    void deleteRiskLibrary(String riskLibraryId);
}
