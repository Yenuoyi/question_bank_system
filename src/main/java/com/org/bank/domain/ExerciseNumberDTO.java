package com.org.bank.domain;

import java.util.List;

/**
 * 习题数量DTO
 */
public class ExerciseNumberDTO {
    /** 填空题数量 */
    private Integer fillVainNumber;

    /** 填空题比例 */
    private Integer fillVainProportion;

    /** 多选题数量 */
    private Integer MultipleChoiceNumber;

    /** 多选题比例 */
    private Integer MultipleChoiceProportion;

    /** 简答题数量 */
    private Integer shortAnswerNumber;

    /** 简答题比例 */
    private Integer shortAnswerProportion;

    /** 单选题数量 */
    private Integer singleChoiceNumber;

    /** 单选题比例 */
    private Integer singleChoiceProportion;

    /** 判断题数量 */
    private Integer trueFalseNumber;

    /** 判断题比例 */
    private Integer trueFalseProportion;

    List<FillVainQuestionDTO> fillVainQuestionDTOS;
    List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS;
    List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS;
    List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS;
    List<TrueFalseQuestionDTO> trueFalseQuestionDTOS;
    public Integer getFillVainNumber() {
        return fillVainNumber;
    }

    public void setFillVainNumber(Integer fillVainNumber) {
        this.fillVainNumber = fillVainNumber;
    }

    public Integer getFillVainProportion() {
        return fillVainProportion;
    }

    public void setFillVainProportion(Integer fillVainProportion) {
        this.fillVainProportion = fillVainProportion;
    }

    public Integer getMultipleChoiceNumber() {
        return MultipleChoiceNumber;
    }

    public void setMultipleChoiceNumber(Integer multipleChoiceNumber) {
        MultipleChoiceNumber = multipleChoiceNumber;
    }

    public Integer getMultipleChoiceProportion() {
        return MultipleChoiceProportion;
    }

    public void setMultipleChoiceProportion(Integer multipleChoiceProportion) {
        MultipleChoiceProportion = multipleChoiceProportion;
    }

    public Integer getShortAnswerNumber() {
        return shortAnswerNumber;
    }

    public void setShortAnswerNumber(Integer shortAnswerNumber) {
        this.shortAnswerNumber = shortAnswerNumber;
    }

    public Integer getShortAnswerProportion() {
        return shortAnswerProportion;
    }

    public void setShortAnswerProportion(Integer shortAnswerProportion) {
        this.shortAnswerProportion = shortAnswerProportion;
    }

    public Integer getSingleChoiceNumber() {
        return singleChoiceNumber;
    }

    public void setSingleChoiceNumber(Integer singleChoiceNumber) {
        this.singleChoiceNumber = singleChoiceNumber;
    }

    public Integer getSingleChoiceProportion() {
        return singleChoiceProportion;
    }

    public void setSingleChoiceProportion(Integer singleChoiceProportion) {
        this.singleChoiceProportion = singleChoiceProportion;
    }

    public Integer getTrueFalseNumber() {
        return trueFalseNumber;
    }

    public void setTrueFalseNumber(Integer trueFalseNumber) {
        this.trueFalseNumber = trueFalseNumber;
    }

    public Integer getTrueFalseProportion() {
        return trueFalseProportion;
    }

    public void setTrueFalseProportion(Integer trueFalseProportion) {
        this.trueFalseProportion = trueFalseProportion;
    }

    public List<FillVainQuestionDTO> getFillVainQuestionDTOS() {
        return fillVainQuestionDTOS;
    }

    public void setFillVainQuestionDTOS(List<FillVainQuestionDTO> fillVainQuestionDTOS) {
        this.fillVainQuestionDTOS = fillVainQuestionDTOS;
    }

    public List<MultipleChoiceQuestionDTO> getMultipleChoiceQuestionDTOS() {
        return multipleChoiceQuestionDTOS;
    }

    public void setMultipleChoiceQuestionDTOS(List<MultipleChoiceQuestionDTO> multipleChoiceQuestionDTOS) {
        this.multipleChoiceQuestionDTOS = multipleChoiceQuestionDTOS;
    }

    public List<ShortAnswerQuestionDTO> getShortAnswerQuestionDTOS() {
        return shortAnswerQuestionDTOS;
    }

    public void setShortAnswerQuestionDTOS(List<ShortAnswerQuestionDTO> shortAnswerQuestionDTOS) {
        this.shortAnswerQuestionDTOS = shortAnswerQuestionDTOS;
    }

    public List<SingleChoiceQuestionDTO> getSingleChoiceQuestionDTOS() {
        return singleChoiceQuestionDTOS;
    }

    public void setSingleChoiceQuestionDTOS(List<SingleChoiceQuestionDTO> singleChoiceQuestionDTOS) {
        this.singleChoiceQuestionDTOS = singleChoiceQuestionDTOS;
    }

    public List<TrueFalseQuestionDTO> getTrueFalseQuestionDTOS() {
        return trueFalseQuestionDTOS;
    }

    public void setTrueFalseQuestionDTOS(List<TrueFalseQuestionDTO> trueFalseQuestionDTOS) {
        this.trueFalseQuestionDTOS = trueFalseQuestionDTOS;
    }
}
