package org.zerock.springex.mapper;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests {

//    @Autowired(required = false) //required = false로 하면 해당 객체를 주입받지 못하더라도 예외가 발생하지 않음
    //@Autowired
//    private TimeMapper timeMapper;

    @Autowired
    private TimeMapper timeMapper;



    @Test
    public void testGetTime(){

        //MyBatis와 스프링을 연동하고 매퍼 인터페이스를 활용하는 방식은 개발자가 실제 동작하는 클래스와
        //객체를 생성하지 않고, 스프링에서 자동으로 생성되는 방식을 이용
        //스프링에서 자동으로 생성된 객체를 이용하기 때문에 개발자가 직접 코드를 수정할 수 없다는 단점이 있기는 하지만
        // 인터페이스만으로도 개발을 완료할 수 있다는 장점도 있다.
        log.info(timeMapper);
        Assertions.assertNotNull(timeMapper);
        log.info("스프링-마이바티스 DB 설정 후 가져온 시간#" + timeMapper.getNow());
    }
}
