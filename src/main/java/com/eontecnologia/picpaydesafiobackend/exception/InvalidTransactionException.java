package com.eontecnologia.picpaydesafiobackend.exception;

public class InvalidTransactionException extends RuntimeException {
  public InvalidTransactionException(String message) {
    super(message);
  }
}
