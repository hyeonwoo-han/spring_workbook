package org.zerock.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service    // 서비스 객체를 생성
@ToString
@RequiredArgsConstructor    // DI를 위한 생성자 자동 생성
public class SampleService {

    // @Autowired -> 필드 주입 대신 생성자 주입을 위해 삭제
    // 생성자 주입 방식의 규칙 -> 주입할 객체 final 선언
    @Qualifier("normal")
    private final SampleDAO sampleDAO;

}
