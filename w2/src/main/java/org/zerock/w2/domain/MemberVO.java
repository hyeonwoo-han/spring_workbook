package org.zerock.w2.domain;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
// VO는 읽기 전용으로 @Setter 사용 안함
public class MemberVO {
    // 테이블 구성요소 작성
    private String mid;
    private String mpw;
    private String mname;
}
