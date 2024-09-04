package inhatc.cse.seohyeonshop.start.controller;

import inhatc.cse.seohyeonshop.start.dto.StartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping("/")
    public String start(Model model){
        StartDto startDto = StartDto.builder()
                .dept("컴시과")
                .grade(3)
                .name("고서현")
                .build();
        model.addAttribute("data",startDto);
        return "start";

    }

}
