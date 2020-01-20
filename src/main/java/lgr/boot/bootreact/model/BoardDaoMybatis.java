package lgr.boot.bootreact.model;

import lgr.boot.bootreact.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDaoMybatis extends Repository {
    public Integer insertBoard(BoardVO bvo);
    public Integer deleteBoard(String board_number);
    public Integer updateBoard(BoardVO bvo);
}
