package com.smart.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyDataSource {
    /*
     * Use util namespace <util:properties> to defined property file
     * @Value("#{properties['<propertyName>']}") to inject the value
     *
     * Or define property-placeholder
     * <context:property-placeholder properties-ref="properties"/>
     * Then Can use ${<propertyName})
     */
    @Value("#{properties['driverClassName']}")
    private String driverClassName;

    @Value("#{properties['url']}")
    private String url;

    @Value("${userName}")
    private String userName;

    @Value("${password}")
    private String password;


    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
