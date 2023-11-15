package org.zerock.springex.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.service.TodoService;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    @Autowired
    private TodoService todoService;



    //글 전체 조회
    @RequestMapping("/list")
    public void list(Model model){
        log.info("todo list ......");
        model.addAttribute("dtoList", todoService.getAll());
    }

    @GetMapping("/register")
    public void registerGet(){log.info("GET todo register ......");
    }

    //글 하나 등록

    //@Valid, BindingResult 유효성 검사기를 적용할 수 있도록 함
    @PostMapping("/register")  //스프링 MVC에서 객체 자료형의 경우는 setXXX()의 동작을 통해서 처리
    public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("Post todo register ......");
        log.info("매개변수로 들어온 TodoDTO : "+todoDTO);


        if(bindingResult.hasErrors()){
            log.info("유효하지 않은 데이터가 들어옴");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }



    //글 하나 읽기
    @GetMapping("/read")
    public void read(Long tno, Model model){
    TodoDTO todoDTO =todoService.getOne(tno);
    log.info(todoDTO);
    model.addAttribute("dto", todoDTO);
    }


    //글 하나 수정 화면으로
    @GetMapping("/modify")
    public void modify(Long tno, Model model){
        TodoDTO todoDTO =todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto", todoDTO);
    }

    //글 하나 수정 서버에 반영
    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO,  BindingResult bindingResult,RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            log.info("데이터 유효하지 않음");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
            redirectAttributes.addAttribute("tno", todoDTO.getTno() );
            return "redirect:/todo/modify";
        }
        log.info(todoDTO);
        todoService.modify(todoDTO);

        redirectAttributes.addAttribute("tno", todoDTO.getTno() );

        return "redirect:/todo/read";
    }

    //글 하나 삭제
    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes){

        log.info("-------------remove------------------");
        log.info("tno: " + tno);
        todoService.remove(tno);

        return "redirect:/todo/list";

    }


}
