package com.org.bank.domain;

import com.org.bank.common.Pager;

import java.io.Serializable;

public class MultipleChoiceQuestionDTO implements Serializable {
    /**  */
    private Integer id;

    /** 问题 */
    private String multipleChoiceQuestion;

    /** 选项 */
    private String multipleChoiceOption;

    /** 答案 */
    private String multipleChoiceAnswer;

    /** 出题人id */
    private Integer examinerId;

    /** 出题人类型：1admin 2教师 */
    private Integer examinerType;

    /** 习题练习是否正确，0：错误，1：正确 */
    private Integer trueOrFalse;

    /** 程序语言分类id */
    private Integer languageClassificationId;

    /** 程序语言分类名 */
    private Integer languageClassificationName;
    private Pager pager;

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

    public String getMultipleChoiceOption() {
        return multipleChoiceOption;
    }

    public void setMultipleChoiceOption(String multipleChoiceOption) {
        this.multipleChoiceOption = multipleChoiceOption;
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

    public Integer getTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(Integer trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    public Integer getLanguageClassificationId() {
        return languageClassificationId;
    }

    public void setLanguageClassificationId(Integer languageClassificationId) {
        this.languageClassificationId = languageClassificationId;
    }

    public Integer getLanguageClassificationName() {
        return languageClassificationName;
    }

    public void setLanguageClassificationName(Integer languageClassificationName) {
        this.languageClassificationName = languageClassificationName;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}