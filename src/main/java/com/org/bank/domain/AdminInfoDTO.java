package com.org.bank.domain;

import com.org.bank.common.Pager;

import java.io.Serializable;

public class AdminInfoDTO implements Serializable {
    /** 管理员ID */
    private Integer id;

    /** 管理员姓名 */
    private String adminName;

    /** 管理员邮箱 */
    private String adminEamil;

    /** 管理员密码 */
    private String adminPassword;

    /** 管理员密码 */
    private String newAdminPassword;

    /** 管理员手机 */
    private String adminIphone;

    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNewAdminPassword() {
        return newAdminPassword;
    }

    public void setNewAdminPassword(String newAdminPassword) {
        this.newAdminPassword = newAdminPassword;
    }

    public String getAdminIphone() {
        return adminIphone;
    }

    public void setAdminIphone(String adminIphone) {
        this.adminIphone = adminIphone == null ? null : adminIphone.trim();
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}