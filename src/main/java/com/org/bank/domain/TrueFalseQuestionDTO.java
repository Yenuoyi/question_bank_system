package com.org.bank.domain;

import com.org.bank.common.Pager;

import java.io.Serializable;

public class TrueFalseQuestionDTO implements Serializable {
    /**  */
    private Integer id;

    /** 问题 */
    private String trueFalseQuestion;

    /** 答案 */
    private String trueFalseAnswer;

    /** 出题人id */
    private Integer examinerId;

    /** 出题人类型：1admin 2教师 */
    private Integer examinerType;

    /** 习题练习是否正确，0：错误，1：正确 */
    private Integer trueOrFalse;

    /** 程序语言分类id */
    private Integer languageClassificationId;

    /** 程序语言分类名 */
    private String languageClassificationName;

    /** 程序语言分类状态 1：启用 2：禁用 */
    private Integer languageClassificationStatus;
    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrueFalseQuestion() {
        return trueFalseQuestion;
    }

    public void setTrueFalseQuestion(String trueFalseQuestion) {
        this.trueFalseQuestion = trueFalseQuestion == null ? null : trueFalseQuestion.trim();
    }

    public String getTrueFalseAnswer() {
        return trueFalseAnswer;
    }

    public void setTrueFalseAnswer(String trueFalseAnswer) {
        this.trueFalseAnswer = trueFalseAnswer == null ? null : trueFalseAnswer.trim();
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

    public Integer getTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(Integer trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

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
        this.languageClassificationName = languageClassificationName;
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