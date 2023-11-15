package org.zerock.springex.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

import java.time.LocalDate;

//@Controller
@Log4j2
@RequestMapping("/todo")
public class SampleController {


    //스프링 MVC 컨트롤러의 특징
    // 1) 상속이나 인터페이스를 구현하는 방식을 사용하지 않고 어노테이션으로 처리 가능, 2) 오버라이드 없이 필요한 메서드들 정의
    // 3) 메소드의 파라미터를 기본 자료형이나 객체 자료형을 마음대로 지정, 4)메소드의 리턴타입도 void, String 객체 등 다양한 타입을 사용할 수 있음
    //5) 서블릿 중심의 MVC의 경우 Servlet을 상속 받아 doGet/doPost와 같은 제한적인 메서드를 오버라이드해서 사용했지만
    // 스프링 MVC의 경우 하나의 컨트롤러를 이용해서 여러 경로의 호출을 모두 처리
    @GetMapping(value = "/hello")  //스프링 4버전 이후 추가
    public void hello(){
        log.info("hello.......");
    }


//    @RequestMapping("/list")
//    public void list(){
//        log.info("todo list ......");
//    }


//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    @GetMapping("/register")
//    public void registerGet(){
//        log.info("GET todo register ......");
//    }


//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @PostMapping("/register")
//    public void registerPost(){
//        log.info("Post todo register ......");
//    }


    // 스프링 MVC 특징
    // 1)단순 파라미터 자동 수집
    // - 기본 자료형의 경우에는 자동으로 형 변환 처리 가능
    // - 객체 자료형의 경우는 setXXX()의 동작을 통해서 처리
    // - 객체 자료형의 경우 생성자가 없거나 파라미터가 없는 생성자가 필요(Java Beans)
    @GetMapping("/ex1")
    public void ex1(String name, int age){
        log.info("ex1.....");
        log.info("name : "  + name);
        log.info("age : "  + age);
    }


    // 스프링 MVC의 파라미터는 기본적으로 요청에 전달된 파라미터 이름을 기준으로 동작하지만 간혹 파라미터가 전달되지 않으면 문제가 발생할 수 있다.
    // 이런 경우라면 @RequsetParam을 고려
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name, @RequestParam(name = "age", defaultValue = "20") int age){
        log.info("ex2.....");
        log.info("name : "  + name);
        log.info("age : "  + age);
    }



    // Formatter를 이용한 파라미터의 커스텀 처리
    // 기본적으로 HTTP는 문자열로 데이터를 전달하기 때문에 컨트롤러는 문자열을 기준으로 특정한 클래스의 객체로 처리하는 작업이 진행 됨, 그래서 문제는 날짜 관련 타입
    // 브라우저에서 '2023-11-14'과 같은 형태의 문자열을 Date나 LocalDate, LocalDateTime 등으로 변환하는 작업이 많이 필요하지만 이에 대한 파라미터 수집은 에러가 발생
    // 그럴 경우 Formatter 사용 , 문자열을 객체로, 객체를 문자열로 변환해줌
    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate){
        log.info("ex3.....");
        log.info("dueDate : " + dueDate );
    }



    //기존 ModelAndView
//    @GetMapping("/ex4_1")
//    public ModelAndView ex4_1(Model model){
//        log.info("ex4_1.....");
//        model.addAttribute("menu" , "noodle_mav");
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("ex4");
//        return mav;
//    }



    //초기 스프링 MVC에서는 ModelAndView 객체를 생성하는 방식으로 사용했지만
    //스프링 MVC3 버전 이후에는 Model(org.springframework.ui.Model)이라는 파라미터만
    //추가하면 됨
    @GetMapping("/ex4")
    public void ex4(Model model){
        log.info("ex4.....");
        model.addAttribute("menu" , "noodle");
    }


    // Java Beans와 @ModelAttribute
    // 스프링 MVC의 컨트롤러는 특이하게도 파라미터로 getter/setter를 이용하는 Java Beans의 형식의 사용자 정의 클래스가
    //파라미터인 경우에는 자동으로 화면까지 객체를 전달합니다.
    @GetMapping("/ex4_2")
    public void ex4_2(TodoDTO todoDTO){   //JSP화면에서 TodoDTO의 첫글자를 소문자로 변경되어 처리 ${todoDTO}
        log.info("ex4_2.....");
//        model.addAttribute("menu" , "noodle");
        log.info(todoDTO);
    }




    @GetMapping("/ex4_3")  // 만일 자동으로 생성된 변수명 todoDTO라는 이름 외에 다른 이름을 사용하고 싶을 경우
    public void ex4_3(@ModelAttribute("dto") TodoDTO todoDTO){
        log.info("ex4_3.....");
        log.info(todoDTO);
    }


    //2) RedirectAttributes와 리다이렉션
    //PRG 패턴을 처리하기 위해서 스프링 MVC에서는 RedirectAttributes라는 특별한 타입을 제공, RedirectAttributes 역시 Model과 마찬가지로 파라미터로 추가하기만 하면 자동으로
    //생성되는 방식으로 개발할 때 사용할 수 있습니다.
    // addAttribute(키, 값) : 리다이렉트 시 쿼리 스트링이 되는 값을 지정
    // addFlashAttribute(키, 값) : 일회용으로만 데이터를 전달하고 삭제되는 값을 지정

    @GetMapping("/ex5_1")
    public String ex5_1( ){
        log.info("ex5_1.....");

        return "ex6_1";
    }

    @GetMapping("/ex5_2")
    public String ex5_2( ){
        log.info("ex5_2.....");

        return "redirect:/todo/ex6";
    }
    @GetMapping("/ex6")
    public String ex6(){
     log.info("ex6.....##");
        return "todo/ex6";
    }



 //3)리턴 타입





}
