package com.tanchaoyin.demo.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo extends BaseEntry {

    @JsonProperty("items")
    public List<Items> items;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Items {

        @JsonProperty("login")
        public String login;

        @JsonProperty("avatar_url")
        public String avatar_url;

        @JsonProperty("repos_url")
        public String repos_url;

        @JsonProperty("id")
        public String id;

/*
        @JsonProperty("gravatar_id")
        public String gravatar_id;

        @JsonProperty("url")
        public String url;

        @JsonProperty("html_url")
        public String html_url;

        @JsonProperty("followers_url")
        public String followers_url;

        @JsonProperty("following_url")
        public String following_url;

        @JsonProperty("gists_url")
        public String gists_url;

        @JsonProperty("starred_url")
        public String starred_url;

        @JsonProperty("subscriptions_url")
        public String subscriptions_url;

        @JsonProperty("organizations_url")
        public String organizations_url;

        @JsonProperty("events_url")
        public String events_url;

        @JsonProperty("received_events_url")
        public String received_events_url;

        @JsonProperty("type")
        public String type;

        @JsonProperty("site_admin")
        public String site_admin;*/
    }
}
