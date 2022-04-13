package com.azuriom.azlink.common.config;

import com.azuriom.azlink.common.http.server.HttpServer;

import java.util.ArrayList;
import java.util.List;

public class PluginConfig {

    private String siteKey;
    private String siteUrl;
    private boolean instantCommands = true;
    private List<String> whitelistCommands;
    private int httpPort = HttpServer.DEFAULT_PORT;
    private boolean checkUpdates = true;

    public PluginConfig() {
        this(null, null);
        this.whitelistCommands = new ArrayList<>();
    }

    public PluginConfig(String siteKey, String siteUrl) {
        this.siteKey = siteKey;
        this.siteUrl = siteUrl;
        this.whitelistCommands = new ArrayList<>();
    }

    public String getSiteKey() {
        return this.siteKey;
    }

    public void setSiteKey(String siteKey) {
        this.siteKey = siteKey;
    }

    public String getSiteUrl() {
        return this.siteUrl;
    }

    public List<String> getWhitelistCommands() {
        return whitelistCommands;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public boolean hasInstantCommands() {
        return this.instantCommands;
    }

    public int getHttpPort() {
        return this.httpPort;
    }

    public void setHttpPort(int httpPort) {
        this.httpPort = httpPort;
    }

    public boolean hasUpdatesCheck() {
        return this.checkUpdates;
    }

    public boolean isValid() {
        return this.siteKey != null && !this.siteKey.isEmpty() && this.siteUrl != null && !this.siteUrl.isEmpty();
    }

    public boolean isWhitelisted(String command) {
        for (String whitelistedCommand : this.whitelistCommands) {
            if (command.startsWith(whitelistedCommand)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "PluginConfig{siteKey='" + this.siteKey +
                "', siteUrl='" + this.siteUrl +
                "', httpPort=" + this.httpPort + '}';
    }
}
