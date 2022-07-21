package com.xt.assessment.config.session;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import static com.xt.assessment.utils.Constants.ADMIN;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */

@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //System.err.println("session add: " + httpSessionEvent.getSession().getId() + new Date());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        MySessionContext.delSession(httpSessionEvent.getSession());
    }


    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (ADMIN.equalsIgnoreCase(httpSessionBindingEvent.getName())) {
            MySessionContext.addSession(httpSessionBindingEvent.getSession());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (ADMIN.equalsIgnoreCase(httpSessionBindingEvent.getName())) {
            MySessionContext.delSession(httpSessionBindingEvent.getSession());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
