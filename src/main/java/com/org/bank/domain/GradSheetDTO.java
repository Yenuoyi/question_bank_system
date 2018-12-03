package com.org.bank.domain;

import java.io.Serializable;

public class GradSheetDTO implements Serializable {
    /**  */
    private Integer id;

    /** 答卷人姓名 */
    private String answererName;

    /** 答卷人id */
    private Integer answererId;

    /** 答卷人类型：1学生 */
    private Integer answererType;

    /** 成绩 */
    private String grade;

    /** 1：直接组卷 2：按比例抽题组卷 3：随机抽题组卷 */
    private Integer examinationPaperType;

    /** 试卷id */
    private Integer examinationPaperId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswererName() {
        return answererName;
    }

    public void setAnswererName(String answererName) {
        this.answererName = answererName == null ? null : answererName.trim();
    }

    public Integer getAnswererId() {
        return answererId;
    }

    public void setAnswererId(Integer answererId) {
        this.answererId = answererId;
    }

    public Integer getAnswererType() {
        return answererType;
    }

    public void setAnswererType(Integer answererType) {
        this.answererType = answererType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Integer getExaminationPaperType() {
        return examinationPaperType;
    }

    public void setExaminationPaperType(Integer examinationPaperType) {
        this.examinationPaperType = examinationPaperType;
    }

    public Integer getExaminationPaperId() {
        return examinationPaperId;
    }

    public void setExaminationPaperId(Integer examinationPaperId) {
        this.examinationPaperId = examinationPaperId;
    }
}