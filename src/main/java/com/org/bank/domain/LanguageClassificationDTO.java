package com.org.bank.domain;

import com.org.bank.common.Pager;

import java.io.Serializable;

public class LanguageClassificationDTO implements Serializable {
    /**  */
    private Integer languageClassificationId;

    /**  */
    private String languageClassificationName;

    private Integer languageClassificationStatus;


    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getLanguageClassificationId() {
        return languageClassificationId;
    }

    public void setLanguageClassificationId(Integer languageClassificationId) {
        this.languageClassificationId = languageClassificationId;
    }

    public String getLanguageClassificationName() {
        return languageClassificationName;
    }

    public void setLanguageClassificationName(String languageClassificationName) {
        this.languageClassificationName = languageClassificationName == null ? null : languageClassificationName.trim();
    }


    public Integer getLanguageClassificationStatus() {
        return languageClassificationStatus;
    }

    public void setLanguageClassificationStatus(Integer languageClassificationStatus) {
        this.languageClassificationStatus = languageClassificationStatus;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}