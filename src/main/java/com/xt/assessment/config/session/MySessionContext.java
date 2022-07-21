package com.xt.assessment.config.session;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */

public class MySessionContext {

    /**
     * 用于存放登录过的session
     */
    private static final Map<String, HttpSession> SESSION_MAP = new HashMap<>();

    public static synchronized void addSession(HttpSession session) {
        if (session != null) {
            SESSION_MAP.put(session.getId(), session);
        }
    }

    public static synchronized void delSession(HttpSession session) {
        if (session != null) {
            SESSION_MAP.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession(String sessionId) {
        if (sessionId == null) {
            return null;
        }
        return SESSION_MAP.get(sessionId);
    }


}
