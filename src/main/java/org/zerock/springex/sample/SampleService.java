package org.zerock.springex.sample;


import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;




@Service
@ToString
@RequiredArgsConstructor // 필요한 생성자 함수 자동으로 작성
public class SampleService {


//    //1)필드 주입 방식
//    @Autowired
//    private SampleDAO sampleDAO;


    //2)생성자 주입 방식
    // 주입 받아야 하는 객체의 변수는 final로 작성합니다.


    private final SampleDAO sampleDAO;
}
