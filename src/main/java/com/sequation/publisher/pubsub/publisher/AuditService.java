package com.sequation.publisher.pubsub.publisher;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meganexus.sequation.audit.producer.payload.AuditEvent;
import com.meganexus.sequation.audit.producer.payload.AuditEventPayload;
import com.meganexus.sequation.audit.producer.payload.Operations;
import com.meganexus.sequation.audit.producer.template.EquationAuditTemplate;
import com.sequation.publisher.pubsub.publisher.service.Source;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class AuditService implements Consumer<AuditInfo<Object>> {

  protected static final String ID = "1";

  @Autowired
  private EquationAuditTemplate equationAuditTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private Source source;

  

  @Override
  public void accept(AuditInfo<Object> auditInfo) {
    System.out.println("auditInfo: " + auditInfo);
    source.sendMessageToTopic("audit-topic",new AuditEvent(""+UUID.randomUUID(),(AuditEventPayload) auditInfo.getData() ));
  }

  public void triggerAuditEvent(FeatureDetails featureInfo, Operations operation,
      String serviceName) throws JsonProcessingException {

    

    AuditEventPayload auditEventPayload = AuditEventPayload.builder().serviceName(serviceName)
        .operation(operation).serviceUserId(null).userId("UserID"+Math.random())
        .featureDetails(objectMapper.writeValueAsString(featureInfo))
        .userName("VINISH").featureName(serviceName).currentDate(LocalDateTime.now())
        .build();
    this.accept(AuditInfo.builder().data(auditEventPayload).build());
  }

  

  public void triggerAuditEvent(FeatureDetails featureInfo, Operations operation,
      String serviceName, String userName) throws JsonProcessingException {
    AuditEventPayload auditEventPayload = AuditEventPayload.builder().serviceName(serviceName)
        .operation(operation).serviceUserId(null).userId(userName)
        .featureDetails(objectMapper.writeValueAsString(featureInfo)).userName(userName)
        .featureName(serviceName).currentDate(LocalDateTime.now()).build();
    this.accept(AuditInfo.builder().data(auditEventPayload).build());
  }

  public void triggerAuditEvent(AuditEventPayload auditEventPayload) throws JsonProcessingException {
    this.accept(AuditInfo.builder().data(auditEventPayload).build());
  }



  public void triggerAuditEvent(FeatureDetails featureInfo, Operations operation,
      String serviceName, Object authUser) throws JsonProcessingException {

    AuditEventPayload auditEventPayload = AuditEventPayload.builder().serviceName(serviceName)
        .operation(operation).serviceUserId(null).userId("USERID"+Math.random())
        .featureDetails(objectMapper.writeValueAsString(featureInfo))
        .userName("VINISH").featureName(serviceName).currentDate(LocalDateTime.now())
        .build();
    this.accept(AuditInfo.builder().data(auditEventPayload).build());
  }
}
