package project.noticeboard.domain.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.noticeboard.domain.board.Board;
import project.noticeboard.domain.board.repository.service.BoardService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final BoardService boardService;
    //메인화면 조회
    @GetMapping("/")
    public String index(Model model){
        List<Board> boards =boardService.findAll();
        model.addAttribute("boards", boards);
        return "index";
    }
}
