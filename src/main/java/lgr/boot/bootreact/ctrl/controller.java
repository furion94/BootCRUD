package lgr.boot.bootreact.ctrl;

import lgr.boot.bootreact.model.BoardDaoJPA;
import lgr.boot.bootreact.service.IBoardService;
import lgr.boot.bootreact.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        System.out.println("하이");
        List<BoardVO> list = jpa.findAll();
        Map<String, List<BoardVO>> map = new HashMap<String, List<BoardVO>>();
        map.put("boardList", list);
        return map;
    }

    @ResponseBody
    @GetMapping("/select")
    public String selectOne(HttpServletRequest request){
        Map<String, Optional<BoardVO>> map = new HashMap<String, Optional<BoardVO>>();
        map.put("boardList", jpa.findById(Integer.parseInt(request.getParameter("num"))));
        System.out.println(map.toString());
        return map.toString();
    }

    @ResponseBody
    @GetMapping("/delete")
    public String deleteOne(HttpServletRequest request){
        System.out.println("delete");
        Integer i = mybatis.deleteBoard(request.getParameter("num"));
        return i>0?"success":"false";
    }

    @GetMapping("/insert")
    public String insertBoard(HttpServletRequest request, BoardVO bvo){
        mybatis.insertBoard(bvo);
        return "redirect:";
    }

    @GetMapping("/update")
    public String updateBoard(HttpServletRequest request, BoardVO bvo){
        mybatis.updateBoard(bvo);
        request.setAttribute("seq", bvo.getBoard_number());
        request.setAttribute("pName", "select");
        return "main";
    }
}