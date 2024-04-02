package com.eontecnologia.picpaydesafiobackend.notification;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {
  private final KafkaTemplate<String, Notification> kafkaTemplate;

  public NotificationProducer(KafkaTemplate<String, Notification> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }
}
