package com.xt.assessment.service.impl;

import com.xt.assessment.dao.ControlDao;
import com.xt.assessment.entity.Control;
import com.xt.assessment.service.ControlService;
import com.xt.assessment.utils.CommonUtils;
import com.xt.assessment.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ControlServiceImpl implements ControlService {
    private final CommonUtils commonUtils;
    private final ControlDao controlDao;

    public ControlServiceImpl(CommonUtils commonUtils, ControlDao controlDao) {
        this.commonUtils = commonUtils;
        this.controlDao = controlDao;
    }


    /**
     * 新增控制
     *
     * @param control 控制
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String addControl(Control control) {
        String msg = Constants.SUCCESS_MSG;
        try {
            control.setControlId(commonUtils.getUUID());
            controlDao.addControl(control);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    /**
     * 获取控制列表
     *
     * @return 控制列表
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Control> getControlList() {
        return controlDao.getControlList();
    }

    /**
     * 删除控制
     *
     * @param controlId 控制Id
     * @return msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String deleteControl(String controlId) {
        String msg = Constants.SUCCESS_MSG;
        try {
            controlDao.deleteControl(controlId);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }
}
