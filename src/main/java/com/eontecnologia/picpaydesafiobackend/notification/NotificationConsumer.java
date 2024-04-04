package com.eontecnologia.picpaydesafiobackend.notification;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.eontecnologia.picpaydesafiobackend.transaction.Transaction;

@Service
public class NotificationConsumer {

  private RestClient restClient;

  public NotificationConsumer(RestClient.Builder builder) {
    this.restClient = builder
        .baseUrl("null")
        .build();
  }

  @KafkaListener(topics = "transaction-notification", groupId = "picpay-desafio-backend")
  public void receiveNotification(Transaction transaction) {

    var response = restClient.get()
        .retrieve()
        .toEntity(Notification.class);

    var body = response.getBody();

    if (response.getStatusCode().isError() || body != null && !body.message()) {
      throw new NotificationException("Error sending notification");
    }
  }
}
