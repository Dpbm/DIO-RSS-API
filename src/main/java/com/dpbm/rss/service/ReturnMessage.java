package com.dpbm.rss.service;

public class ReturnMessage{
    private final String message;

    public ReturnMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
