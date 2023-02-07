package org.zerock.springex.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CheckboxFormatter implements Formatter<Boolean> {
    // TodoDTO가 데이터를 수집할 때 finished의 on을 boolean 타입으로 받아야함
    // 컨트롤러에서 데이터 타입을 변경하기 위한 CheckboxFormatter

    @Override
    public Boolean parse(String text, Locale locale) throws ParseException{
        if(text == null){
            return false;
        }
        return text.equals("on");
    }

    @Override
    public String print(Boolean object, Locale locale){
        return object.toString();
    }
}
