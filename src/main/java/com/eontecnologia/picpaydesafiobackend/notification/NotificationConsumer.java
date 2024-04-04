package com.eontecnologia.picpaydesafiobackend.notification;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NotificationConsumer {

  private RestClient restClient;

  public NotificationConsumer(RestClient.Builder builder) {
    this.restClient = builder
        .baseUrl("null")
        .build();
  }
}
