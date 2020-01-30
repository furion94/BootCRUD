package lgr.boot.bootreact.ctrl;

import lgr.boot.bootreact.common.TestingBean;
import lgr.boot.bootreact.model.BoardDaoJPA;
import lgr.boot.bootreact.service.IBoardService;
import lgr.boot.bootreact.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@Slf4j
public class controller {

    @Autowired
    private BoardDaoJPA jpa;
    @Autowired
    private IBoardService mybatis;
//    @Autowired
//    private TestingBean tb;

    @GetMapping("/")
    public String welcome(HttpServletRequest request){
        request.setAttribute("pName", "List");
//        tb.testtt(); // properties 읽어온 Bean 테스트 코드
        return "main";
    }

    @ResponseBody
    @GetMapping("/board")
    public List<BoardVO> listAll(){
        log.info("전체조회");
        return jpa.findAll();
    }

    @ResponseBody
    @GetMapping("/board/{num}")
    public BoardVO selectOne(@PathVariable(value = "num") Integer num){
        log.info("상세조회");
        return jpa.findById(num).get();
    }

    @ResponseBody
    @DeleteMapping("/board/{num}")
    public String deleteOne(@PathVariable(value = "num") String num){
        log.info("글 삭제 : {}", num);
        return mybatis.deleteBoard(num)>0?"success":"false";
    }

    @ResponseBody
    @PostMapping("/board/{writer}/{title}/{content}")
    public String insertBoard(BoardVO bvo){
        log.info("글작성");
        return mybatis.insertBoard(bvo)>0?"success":"false";
    }

    @ResponseBody
    @PutMapping("/board/{board_number}/{title}/{content}")
    public String updateBoard(BoardVO bvo){
        log.info("글 수정 : {}", bvo.getBoard_number());
        return mybatis.updateBoard(bvo)>0?"success":"false";
    }

}