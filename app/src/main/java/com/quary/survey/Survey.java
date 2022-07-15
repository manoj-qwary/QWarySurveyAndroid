package com.quary.survey;

import android.app.Activity;
import android.content.Intent;

public class Survey {

    private String domain;
    private String token;
    private Boolean loader;

    private Activity activity;

    public Survey(Builder builder) {
        this.activity = builder.activity;
        this.domain = builder.domain;
        this.token = builder.token;
        this.loader = builder.loader;

        Intent intent = new Intent(this.activity, SurveyActivity.class);
        intent.putExtra("domain", this.domain);
        intent.putExtra("token", this.token);
        intent.putExtra("loader", this.loader);
        this.activity.startActivity(intent);
        this.activity.finish();
    }

    public static class Builder {

        private Activity activity;
        private String domain;
        private String token;
        private Boolean loader;

        public Builder setActivity(Activity activity) {
            this.activity = activity;
            return this;
        }

        public Builder setDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder setToken(String token) {
            this.token = token;
            return this;
        }

        public Builder setLoader(Boolean loader) {
            this.loader = loader;
            return this;
        }

        public Survey show() {
            return new Survey(this);
        }
    }
}
