package com.xt.assessment.config;


import com.xt.assessment.config.session.MySessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */

@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter {
    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 允许跨域访问
     *
     * @param registry 注册信息
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*")
                .maxAge(36000);
    }

    /**
     * 注册session监听器;
     */
    @Bean
    public ServletListenerRegistrationBean<MySessionListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<MySessionListener> slrBean = new ServletListenerRegistrationBean<>();
        slrBean.setListener(new MySessionListener());
        return slrBean;
    }


}
