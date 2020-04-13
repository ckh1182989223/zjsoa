package cn.gson.oasys.controller.notice;
import cn.gson.oasys.model.dao.noticedao.NoticeDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.tidings.Notice;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class NoticeController {
   @Autowired
   private NoticeService noticeService;
   @Autowired
   private NoticeDao noticeDao;
   @Autowired
    private UserDao userDao;

    /**
     * 信息报送面板
     * @param page
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("Informationsubmit")
    public String inform(@RequestParam(value = "page", defaultValue = "0") int page, @SessionAttribute("userId") Long userId, Model model) {
        Page<Notice> page2 = noticeService.pageThis(page,userId);
        List<Notice> noticeList=page2.getContent();
        List<Map<String, Object>> list=noticeService.fengZhuang(noticeList);
        model.addAttribute("list", list);
        model.addAttribute("page", page2);

        return "notice/noticemanage";
    }

    /**
     * 编辑通知面板
     * @param req
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("noticeedit")
    public String infromEdit(HttpServletRequest req, HttpSession session, Model model) {
        session.removeAttribute("noticeId");

        if (!StringUtils.isEmpty(req.getAttribute("errormess"))) {
            req.setAttribute("errormess", req.getAttribute("errormess"));
        }
        if (!StringUtils.isEmpty(req.getAttribute("success"))) {
            req.setAttribute("success", "数据保存成功");
        }
        ArrayList typeList = new ArrayList<String>();
        typeList.add("公众号");
        typeList.add("门户网站");
        typeList.add("社讯");
        req.setAttribute("typeList",typeList);
        if (!StringUtils.isEmpty(req.getParameter("id"))) {
            Long noticeId = Long.parseLong(req.getParameter("id"));
            Notice notice = noticeDao.findOne(noticeId);
            model.addAttribute("notice", notice);
            String typeName="";
            if(notice!=null&&notice.getTypeId()==1){
                typeName="公众号";
            }else if (notice.getTypeId()==2){
                typeName="门户网站";
            }else if(notice.getTypeId()==3){
                typeName="社讯";
            }

            model.addAttribute("typeName",typeName);
            session.setAttribute("noticeId", noticeId);
        }
        return "notice/noticeedit";
    }

    /**
     * 通知详细显示
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("noticeshow")
    public String informShow(HttpServletRequest req, Model model) {
        Long noticeId = Long.parseLong(req.getParameter("id"));
        Notice notice = noticeDao.findOne(noticeId);
        User user = userDao.findOne(notice.getUserId());
        model.addAttribute("notice", notice);
        model.addAttribute("userName", user.getUserName());
        return "notice/noticeshow";
    }
}
