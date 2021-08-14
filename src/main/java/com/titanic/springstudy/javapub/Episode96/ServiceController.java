package com.titanic.springstudy.javapub.Episode96;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/")
public class ServiceController {

    private final Timer timer;
    private final AtomicLong gauge = new AtomicLong(1);

    public ServiceController(MeterRegistry meterRegistry) {
        timer = meterRegistry.timer("responsetimer", "success", "true", "other", "false");
        meterRegistry.gauge("lastRandomNumber", gauge);
    }

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<HelloServiceResponse> getResponse() {
        return Mono.just(createResponse());
    }

    @Timed("createResponse")
    public HelloServiceResponse createResponse() {
        timer.record(() -> {
            try {
                Thread.sleep((long) (Math.random()*500));
                gauge.set((long) Math.random() * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return new HelloServiceResponse("hello world");
    }


}
