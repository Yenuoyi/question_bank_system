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

    /** 试卷选项 */
    private String examinationPaperOption;

    /** 试卷问题答案 */
    private String examinationPaperAnswer;

    /* 试卷问题类型 :1：单选题，2：多选题，3：判断题，4：填空题，5：简单题*/
    private String examinationPaperQuestionType;

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

    public String getExaminationPaperOption() {
        return examinationPaperOption;
    }

    public void setExaminationPaperOption(String examinationPaperOption) {
        this.examinationPaperOption = examinationPaperOption;
    }

    public String getExaminationPaperAnswer() {
        return examinationPaperAnswer;
    }

    public void setExaminationPaperAnswer(String examinationPaperAnswer) {
        this.examinationPaperAnswer = examinationPaperAnswer == null ? null : examinationPaperAnswer.trim();
    }

    public String getExaminationPaperQuestionType() {
        return examinationPaperQuestionType;
    }

    public void setExaminationPaperQuestionType(String examinationPaperQuestionType) {
        this.examinationPaperQuestionType = examinationPaperQuestionType;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}