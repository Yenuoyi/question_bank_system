package com.org.bank.domain;

import java.io.Serializable;

public class AdminInfoDTO implements Serializable {
    /**  */
    private Integer adminId;

    /**  */
    private String adminName;

    /**  */
    private String adminEamil;

    /**  */
    private String adminPassword;

    /**  */
    private String adminIphone;

    private static final long serialVersionUID = 1L;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminEamil() {
        return adminEamil;
    }

    public void setAdminEamil(String adminEamil) {
        this.adminEamil = adminEamil == null ? null : adminEamil.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminIphone() {
        return adminIphone;
    }

    public void setAdminIphone(String adminIphone) {
        this.adminIphone = adminIphone == null ? null : adminIphone.trim();
    }
}