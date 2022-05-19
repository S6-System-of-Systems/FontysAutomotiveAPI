package com.fontys_automotive.api.tus.models.project;

import lombok.Data;

@Data
public class Job {
        public String customer_id;
        public String statusCode;
        public boolean is_processed_internally;
        public String url;
        public String id;
        public String source;

        public Job(String customer_id, String statusCode, boolean is_processed_internally, String url, String id, String source, String creation_date, String import_date, String languageCode, Position position) {
                this.customer_id = customer_id;
                this.statusCode = statusCode;
                this.is_processed_internally = is_processed_internally;
                this.id = id;
                this.source = source;
                this.creation_date = creation_date;
                this.import_date = import_date;
                this.languageCode = languageCode;
                this.position = position;
                this.url = url;
        }

        public String creation_date;
        public String import_date;
        public String languageCode;
        public Position position;
}

