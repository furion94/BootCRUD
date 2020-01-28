package lgr.boot.bootreact.service;

import lgr.boot.bootreact.vo.BoardVO;

public interface IBoardService {
    public Integer insertBoard(BoardVO bvo);
    public Integer deleteBoard(String board_number);
    public Integer updateBoard(BoardVO bvo);
}
