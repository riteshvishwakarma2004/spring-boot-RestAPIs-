package com.Ritesh.mobileStore.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Scope("prototype")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer launchNo;
    private String phoneName;
    private String brandName;
    private Integer price;
    private String processor;
    private List<String> ramRom;
    private String mainCamera;
    private String frontCamera;
    private Float displaySize;
    private String displayType;
    private List<String> networkOptions;
    private String buildMaterial;

    public Phone() {

    }

    @Override
    public String toString() {
        return "Phone{" +
                "launchNo=" + launchNo +
                ", phoneName='" + phoneName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", price=" + price +
                ", processor='" + processor + '\'' +
                ", ramRom=" + ramRom +
                ", mainCamera='" + mainCamera + '\'' +
                ", frontCamera='" + frontCamera + '\'' +
                ", displaySize=" + displaySize +
                ", displayType='" + displayType + '\'' +
                ", networkOptions=" + networkOptions +
                ", buildMaterial='" + buildMaterial + '\'' +
                '}';
    }



    public Integer getLaunchNo() {
        return launchNo;
    }

    public void setLaunchNo(Integer launchNo) {
        this.launchNo = launchNo;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public List<String> getRamRom() {
        return ramRom;
    }

    public void setRamRom(List<String> ramRom) {
        this.ramRom = ramRom;
    }

    public String getMainCamera() {
        return mainCamera;
    }

    public void setMainCamera(String mainCamera) {
        this.mainCamera = mainCamera;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public Float getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(Float displaySize) {
        this.displaySize = displaySize;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public List<String> getNetworkOptions() {
        return networkOptions;
    }

    public void setNetworkOptions(List<String> networkOptions) {
        this.networkOptions = networkOptions;
    }

    public String getBuildMaterial() {
        return buildMaterial;
    }

    public void setBuildMaterial(String buildMaterial) {
        this.buildMaterial = buildMaterial;
    }





}
