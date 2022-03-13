package com.example.madmeditation.common;

import java.util.List;

public class FeelingsResponse {
    boolean success;
    List<Feelings> data;

    public FeelingsResponse(boolean success, List<Feelings> data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Feelings> getData() {
        return data;
    }

    public void setData(List<Feelings> data) {
        this.data = data;
    }
}
