package com.dpbm.rss.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class Handler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFound.class)
    public void userNotFoundHandler(){}

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RssNotFound.class)
    public void rssNotFoundHandler(){}

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PostNotFound.class)
    public void postNotFoundHandler(){}

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PublisherNotFound.class)
    public void publisherNotFoundHandler(){}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UpdateWithoutId.class)
    public void updateWithoutIdHandler(){}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InsertWithId.class)
    public void insertWithIdHandler(){}
}
