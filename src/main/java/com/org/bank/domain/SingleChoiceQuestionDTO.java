package com.org.bank.domain;

import java.io.Serializable;

public class SingleChoiceQuestionDTO implements Serializable {
    /** 自增id */
    private Integer id;

    /** 问题 */
    private String singleChoiceQuestion;

    /** 答案 */
    private String singleChoiceAnswer;

    /** 出题人id */
    private Integer examinerId;

    /** 出题人类型：1admin 2教师 */
    private Integer examinerType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSingleChoiceQuestion() {
        return singleChoiceQuestion;
    }

    public void setSingleChoiceQuestion(String singleChoiceQuestion) {
        this.singleChoiceQuestion = singleChoiceQuestion == null ? null : singleChoiceQuestion.trim();
    }

    public String getSingleChoiceAnswer() {
        return singleChoiceAnswer;
    }

    public void setSingleChoiceAnswer(String singleChoiceAnswer) {
        this.singleChoiceAnswer = singleChoiceAnswer == null ? null : singleChoiceAnswer.trim();
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
}