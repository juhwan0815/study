package com.optimagrowth.license.model.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseWrapper {

    private Object data;

    private Object metadata;

    private List<ErrorMessage> errors;

    public ResponseWrapper(Object data, Object metadata, List<ErrorMessage> errors) {
        this.data = data;
        this.metadata = metadata;
        this.errors = errors;
    }
}
