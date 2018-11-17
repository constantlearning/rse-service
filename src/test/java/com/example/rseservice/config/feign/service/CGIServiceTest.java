package com.example.rseservice.config.feign.service;

import com.example.rseservice.config.feign.CGIApi;
import com.example.rseservice.config.feign.request.CGIRequest;
import com.example.rseservice.config.feign.response.CGIResponse;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
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
    @Ignore
    //TODO: FAZER ESSE TESTE FUNCIONAR
    void should_make_a_request_in_cgi_server() {

        CGIRequest request = dummyCGIRequest();
        CGIResponse response = this.cgiService.execute(request);

        assertNotNull(response);
        assertEquals(response.getId().longValue(), 10);
        assertEquals(response.getResult(), "50");
        assertEquals(response.getTimeElapsed().longValue(), 4568);
    }

    private CGIRequest dummyCGIRequest() {
        CGIRequest request = new CGIRequest();
        request.setId(1L);
        request.setHowManyArguments(2L);
        request.setArguments(Arrays.asList("10", "20"));
        request.setType("javascript");
        request.setContent("function sum(p1, p2) { return p1 + p2; }");

        return request;
    }

}