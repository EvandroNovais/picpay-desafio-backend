package com.eontecnologia.picpaydesafiobackend.authorization;

public class UnauthorizedTransactionException extends RuntimeException {
  public UnauthorizedTransactionException(String message) {
    super(message);
  }
}
