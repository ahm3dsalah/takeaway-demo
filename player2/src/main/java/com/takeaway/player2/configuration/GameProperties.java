package com.takeaway.player2.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "game")
@Component
public class GameProperties {
    private String anotherPlayerUrl;
    private String passUri;

    public String getAnotherPlayerUrl() {
        return anotherPlayerUrl;
    }

    public void setAnotherPlayerUrl(String anotherPlayerUrl) {
        this.anotherPlayerUrl = anotherPlayerUrl;
    }

    public String getPassUri() {
        return passUri;
    }

    public void setPassUri(String passUri) {
        this.passUri = passUri;
    }
}
