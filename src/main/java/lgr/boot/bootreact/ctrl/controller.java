package lgr.boot.bootreact.ctrl;

import lgr.boot.bootreact.model.BoardDaoJPA;
import lgr.boot.bootreact.service.IBoardService;
import lgr.boot.bootreact.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class controller {

    @Autowired
    private BoardDaoJPA jpa;
    @Autowired
    private IBoardService mybatis;

    @GetMapping("/")
    public String testing(HttpServletRequest request){
        request.setAttribute("lists", jpa.findAll());
        request.setAttribute("pName", "list");
        return "main";
    }

    @GetMapping("/select")
    public String selectOne(HttpServletRequest request){
        request.setAttribute("lists", jpa.findById(Integer.parseInt(request.getParameter("num"))));
        request.setAttribute("pName", "select");
        return "main";
    }

    @GetMapping("/delete")
    public String deleteOne(HttpServletRequest request){
        mybatis.deleteBoard(request.getParameter("seq"));
        return "redirect:";
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