package com.limyel.blog.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Component
@PropertySource(value = "classpath:exception-code.properties")
public class ExceptionCode {

    private final Map<Integer, String> codes;

    public String getMsg(int code) {
        return this.codes.get(code);
    }

}
