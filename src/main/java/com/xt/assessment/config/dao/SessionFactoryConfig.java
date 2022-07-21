package com.xt.assessment.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */

@Configuration
public class SessionFactoryConfig {
    private final DataSource dataSource;
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    @Value("${mapper_path}")
    private String mapperPath;
    @Value("${entity_path}")
    private String entityPackage;

    public SessionFactoryConfig(@Qualifier("dataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        //实体类扫描路径
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }
}
