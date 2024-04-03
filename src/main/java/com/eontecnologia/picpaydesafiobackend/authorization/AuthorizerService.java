package com.eontecnologia.picpaydesafiobackend.authorization;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.eontecnologia.picpaydesafiobackend.transaction.Transaction;

@Service
public class AuthorizerService {
  private RestClient restClient;

  public AuthorizerService(RestClient.Builder builder) {
    this.restClient = builder
        .baseUrl("http://localhost:3000/status")
        .build();
  }

  public void authorize(Transaction transaction) {

    var response = restClient.get()
        .retrieve()
        .toEntity(Authorization.class);

    var body = response.getBody();

    if (response.getStatusCode().isError() || body != null && !body.isAuthorized()) {
      throw new UnauthorizedTransactionException("Unauthorized transaction");
    }
  }
}
