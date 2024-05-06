package com.sequation.publisher.pubsub.publisher;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meganexus.sequation.audit.producer.payload.AuditEventPayload;
import com.meganexus.sequation.message.model.BatchInput;
import com.sequation.publisher.pubsub.publisher.service.Source;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PublisherController {

    private static final String ACTION_MSG = "%s %s";
    private static final String AUDIT_MESSAGE_FORMAT_CS = "%s %s successfully by %s";
    
    @Autowired
    private AuditService auditService;

  @Autowired
  private Source source;

    @PostMapping("/postMessage")
    public void sendMessage(
            @RequestBody AuditEventPayload auditEventPayload) throws JsonProcessingException {
        // UserMessage userMessage = new UserMessage(messageBody, username);
        auditService.triggerAuditEvent(auditEventPayload);

    }

    @PostMapping("/streamBridge")
    public void streamBridge(
            @RequestBody BatchInput message) throws JsonProcessingException {
       //String command="{\"id\":228,\"templateId\":1,\"userType\":\"PATIENT\",\"pdfPath\":null,\"csvPath\":null,\"performanceReportPath\":null,\"commandLine\":\" nextflow run -c nf-az-metagrs.config genome_to_report_v2.nf -process.queue MetaGRSPipleinePool -w 'az://storegene-data/nextflow-logs' -with-docker 'gwissandbox.azurecr.io/genome-tools:test' -with-report az://storegene-data/pipeline-data/templates/1/performance-report/patient/228_202405031850.html --id  228 --base_dir 'az://storegene-data/' --template_id  1 --data_dir patient-data --barcode QLSD121212 \",\"pipeline\":\"REPORT\",\"barcode\":\"QLSD121212\",\"templateName\":\"Cardiovascular Risk Assessment\"}";
        String topicName = "metagrs-topic";
        message.setCreatedAt(LocalDateTime.now());
       System.out.println("Sent message to topic: " + topicName + " message: " + message + " Status: "+source.sendMessageToTopic( topicName,message));

    }

    


}