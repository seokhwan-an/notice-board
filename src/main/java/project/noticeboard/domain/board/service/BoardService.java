package project.noticeboard.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.noticeboard.domain.board.Board;
import project.noticeboard.domain.board.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> findAll(){
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    public Optional<Board> findbyId(Long id){
        Optional<Board> board = Optional.ofNullable(boardRepository.getById(id));
        return board;
    }

    public Board findbyType(String type){
        Board board = boardRepository.getByType(type);
        return board;
    }
}
