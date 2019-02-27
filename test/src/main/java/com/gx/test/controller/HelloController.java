package com.gx.test.controller;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;


/**
 * @author gx
 * @ClassName: HelloController
 * @Description: java类作用描述
 * @date 2019/2/25 23:20
 * @Version: 1.0
 * @since
 */
@RestController
public class HelloController {
    private final static MetricRegistry registry = new MetricRegistry();
    private final static Meter requestMeter = registry.meter("tqs");

    @RequestMapping("/hi")
    @Timed(value = "all.people", longTask = true)
    public String hi(){
        requestMeter.mark();
        return "hi ttt 123";

    }

    @RequestMapping("/xx")
    public String xx(){
        return "hi 123";

    }
    @RequestMapping("/yy")
    public String yy(){
        return "hi 123";

    }

    @PostConstruct
    public void init() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
                .convertRatesTo(TimeUnit.MINUTES)
                .convertDurationsTo(TimeUnit.MINUTES).build();
        reporter.start(10, TimeUnit.SECONDS);
    }

}
