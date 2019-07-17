package com.mycompany.springbootldap.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Component
@ConfigurationProperties(prefix="app")
@Data
public class LoadProperties {
    private Map<String, List<String>> userProp = new HashMap<>();

    public Map<String, List<String>> getUserProp() {
        return userProp;
    }

    public void setUserProp(Map<String, List<String>> userProp) {
        this.userProp = userProp;
    }
}
