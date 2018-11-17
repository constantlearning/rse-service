package com.example.rseservice.config.feign.decoder;

import com.example.rseservice.config.feign.exception.CGIException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CgiErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.status() == 404) {
            throw new CGIException("cgi-2", HttpStatus.NOT_FOUND);
        }

        throw new CGIException();
    }
}
