package com.xt.assessment.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
@Service
@Slf4j
public class CommonUtils {
    static MessageDigest md5 = null;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            log.error("md5 init error", e);
        }
    }

    /**
     * md5算法编码加密
     *
     * @param sourceString: 需要被加密的文本
     * @return 加密后的文本
     */
    public String encodeByMd5(String sourceString) {
        byte[] encode = Base64.getEncoder().encode(md5.digest(sourceString.getBytes(StandardCharsets.UTF_8)));
        return new String(encode);
    }

    /**
     * 生成随机的UUID
     *
     * @return 随机的UUID
     */
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
