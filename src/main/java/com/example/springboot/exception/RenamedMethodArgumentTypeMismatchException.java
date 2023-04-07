package com.example.springboot.exception;

public class RenamedMethodArgumentTypeMismatchException extends RuntimeException{

    private String msg;
    public RenamedMethodArgumentTypeMismatchException(){}
    public RenamedMethodArgumentTypeMismatchException(String msg)
    {
        super(msg);
        this.msg = msg;
    }

}
