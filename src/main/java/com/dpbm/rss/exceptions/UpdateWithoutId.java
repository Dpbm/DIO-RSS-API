package com.dpbm.rss.exceptions;

public class UpdateWithoutId extends Exception{
    public UpdateWithoutId(){
        super("Your Tried to update data without passing its ID!");
    }
}
