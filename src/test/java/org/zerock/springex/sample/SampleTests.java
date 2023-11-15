package org.zerock.springex.sample;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;


//@ContextConfiguration은 통합 테스트를 위해 ApplicationContext를 로드하고 구성하는 방법을
// 결정하는 데 사용되는 클래스 수준 메타데이터를 정의합니다.

@Log4j2
@ExtendWith(SpringExtension.class) // JUni5버전에서  spring-test를 이용하기 위한 설정, JUnit4에서는 @Runwith
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml") // 스프링의 설정 정보 로딩
public class SampleTests {

    @Autowired
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testSercie(){
        log.info("샘플서비스 객체 주입 확인 2: "+ sampleService);
        Assertions.assertNotNull(sampleService);

    }



    @Test
    public void testConnection() throws Exception{

        Connection connection =dataSource.getConnection();
        log.info("커넥션 객체 : " + connection);
        Assertions.assertNotNull(connection);
        connection.close();

    }




}
