package com.example.madmeditation.common;

import java.util.ArrayList;
import java.util.List;

public class QuotesResponse {
    boolean success;
    List<Quotes> data;

    public QuotesResponse(boolean success, List<Quotes> data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Quotes> getData() {
        return data;
    }

    public void setData(List<Quotes> data) {
        this.data = data;
    }
}
