package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")    //url 주소
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");  //hello.html 내부안 data키 값을 찾아  value를 출력
        return "hello"; //templates 안의 hello.html 을 찾아간다.
    }

    @GetMapping("hello-mvc")    //localhost8080/hello-mvc만 하면 오류 발생 ?name=spring!! 입력
    public String helloMvc(@RequestParam("name") String name, Model model) {    //외부에서 파라미터를 받을예정
        model.addAttribute("name", name);   //key= param으로 넘어오는 값 value= String name
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   //html 대신 body에 문자 내용을 직접 반환
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
