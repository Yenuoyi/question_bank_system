package com.org.bank.domain;

import java.io.Serializable;

public class ShortAnswerQuestionDTO implements Serializable {
    /**  */
    private Integer id;

    /** 问题 */
    private String shortAnswerQuestion;

    /** 答案 */
    private String shortAnswerAnswer;

    /** 出题人id */
    private Integer examinerId;

    /** 出题人code */
    private String examinerCode;

    /** 出题人类型 */
    private Integer examinerType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortAnswerQuestion() {
        return shortAnswerQuestion;
    }

    public void setShortAnswerQuestion(String shortAnswerQuestion) {
        this.shortAnswerQuestion = shortAnswerQuestion == null ? null : shortAnswerQuestion.trim();
    }

    public String getShortAnswerAnswer() {
        return shortAnswerAnswer;
    }

    public void setShortAnswerAnswer(String shortAnswerAnswer) {
        this.shortAnswerAnswer = shortAnswerAnswer == null ? null : shortAnswerAnswer.trim();
    }

    public Integer getExaminerId() {
        return examinerId;
    }

    public void setExaminerId(Integer examinerId) {
        this.examinerId = examinerId;
    }

    public String getExaminerCode() {
        return examinerCode;
    }

    public void setExaminerCode(String examinerCode) {
        this.examinerCode = examinerCode == null ? null : examinerCode.trim();
    }

    public Integer getExaminerType() {
        return examinerType;
    }

    public void setExaminerType(Integer examinerType) {
        this.examinerType = examinerType;
    }
}