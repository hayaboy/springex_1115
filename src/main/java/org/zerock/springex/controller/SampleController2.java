package org.zerock.springex.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController2 {


    //2) RedirectAttributes와 리다이렉션
    //PRG 패턴을 처리하기 위해서 스프링 MVC에서는 RedirectAttributes라는 특별한 타입을 제공, RedirectAttributes 역시 Model과 마찬가지로 파라미터로 추가하기만 하면 자동으로
    //생성되는 방식으로 개발할 때 사용할 수 있습니다.
    // addAttribute(키, 값) : 리다이렉트 시 쿼리 스트링이 되는 값을 지정
    // addFlashAttribute(키, 값) : 일회용으로만 데이터를 전달하고 삭제되는 값을 지정

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("name","ABC");
        redirectAttributes.addFlashAttribute("result", "success");
       return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6(){

    }



    //3) 스프링 MVC에서 컨트롤러클래스 안의 메서드의 리턴 타입
    // - void   :  컨트롤러의 @RequestMapping 값과 @GetMapping 등 메서드에서 선언된 값을 그대로 뷰(View)이름으로 사용하게 되므로, void는 주로 상황에 관계없이 동일한 화면을 보여주는 경우에 사용
    // - 문자열  :  문자열은 상황에 따라서(redirect:) 다른 화면을 보여주는 경우에 사용
    // - 객체나 배열, 기본 자료형
    // - ResponseEntity
    // 앞의 항목 중에 일반적으로 화면이 따로 있는 경우에 void나 문자열을 이용하고
    // JSON 타입을 활용할 때는 객체나 ResponseEntity(상태 코드까지 같이 전달) 타입을 주로 사용







    //스프링 MVC 컨트롤러 예외 처리
    @GetMapping("/ex7")
    public void ex7(String name, int age){
        log.info("name :" + name );
        log.info("age :" + age );
    }





}
