package org.zerock.springex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.mapper.TodoMapper;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Log4j2
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private ModelMapper modelMapper;

    //  글 하나 등록
    @Override
    public void register(TodoDTO todoDTO) {

        log.info("서비스 층에서의 modelMapper 객체 : " +modelMapper );

        TodoVO todoVO=modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.insert(todoVO);
    }

    //글 전체 조회
    @Override
    public List<TodoDTO> getAll() {

        List<TodoDTO> dtoList=todoMapper.selectAll().stream().map(vo->modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public TodoDTO getOne(Long tno) {
       TodoVO todoVO= todoMapper.selectOne(tno);
        TodoDTO todoDTO=modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class );

        todoMapper.update(todoVO);
    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }






}
