package com.sequation.publisher.pubsub.publisher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeatureDetails {

  private Long id;
  private String name;
  private String details;

  public FeatureDetails(String name, String details) {
    this.name = name;
    this.details = details;
  }

  public FeatureDetails(Long id, String details) {
    this.id = id;
    this.details = details;
  }

}
