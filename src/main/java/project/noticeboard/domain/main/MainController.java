package project.noticeboard.domain.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    //메인화면 조회
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
