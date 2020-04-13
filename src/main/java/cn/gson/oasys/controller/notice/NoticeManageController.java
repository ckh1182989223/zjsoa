package cn.gson.oasys.controller.notice;

import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.MapToList;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.model.dao.noticedao.NoticeDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.tidings.Notice;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.notice.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class NoticeManageController {
    @Autowired
    private NoticeDao noticeDao;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private UserDao userDao;
    /**
     * 添加/修改
     * @param req
     * @param notice
     * @return
     */
    @RequestMapping("noticecheck")
    public String testMess(HttpServletRequest req, Notice notice, BindingResult br) {
        Logger log = LoggerFactory.getLogger(getClass());
        HttpSession session = req.getSession();
        Long menuId=null;
        req.setAttribute("menuObj", notice);
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        User user = userDao.findOne(userId);//获取当前用户
        notice.setUserId(userId);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if(!ResultEnum.SUCCESS.getCode().equals(res.getCode())){
            List<Object> list = new MapToList<>().mapToList(res.getData());
            req.setAttribute("errormess", list.get(0).toString());
            // 代码调试阶段，下面是错误的相关信息；
            System.out.println("list错误的实体类信息：" + notice);
            System.out.println("list错误详情:" + list);
            System.out.println("list错误第一条:" + list.get(0));
            System.out.println("啊啊啊错误的信息——：" + list.get(0).toString());
            // 下面的info信息是打印出详细的信息
            log.info("getData:{}", res.getData());
            log.info("getCode:{}", res.getCode());
            log.info("getMsg:{}", res.getMsg());
        }else {
            if (!StringUtils.isEmpty(session.getAttribute("noticeId"))) {
                //修改
                menuId = (Long) session.getAttribute("noticeId"); // 获取进入编辑界面的menuID值
                System.out.println("id为"+menuId);
                Notice nc = noticeDao.findOne(menuId);
                notice.setCreateTime(nc.getCreateTime());
                notice.setCreateUser(nc.getCreateUser());
                notice.setNoticeId(menuId);
                notice.setUpdateTime(sdf.format(new Date()));
                notice.setUpdateUser(user.getUserName());
                session.removeAttribute("noticeId");
                noticeService.save(notice);
            } else {
                //添加
                String time=sdf.format(new Date());
                notice.setCreateTime(time);
                notice.setCreateUser(user.getUserName());
                notice.setUpdateTime(time);
                notice.setUpdateUser(user.getUserName());
                notice.setUserId(userId);
                noticeService.save(notice);
            }
            req.setAttribute("success", "后台验证成功");
        }
        System.out.println("是否进入最后的实体类信息：" + notice);
        return "forward:/noticeedit";
    }
    /**
     * 通知管理删除
     */
    @RequestMapping("noticedelete")
    public String infromDelete(HttpSession session, HttpServletRequest req) {
        Long noticeId = Long.parseLong(req.getParameter("id"));
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        Notice notice = noticeDao.findOne(noticeId);
        if (!Objects.equals(userId, notice.getUserId())) {
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        System.out.println(noticeId);
        noticeService.deleteOne(noticeId);
        return "redirect:/Informationsubmit";
    }

}
