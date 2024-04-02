package com.eontecnologia.picpaydesafiobackend.authorization;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.eontecnologia.picpaydesafiobackend.transaction.Transaction;

@Service
public class AuthorizerService {
  private RestClient restClient;

  public AuthorizerService(RestClient.Builder builder) {
    this.restClient = builder
        .baseUrl("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc")
        .build();
  }

  public void authorize(Transaction transaction) {
    var response = restClient.get()
        .retrieve()
        .toEntity(Authorization.class);

  }

}
