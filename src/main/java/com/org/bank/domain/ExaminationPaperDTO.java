package com.org.bank.domain;

import com.org.bank.common.Pager;

import java.io.Serializable;

public class ExaminationPaperDTO implements Serializable {
    /** 试卷id */
    private Integer id;

    /** 出卷人id */
    private Integer examinerId;

    /** 出卷人类型 */
    private Integer examinerType;

    private Pager pager;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExaminerId() {
        return examinerId;
    }

    public void setExaminerId(Integer examinerId) {
        this.examinerId = examinerId;
    }

    public Integer getExaminerType() {
        return examinerType;
    }

    public void setExaminerType(Integer examinerType) {
        this.examinerType = examinerType;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}