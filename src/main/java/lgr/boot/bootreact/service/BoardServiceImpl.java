package lgr.boot.bootreact.service;

import lgr.boot.bootreact.model.BoardDaoMybatis;
import lgr.boot.bootreact.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements IBoardService{
    @Autowired
    private final BoardDaoMybatis dao;

    public BoardServiceImpl (BoardDaoMybatis dao){
        this.dao = dao;
    }

    @Override
    public Integer insertBoard(BoardVO bvo) {
        return dao.insertBoard(bvo);
    }

    @Override
    public Integer deleteBoard(String board_number) {
        return dao.deleteBoard(board_number);
    }

    @Override
    public Integer updateBoard(String board_number, String content) {
        return dao.updateBoard(board_number, content);
    }
}
