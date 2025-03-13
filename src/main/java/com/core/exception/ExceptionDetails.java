package com.core.exception;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ExceptionDetails {
    private String message;
    private List<FieldErrorDetails> fieldErrorDetails;

    public static ExceptionDetailsBuilder builder() {
        return new ExceptionDetailsBuilder();
    }

    public String getMessage() {
        return this.message;
    }

    public List<FieldErrorDetails> getFieldErrorDetails() {
        return this.fieldErrorDetails;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFieldErrorDetails(List<FieldErrorDetails> fieldErrorDetails) {
        this.fieldErrorDetails = fieldErrorDetails;
    }

    public ExceptionDetails() {
    }

    public ExceptionDetails(String message, List<FieldErrorDetails> fieldErrorDetails) {
        this.message = message;
        this.fieldErrorDetails = fieldErrorDetails;
    }

    public static class ExceptionDetailsBuilder {
        private String message;
        private List<FieldErrorDetails> fieldErrorDetails;

        ExceptionDetailsBuilder() {
        }

        public ExceptionDetailsBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ExceptionDetailsBuilder fieldErrorDetails(List<FieldErrorDetails> fieldErrorDetails) {
            this.fieldErrorDetails = fieldErrorDetails;
            return this;
        }

        public ExceptionDetails build() {
            return new ExceptionDetails(this.message, this.fieldErrorDetails);
        }

        public String toString() {
            String var10000 = this.message;
            return "ExceptionDetails.ExceptionDetailsBuilder(message=" + var10000 + ", fieldErrorDetails=" + String.valueOf(this.fieldErrorDetails) + ")";
        }
    }
}
