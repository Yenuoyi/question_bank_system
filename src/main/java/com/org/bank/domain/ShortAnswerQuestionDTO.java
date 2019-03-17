package com.org.bank.domain;

import com.alibaba.fastjson.JSONObject;
import com.org.bank.common.Pager;

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

    /** 出题人类型 */
    private Integer examinerType;

    /** 程序语言分类id */
    private Integer languageClassificationId;

    /** 程序语言分类名 */
    private String languageClassificationName;
    private Pager pager;

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

    public Integer getExaminerType() {
        return examinerType;
    }

    public void setExaminerType(Integer examinerType) {
        this.examinerType = examinerType;
    }

    public Integer getLanguageClassificationId() {
        return languageClassificationId;
    }

    public void setLanguageClassificationId(Integer languageClassificationId) {
        this.languageClassificationId = languageClassificationId;
    }

    public String getLanguageClassificationName() {
        return languageClassificationName;
    }

    public void setLanguageClassificationName(String languageClassificationName) {
        this.languageClassificationName = languageClassificationName;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public static void main(String[] args){
        ShortAnswerQuestionDTO shortAnswerQuestionDTO = new ShortAnswerQuestionDTO();
        shortAnswerQuestionDTO.setShortAnswerAnswer("这个是问题！");
        shortAnswerQuestionDTO.setShortAnswerQuestion("这个是回答！");
        System.out.println(JSONObject.toJSONString(shortAnswerQuestionDTO));
    }
}