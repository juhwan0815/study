package spring.study.replication.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.datasource" ) // 프로퍼티 파일에 적어준 정보를 꺼낸다.
public class CustomDataSourceProperties {

    private String url;
    private String driverClassName;
    private String username;
    private String password;
    private final Map<String,Slave> slave = new HashMap<>();

    @Getter
    @Setter
    public static class Slave{
       private String name;
       private String url;
    }
}

