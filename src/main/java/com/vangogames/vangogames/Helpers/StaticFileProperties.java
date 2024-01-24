package com.vangogames.vangogames.Helpers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "static-file")
public class StaticFileProperties {
    private String location;

    public StaticFileProperties() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
