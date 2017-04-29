package com.tanchaoyin.demo.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEntry {

    @JsonProperty("total_count")
    public int total_count;

    @JsonProperty("incomplete_results")
    public boolean incomplete_results;
}
