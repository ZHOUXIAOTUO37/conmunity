package com.xt37.community.Bean;

import lombok.Data;

@Data
public class Result<T> {
    private String msg;
    private boolean success;
    private T detail;

}
