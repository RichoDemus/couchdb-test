package com.richodemus.test.couchdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonWriteNullProperties(false)
@JsonIgnoreProperties({"_id", "_rev"})
public class Sofa {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("_rev")
    private String revision;

    private String color;

    public void setId(String s) {
        id = s;
    }

    public String getId() {
        return id;
    }

    public String getRevision() {
        return revision;
    }

    public void setColor(String s) {
        color = s;
    }

    public String getColor() {
        return color;
    }

    public void setRevision(String revision)
    {
        this.revision = revision;
    }
}
