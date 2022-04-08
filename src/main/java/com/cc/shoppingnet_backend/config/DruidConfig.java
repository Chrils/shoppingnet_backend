package com.cc.shoppingnet_backend.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

//@Configuration
public class DruidConfig {
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource druidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        return new ServletRegistrationBean<>(statViewServlet,"/druid/*");
    }

    @Bean
    public FilterRegistrationBean statViewFilter(){
        //注意是WebStatFilter
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
//        Map<String,String> map = new HashMap<>();
//        map.put("exclusions","*.js,*.gif,*.jpg,*.css,*.ico,/druid/*");
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//        filterRegistrationBean.setInitParameters(map);
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
