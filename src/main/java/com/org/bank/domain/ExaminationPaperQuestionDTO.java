package com.org.bank.domain;

import com.org.bank.common.Pager;

import java.io.Serializable;

public class ExaminationPaperQuestionDTO implements Serializable {
    /**  */
    private Integer id;

    /** 试卷原卷id */
    private Integer originalExaminationPaperId;

    /** 试卷问题 */
    private String examinationPaperQuestion;

    /** 试卷问题答案 */
    private String examinationPaperAnswer;

    private Pager pager;

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

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}