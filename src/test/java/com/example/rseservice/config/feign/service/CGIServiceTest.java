package com.example.rseservice.config.feign.service;

import com.example.rseservice.config.feign.CGIApi;
import com.example.rseservice.config.feign.request.CGIRequest;
import com.example.rseservice.config.feign.response.CGIResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CGIServiceTest {

    private CGIService cgiService;

    @Mock
    private CGIApi cgiApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.cgiService = new CGIService(cgiApi);
    }

    @Test
    void should_make_a_request_in_cgi_server() {

        CGIRequest request = dummyCGIRequest();
        CGIResponse response = this.cgiService.execute(request);

        assertNotNull(response);
        assertEquals(response.getId().longValue(), 10);
        assertEquals(response.getResult(), "50");
        assertEquals(response.getTimeElapsed().longValue(), 4568);
    }

    private CGIRequest dummyCGIRequest() {
        return null;
    }
}