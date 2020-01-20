package lgr.boot.bootreact.model;

import lgr.boot.bootreact.vo.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDaoJPA extends JpaRepository<BoardVO, Integer> {
}
