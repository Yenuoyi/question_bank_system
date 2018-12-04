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
    private String examinerType;

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

    public String getExaminerType() {
        return examinerType;
    }

    public void setExaminerType(String examinerType) {
        this.examinerType = examinerType == null ? null : examinerType.trim();
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}