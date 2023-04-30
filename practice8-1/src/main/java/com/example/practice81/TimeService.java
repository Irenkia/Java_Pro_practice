package com.example.practice81;

import java.time.Instant;
@MyContainerScan
@MyComponent
public class TimeService {
    public Instant getNow() {

        return Instant.now();
    }
}
