package com.example.practice122.exception;

public class DaoException extends RuntimeException {
    public DaoException() {
        super();
    }
    public DaoException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DaoException(String message) {
        super(message);
    }
    public DaoException(Throwable throwable) {
        super(throwable);
    }
}
