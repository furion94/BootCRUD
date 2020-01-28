package lgr.boot.bootreact.ctrl;

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
public class controller {

    @Autowired
    private BoardDaoJPA jpa;
    @Autowired
    private IBoardService mybatis;

    @GetMapping("/")
    public String welcome(HttpServletRequest request){
        request.setAttribute("pName", "List");
        return "main";
    }

    @ResponseBody
    @GetMapping("/list")
    public List<BoardVO> listAll(HttpServletRequest request){
        System.out.println("전체조회");
        return jpa.findAll();
    }

    @ResponseBody
    @GetMapping("/select/{num}")
    public BoardVO selectOne(@PathVariable(value = "num") Integer num){
        System.out.println("상세조회");
        return jpa.findById(num).get();
    }

    @ResponseBody
    @GetMapping("/delete/{num}")
    public String deleteOne(@PathVariable(value = "num") String num){
        System.out.println("글삭제");
        Integer i = mybatis.deleteBoard(num);
        return i>0?"success":"false";
    }

    @ResponseBody
    @PostMapping("/insert/{writer}/{title}/{content}")
    public String insertBoard(BoardVO bvo){
        System.out.println("글작성");
        Integer i = mybatis.insertBoard(bvo);
        return i>0?"success":"false";
    }

    @ResponseBody
    @PostMapping("/update/{board_number}/{title}/{content}")
    public String updateBoard(BoardVO bvo){
        System.out.println("글수정");
        Integer i = mybatis.updateBoard(bvo);
        return i>0?"success":"false";
    }

}