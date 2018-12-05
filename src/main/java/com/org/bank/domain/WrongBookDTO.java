package com.org.bank.domain;

import com.org.bank.common.Pager;

import java.io.Serializable;

/**
 * 错题本DTO
 */
public class WrongBookDTO implements Serializable {
    /**  */
    private Integer id;

    /** 用户姓名 */
    private String userName;

    /** 用户id */
    private Integer userId;

    /** 1：管理员，2：教师，3：学生 */
    private String userType;

    /** 问题 */
    private String question;

    /** 答案 */
    private String answer;

    /** 1：单选题，2：多选题，3：判断题，4：填空题，5：简单题，6：直接组卷 */
    private Integer questionType;

    /** 问题id */
    private Integer questionId;

    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
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

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}