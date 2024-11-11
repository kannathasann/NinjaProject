package com.example.NinjaProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class ConfigDto implements Serializable {
    private int id;
    @JsonProperty("featureid")
    private int featureId;
    @JsonProperty("appid")
    private int appId;
    @NotNull(message = "{config.name.notnull}")
    @Size(min = 4, max = 50, message = "{config.name.size}")
    @JsonProperty("configname")
    private String configName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("refIDs")
    private String refIDs;
    @JsonProperty("ref_type")
    private String refType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRefIDs() {
        return refIDs;
    }

    public void setRefIDs(String refIDs) {
        this.refIDs = refIDs;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }
}
