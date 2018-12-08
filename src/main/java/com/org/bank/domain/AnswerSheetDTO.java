package com.org.bank.domain;

import com.org.bank.common.Pager;

import java.io.Serializable;

public class AnswerSheetDTO implements Serializable {
    /**  */
    private Integer id;

    /** 试卷id */
    private Integer examinationPaperId;

    /** 答题者id */
    private Integer answerId;

    /** 答题者姓名 */
    private String answererName;

    /** 答卷人类型：3学生 */
    private Integer answererType;

    /** 成绩 */
    private Double grade;

    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExaminationPaperId() {
        return examinationPaperId;
    }

    public void setExaminationPaperId(Integer examinationPaperId) {
        this.examinationPaperId = examinationPaperId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswererName() {
        return answererName;
    }

    public void setAnswererName(String answererName) {
        this.answererName = answererName == null ? null : answererName.trim();
    }

    public Integer getAnswererType() {
        return answererType;
    }

    public void setAnswererType(Integer answererType) {
        this.answererType = answererType;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}