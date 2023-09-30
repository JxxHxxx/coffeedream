package com.jxx.toy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing // 여러가지 배치에 필요한 컴포넌트를 등록해준다.
@SpringBootApplication
public class CoffeedreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeedreamApplication.class, args);
    }

}
