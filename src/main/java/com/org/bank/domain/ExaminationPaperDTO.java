package com.org.bank.domain;

import com.org.bank.common.Pager;

import java.io.Serializable;
import java.util.List;

public class ExaminationPaperDTO implements Serializable {
    /** 试卷id */
    private Integer id;

    /** 出卷人id */
    private Integer examinerId;

    /** 出卷人类型 */
    private Integer examinerType;

    /** 试卷名 */
    private String examinationPaperName;

    /** 试卷内容 */
    private List<ExaminationPaperQuestionDTO> examinationPaperQuestionDTOList;

    private Pager pager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getExaminationPaperName() {
        return examinationPaperName;
    }

    public void setExaminationPaperName(String examinationPaperName) {
        this.examinationPaperName = examinationPaperName == null ? null : examinationPaperName.trim();
    }

    public List<ExaminationPaperQuestionDTO> getExaminationPaperQuestionDTOList() {
        return examinationPaperQuestionDTOList;
    }

    public void setExaminationPaperQuestionDTOList(List<ExaminationPaperQuestionDTO> examinationPaperQuestionDTOList) {
        this.examinationPaperQuestionDTOList = examinationPaperQuestionDTOList;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}