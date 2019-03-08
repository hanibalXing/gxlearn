package com.gx.test.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author gx
 * @ClassName: HelloController
 * @Description: java类作用描述
 * @date 2019/2/25 23:20
 * @Version: 1.0
 * @since
 */
@RestController
public class TestController {
    @RequestMapping("/123")
    @Timed(value = "all.people", longTask = true)
    public String hi(){
        return "hi ttt";

    }

    @RequestMapping("/321")
    public String xx(){
        return "hi 123";

    }
    @RequestMapping("/1234")
    public String yy(){
        return "hi 123";

    }

}
