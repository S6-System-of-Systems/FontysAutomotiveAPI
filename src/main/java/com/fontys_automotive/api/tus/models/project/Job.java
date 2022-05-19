package com.fontys_automotive.api.tus.models.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Job {
        @JsonProperty("customer_id")
        public String customerId;
        public String statusCode;
        @JsonProperty("is_processed_internally")
        public boolean isProcessedInternally;
        public String url;
        public String id;
        public String source;
        @JsonProperty("creation_date")
        public String creationDate;
        @JsonProperty("import_date")
        public String importDate;
        public String languageCode;
        public Position position;

        public Job(String customerId, String statusCode, boolean isProcessedInternally, String url, String id, String source, String creationDate, String import_date, String languageCode, Position position) {
                this.customerId = customerId;
                this.statusCode = statusCode;
                this.isProcessedInternally = isProcessedInternally;
                this.id = id;
                this.source = source;
                this.creationDate = creationDate;
                this.importDate = import_date;
                this.languageCode = languageCode;
                this.position = position;
                this.url = url;
        }
}

