package com.xt.assessment.service;

import com.xt.assessment.entity.Control;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
public interface ControlService {

    /**
     * 新增控制
     *
     * @param control 控制
     * @return msg
     */
    String addControl(Control control);

    /**
     * 获取控制列表
     *
     * @return 控制列表
     */
    List<Control> getControlList();

    /**
     * 删除控制
     *
     * @param controlId 控制Id
     * @return msg
     */
    String deleteControl(String controlId);
}
