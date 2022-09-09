package com.optimagrowth.license.model.utils;


import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class RestErrorList extends ArrayList<ErrorMessage> {

    private static final long serialVersionUID = -721424777198115589L;
    private HttpStatus status;

    public RestErrorList(HttpStatus status, ErrorMessage... errors) {
        this(status.value(), errors);
    }

    public RestErrorList(int status, ErrorMessage... errors) {
        this.status = HttpStatus.valueOf(status);
        addAll(Arrays.asList(errors));
    }




}
