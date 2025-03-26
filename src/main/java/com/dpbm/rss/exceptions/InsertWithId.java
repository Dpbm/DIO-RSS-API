package com.dpbm.rss.exceptions;

public class InsertWithId extends Exception{
    public InsertWithId(){
        super("You attempted to add a add data passing its ID");
    }
}
