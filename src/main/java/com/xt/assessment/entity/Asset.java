package com.xt.assessment.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/6/20
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    /**
     * 资产ID
     */
    private String assetId;
    /**
     * 资产名称
     */
    private String assetName;
    /**
     * 资产类型
     */
    private Integer assetType;
    /**
     * 托管地址
     * 0全球 1中国大陆 2中国香港 3美国 4欧洲
     */
    private Integer assetLocation;
    /**
     * 状态 0失效 1有效
     */
    private Integer assetStatus;
    /**
     * 是否主资产 0否 1是
     */
    private Integer isMajorAsset;
    /**
     * 注册时间
     */
    private Date registerDate;
    /**
     * 失效时间
     */
    private Date expireDate;
    /**
     * 备注
     */
    private String comment;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 数据字段
     */
    private String dataField;
    /**
     * 数据量
     */
    private Integer dataQuantity;
    /**
     * 跨境传输 'no'不传输 'xx'传输到某地
     */
    private String crossBorder;
    /**
     * 是否到第三方
     */
    private String toThirdParty;

}