package project.noticeboard.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.noticeboard.domain.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
    public Board getByType(String type);
}
