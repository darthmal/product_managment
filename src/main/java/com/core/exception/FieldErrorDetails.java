package com.core.exception;


public class FieldErrorDetails {
    private String fieldName;
    private String errorMessage;

    public static FieldErrorDetailsBuilder builder() {
        return new FieldErrorDetailsBuilder();
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public FieldErrorDetails() {
    }

    public FieldErrorDetails(String fieldName, String errorMessage) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
    }

    public static class FieldErrorDetailsBuilder {
        private String fieldName;
        private String errorMessage;

        FieldErrorDetailsBuilder() {
        }

        public FieldErrorDetailsBuilder fieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public FieldErrorDetailsBuilder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public FieldErrorDetails build() {
            return new FieldErrorDetails(this.fieldName, this.errorMessage);
        }

        public String toString() {
            return "FieldErrorDetails.FieldErrorDetailsBuilder(fieldName=" + this.fieldName + ", errorMessage=" + this.errorMessage + ")";
        }
    }
}
