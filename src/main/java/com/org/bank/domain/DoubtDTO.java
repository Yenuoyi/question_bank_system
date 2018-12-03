package com.org.bank.domain;

import java.io.Serializable;

public class DoubtDTO implements Serializable {
    /** id */
    private Integer id;

    /** 提问者姓名 */
    private String questionerName;

    /** 提问者id */
    private Integer questionerId;

    /** 回答者姓名 */
    private String respondentName;

    /** 回答者id */
    private Integer respondentId;

    /** 问题 */
    private String question;

    /** 答案 */
    private String answer;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionerName() {
        return questionerName;
    }

    public void setQuestionerName(String questionerName) {
        this.questionerName = questionerName == null ? null : questionerName.trim();
    }

    public Integer getQuestionerId() {
        return questionerId;
    }

    public void setQuestionerId(Integer questionerId) {
        this.questionerId = questionerId;
    }

    public String getRespondentName() {
        return respondentName;
    }

    public void setRespondentName(String respondentName) {
        this.respondentName = respondentName == null ? null : respondentName.trim();
    }

    public Integer getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(Integer respondentId) {
        this.respondentId = respondentId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}