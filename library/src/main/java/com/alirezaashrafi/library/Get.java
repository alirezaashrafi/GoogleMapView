package com.alirezaashrafi.library;

 class Get {
        private String key = "";
        private String value = "";

        public String getKey() {
            return key;
        }

        public Get setKey(String key) {
            this.key = key;
            return this;
        }

        public String getValue() {
            return value;
        }

        public Get setValue(String value) {
            this.value = value;
            return this;
        }

        public Get setValue(Object value) {
            this.value = String.valueOf(value);
            return this;
        }
    }