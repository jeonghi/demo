package com.example.demo.domain;

public enum PointTransactionStatus {
    PAYMENT("PAYMENT"),
    CANCEL("CANCEL");

    private final String getStatus;

    PointTransactionStatus(String status) {
        getStatus = status;
    }

    @Override
    public String toString(){
        return getStatus;
    }
}
