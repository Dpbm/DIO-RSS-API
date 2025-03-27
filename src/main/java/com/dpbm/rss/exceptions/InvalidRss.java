package com.dpbm.rss.exceptions;

public class InvalidRss extends Exception{
    public InvalidRss(){
        super("You must provide a RSS to your post");
    }
}
