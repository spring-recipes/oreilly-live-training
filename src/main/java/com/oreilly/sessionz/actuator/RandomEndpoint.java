package com.oreilly.sessionz.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Endpoint(id = "random")
public class RandomEndpoint {

    @ReadOperation
    public String random() {
        return String.valueOf(new Random().nextInt());
    }

}