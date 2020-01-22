package lgr.boot.bootreact.ctrl;

import lgr.boot.bootreact.model.BoardDaoJPA;
import lgr.boot.bootreact.service.IBoardService;
import lgr.boot.bootreact.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
@Controller
public class controller {

    @Autowired
    private BoardDaoJPA jpa;
    @Autowired
    private IBoardService mybatis;

    @GetMapping("/")
    public String welcome(HttpServletRequest request){
        request.setAttribute("pName", "list");
        return "main";
    }

    @ResponseBody
    @GetMapping("/list")
    public Map<String, List<BoardVO>> testing(HttpServletRequest request){
        System.out.println("전체조회");
        List<BoardVO> list = jpa.findAll();
        Map<String, List<BoardVO>> map = new HashMap<String, List<BoardVO>>();
        map.put("boardList", list);
        return map;
    }

    @ResponseBody
    @GetMapping("/select")
    public Map<String, List<BoardVO>> selectOne(HttpServletRequest request){
        System.out.println("상세조회");
        Map<String, List<BoardVO>> map = new HashMap<String, List<BoardVO>>();
        List<BoardVO> lists = new ArrayList<>();
        lists.add(jpa.findById(Integer.parseInt(request.getParameter("num"))).get());
        map.put("boardList", lists);
        return map;
    }

    @ResponseBody
    @GetMapping("/delete")
    public String deleteOne(HttpServletRequest request){
        System.out.println("글삭제");
        Integer i = mybatis.deleteBoard(request.getParameter("num"));
        return i>0?"success":"false";
    }

    @ResponseBody
    @PostMapping("/insert")
    public String insertBoard(HttpServletRequest request, BoardVO bvo){
        System.out.println("글작성");
        Integer i = mybatis.insertBoard(bvo);
        return i>0?"success":"false";
    }

    @ResponseBody
    @PostMapping("/update")
    public String updateBoard(HttpServletRequest request, BoardVO bvo){
        System.out.println("글수정");
        Integer i = mybatis.updateBoard(bvo);
        System.out.println(bvo.toString());
        return i>0?"success":"false";
    }
}