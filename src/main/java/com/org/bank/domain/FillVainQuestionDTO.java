package com.org.bank.domain;

import java.io.Serializable;

public class FillVainQuestionDTO implements Serializable {
    /**  */
    private Integer id;

    /** 问题 */
    private String fillVainQuestion;

    /** 答案 */
    private String fillVainAnswer;

    /** 出题人id */
    private Integer examinerId;

    /** 出题人类型 */
    private Integer examinerType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFillVainQuestion() {
        return fillVainQuestion;
    }

    public void setFillVainQuestion(String fillVainQuestion) {
        this.fillVainQuestion = fillVainQuestion == null ? null : fillVainQuestion.trim();
    }

    public String getFillVainAnswer() {
        return fillVainAnswer;
    }

    public void setFillVainAnswer(String fillVainAnswer) {
        this.fillVainAnswer = fillVainAnswer == null ? null : fillVainAnswer.trim();
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