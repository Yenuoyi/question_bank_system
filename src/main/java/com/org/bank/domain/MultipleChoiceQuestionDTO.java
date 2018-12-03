package com.org.bank.domain;

import java.io.Serializable;

public class MultipleChoiceQuestionDTO implements Serializable {
    /**  */
    private Integer id;

    /** 问题 */
    private String multipleChoiceQuestion;

    /** 答案 */
    private String multipleChoiceAnswer;

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

    public String getMultipleChoiceQuestion() {
        return multipleChoiceQuestion;
    }

    public void setMultipleChoiceQuestion(String multipleChoiceQuestion) {
        this.multipleChoiceQuestion = multipleChoiceQuestion == null ? null : multipleChoiceQuestion.trim();
    }

    public String getMultipleChoiceAnswer() {
        return multipleChoiceAnswer;
    }

    public void setMultipleChoiceAnswer(String multipleChoiceAnswer) {
        this.multipleChoiceAnswer = multipleChoiceAnswer == null ? null : multipleChoiceAnswer.trim();
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