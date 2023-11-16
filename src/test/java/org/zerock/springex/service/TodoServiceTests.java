package org.zerock.springex.service;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
import org.zerock.springex.dto.TodoDTO;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {


    @Autowired
    private TodoService todoService;


    @Test
    public void testRegister(){
        TodoDTO todoDTO=TodoDTO.builder().title("Test1_1....").dueDate(LocalDate.now()).writer("user01").build();
        todoService.register(todoDTO);
    }




    //페이징 처리 후 글 목록 조회
    @Test
    public void testPaging() {
        PageRequestDTO pageRequestDTO=PageRequestDTO.builder().page(1).size(10).build();

        PageResponseDTO<TodoDTO>  pageResponseDTO=todoService.getList(pageRequestDTO);

        log.info("페이징 처리 후 , total,  start, end, prev, next" + pageResponseDTO);
        //예상   total 1024, start 1, end 10  prev : false , next  :true , dtoList(1526~1517)

        pageResponseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));
    }




}
