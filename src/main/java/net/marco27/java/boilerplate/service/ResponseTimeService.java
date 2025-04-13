package net.marco27.java.boilerplate.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service to measure the response time of a request
 */
@NoArgsConstructor
@Service
public class ResponseTimeService {
    private long startTime;
    private long endTime;

    public void startTime() {
        startTime = System.currentTimeMillis();
    }

    public void endTime() {
        endTime = System.currentTimeMillis();
    }

    public Long getResponseTime() {
        return endTime - startTime;
    }
}
