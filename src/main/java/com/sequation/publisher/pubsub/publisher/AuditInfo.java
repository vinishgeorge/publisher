package com.sequation.publisher.pubsub.publisher;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Prashant.Shelhalkar
 *
 * @param <T> Generic T is used for the future development
 */
@Builder
@ToString
@Data
public class AuditInfo<T> {

  /**
   * Generic T is used for the future development
   */
  private T data;

}
