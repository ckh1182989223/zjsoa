package cn.gson.oasys.model.dao.noticedao;

import cn.gson.oasys.model.entity.tidings.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeDao extends JpaRepository<Notice,Long> {
    // 根据用户id来查找所有有关的通知
    Page<Notice> findByUserId(Long userId, Pageable pageable);
}
