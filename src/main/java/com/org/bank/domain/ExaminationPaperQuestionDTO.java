package com.org.bank.domain;

import java.io.Serializable;

public class ExaminationPaperQuestionDTO implements Serializable {
    /**  */
    private Integer id;

    /**  */
    private Integer originalExaminationPaperId;

    /**  */
    private String examinationPaperQuestion;

    /**  */
    private String examinationPaperAnswer;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOriginalExaminationPaperId() {
        return originalExaminationPaperId;
    }

    public void setOriginalExaminationPaperId(Integer originalExaminationPaperId) {
        this.originalExaminationPaperId = originalExaminationPaperId;
    }

    public String getExaminationPaperQuestion() {
        return examinationPaperQuestion;
    }

    public void setExaminationPaperQuestion(String examinationPaperQuestion) {
        this.examinationPaperQuestion = examinationPaperQuestion == null ? null : examinationPaperQuestion.trim();
    }

    public String getExaminationPaperAnswer() {
        return examinationPaperAnswer;
    }

    public void setExaminationPaperAnswer(String examinationPaperAnswer) {
        this.examinationPaperAnswer = examinationPaperAnswer == null ? null : examinationPaperAnswer.trim();
    }
}