package com.example.stripe_integration.dto;

public class StripeResponse {

    private String status;
    private String message;
    private String sessionId;
    private String sessionUrl;

    private StripeResponse() {
    }

    private StripeResponse(String status, String message, String sessionId, String sessionUrl) {
        this.status = status;
        this.message = message;
        this.sessionId = sessionId;
        this.sessionUrl = sessionUrl;
    }

    public static StripeResponseBuilder builder() {
        return new StripeResponseBuilder();
    }

    public static class StripeResponseBuilder {
        private String status;
        private String message;
        private String sessionId;
        private String sessionUrl;

        public StripeResponseBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public StripeResponseBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public StripeResponseBuilder setSessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public StripeResponseBuilder setSessionUrl(String sessionUrl) {
            this.sessionUrl = sessionUrl;
            return this;
        }

        public StripeResponse build() {
            return new StripeResponse(status,message,sessionId,sessionUrl);
        }

    }
}
