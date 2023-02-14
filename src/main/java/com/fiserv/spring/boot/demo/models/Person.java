package com.fiserv.spring.boot.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Person {
    @JacksonXmlProperty(isAttribute = true, localName = "fullName")
    @JsonProperty("fullName")
    private String name;

    public Person(String name) {
        super();
        this.name = name;
    }
}
