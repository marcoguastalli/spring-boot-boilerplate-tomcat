package net.marco27.java.boilerplate.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResponseTimeServiceTest {

    ResponseTimeService responseTimeService;

    @BeforeEach
    void init() {
        responseTimeService = new ResponseTimeService();
    }

    @Test
    void testGetResponseTime() {
        assertThat(responseTimeService, notNullValue());
        responseTimeService.startTime();
        responseTimeService.endTime();
        final Long responseTime = responseTimeService.getResponseTime();
        assertThat(responseTime, notNullValue());
        assertThat("Invalid response time", responseTime.intValue(), greaterThanOrEqualTo(0));
    }
}