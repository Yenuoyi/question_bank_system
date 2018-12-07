package com.org.bank.domain;

import java.io.Serializable;

public class AnswerSheetDTO implements Serializable {
    /**  */
    private Integer id;

    /** 1：教师出卷 */
    private String answerSheetType;

    /** 源试卷id */
    private Integer originalExaminationPaperId;

    /** 源试卷问题 */
    private String originalExaminationPaperQuestion;

    /** 回答 */
    private String examinationPaperAnswer;

    /** 答卷人id */
    private Integer answererId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswerSheetType() {
        return answerSheetType;
    }

    public void setAnswerSheetType(String answerSheetType) {
        this.answerSheetType = answerSheetType == null ? null : answerSheetType.trim();
    }

    public Integer getOriginalExaminationPaperId() {
        return originalExaminationPaperId;
    }

    public void setOriginalExaminationPaperId(Integer originalExaminationPaperId) {
        this.originalExaminationPaperId = originalExaminationPaperId;
    }

    public String getOriginalExaminationPaperQuestion() {
        return originalExaminationPaperQuestion;
    }

    public void setOriginalExaminationPaperQuestion(String originalExaminationPaperQuestion) {
        this.originalExaminationPaperQuestion = originalExaminationPaperQuestion == null ? null : originalExaminationPaperQuestion.trim();
    }

    public String getExaminationPaperAnswer() {
        return examinationPaperAnswer;
    }

    public void setExaminationPaperAnswer(String examinationPaperAnswer) {
        this.examinationPaperAnswer = examinationPaperAnswer == null ? null : examinationPaperAnswer.trim();
    }

    public Integer getAnswererId() {
        return answererId;
    }

    public void setAnswererId(Integer answererId) {
        this.answererId = answererId;
    }
}