package cn.gson.oasys.services.notice;

import cn.gson.oasys.model.dao.noticedao.NoticeDao;
import cn.gson.oasys.model.entity.notice.NoticeUserRelation;
import cn.gson.oasys.model.entity.notice.NoticesList;
import cn.gson.oasys.model.entity.tidings.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    /**
     * 根据用户id查询通知（分页）
     * @param page
     * @param userId
     * @return
     */
    public Page<Notice> pageThis(int page, Long userId) {
        int size=10;
        Pageable pa = new PageRequest(page, size);
        return noticeDao.findByUserId(userId, pa);
    }

    /**
     * 封装
     * @param noticeList
     * @return
     */
    public List<Map<String, Object>> fengZhuang(List<Notice> noticeList) {
        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < noticeList.size(); i++) {
            Map<String, Object> result = new HashMap<>();
            result.put("noticeId",noticeList.get(i).getNoticeId());
            String typename="";
            if(noticeList.get(i).getTypeId()==1){
                typename="公众号";
            }
            if(noticeList.get(i).getTypeId()==2){
                typename="门户网站";
            }
            if(noticeList.get(i).getTypeId()==3){
                typename="社讯";
            }
            result.put("typeName",typename);
            result.put("title",noticeList.get(i).getTitle());
            result.put("creatTime",noticeList.get(i).getCreateTime());
            result.put("imageAuthor",noticeList.get(i).getImageAuthor());
            result.put("notes",noticeList.get(i).getNotes());
            result.put("contentAuthor",noticeList.get(i).getContentAuthor());
            list.add(result);
        }
        return list;

    }

    /**
     * 添加通知
     * @param notice
     * @return
     */
    public Notice save(Notice notice) {
        return noticeDao.save(notice);
    }

    /**
     * 删除通知
     * @param noticeId
     */
    public void deleteOne(Long noticeId) {
        Notice notice = noticeDao.findOne(noticeId);
        noticeDao.delete(noticeId);
        System.out.println("通知删除成功！");
    }
}
