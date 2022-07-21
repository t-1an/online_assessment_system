package com.xt.assessment.dao;

import com.xt.assessment.entity.Control;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControlDao {

    /**
     * 新增控制
     *
     * @param control 控制
     */
    void addControl(Control control);

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
     */
    void deleteControl(String controlId);
}
