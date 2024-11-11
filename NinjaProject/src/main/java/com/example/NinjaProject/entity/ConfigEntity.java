package com.example.NinjaProject.entity;

import jakarta.persistence.*;


@Entity
@Table(name="Config")
public class ConfigEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="featureid")
    private int featureId;

    @Column(name = "appid")
    private int appId;

    @Column(name="configname", unique = true)
    private String configName;

    @Column(name="description")
    private String description;

    @Column(name="refIDs")
    private String refIDs;

    @Column(name="ref_type")
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
