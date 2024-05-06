/*
 * Copyright 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

 package com.sequation.publisher.publisher.model;

 import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import lombok.AllArgsConstructor;
 
 /**
  * A user message for the sample app.
  *
  * @author Elena Felder
  *
  * @since 1.2
  */
 public class UserMessage {
 
     private String body;
 
     private String username;
 
     private LocalDateTime createdAt;
 
     public UserMessage() {
     }

     public UserMessage(String body, String username, Date createdAt) {
        this.body = body;
        this.username = username;
        this.createdAt = LocalDateTime.ofInstant(createdAt.toInstant(), ZoneId.systemDefault());
    }
 
     public String getBody() {
         return this.body;
     }
 
     public void setBody(String body) {
         this.body = body;
     }
 
     public String getUsername() {
         return this.username;
     }
 
     public void setUsername(String username) {
         this.username = username;
     }
 
     public LocalDateTime getCreatedAt() {
         return this.createdAt;
     }
 
     public void setCreatedAt(LocalDateTime createdAt) {
         this.createdAt = createdAt;
     }
 
 }
 