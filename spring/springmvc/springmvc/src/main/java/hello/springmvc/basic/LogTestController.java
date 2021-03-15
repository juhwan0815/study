package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

        // 중요! 진짜 혼난다.
        log.trace("trace log = " + name); // 이렇게 사용하면 안된다 문자 더하기 연산이 일어나서 리소스를 사용하기 때문이다.

        log.trace("trace log = {}",name); // 이렇게 사용하자!!! 파라미터만 넘기기!!!
        log.debug("debug log = {}",name);
        log.info("info log = {}",name);
        log.warn("warn log = {}",name);
        log.error("error long = {}",name);

        return "ok";
    }

}
