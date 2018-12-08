package com.org.bank.domain;

import com.org.bank.common.Pager;

import java.io.Serializable;

public class AnswerSheetAnswerDTO implements Serializable {
    /**  */
    private Integer id;

    /** 源试卷id */
    private Integer answerSheetId;

    /** 源试卷问题id */
    private Integer examinationPaperQuestionId;

    /** 试题问题 */
    private String examinationPaperQuestion;

    /** 试题回答 */
    private String examinationPaperAnswer;

    /** 答题者ID */
    private Integer answerId;

    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnswerSheetId() {
        return answerSheetId;
    }

    public void setAnswerSheetId(Integer answerSheetId) {
        this.answerSheetId = answerSheetId;
    }

    public Integer getExaminationPaperQuestionId() {
        return examinationPaperQuestionId;
    }

    public void setExaminationPaperQuestionId(Integer examinationPaperQuestionId) {
        this.examinationPaperQuestionId = examinationPaperQuestionId;
    }

    public String getExaminationPaperQuestion() {
        return examinationPaperQuestion;
    }

    public void setExaminationPaperQuestion(String examinationPaperQuestion) {
        this.examinationPaperQuestion = examinationPaperQuestion;
    }

    public String getExaminationPaperAnswer() {
        return examinationPaperAnswer;
    }

    public void setExaminationPaperAnswer(String examinationPaperAnswer) {
        this.examinationPaperAnswer = examinationPaperAnswer == null ? null : examinationPaperAnswer.trim();
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}