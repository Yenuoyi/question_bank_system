package com.org.bank.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExecuteResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T result;
    private String resultMessage;
    private List<String> errorMessages = new ArrayList();

    public ExecuteResult() {
    }

    /** @deprecated */
    @Deprecated
    public void addErrorMsg(String errorMsg) {
        this.errorMessages.add(errorMsg);
    }

    public boolean isSuccess() {
        return this.errorMessages.isEmpty();
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public List<String> getErrorMessages() {
        return this.errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public void addErrorMessage(String errorMessage) {
        this.errorMessages.add(errorMessage);
    }
}

