package cn.gson.oasys.model.entity.tidings;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
@Entity()
@Table(name = "boa_notice")
public class Notice implements Serializable {
    /**
     * 通知id
     */
    @Id
    @Column(name = "notice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片作者
     */
    @Column(name = "image_author")
    private String imageAuthor;

    /**
     * 是否置顶
     */
    @Column(name = "is_top")
    private Boolean top=false;

    /**
     * 文章作者
     */

    @Column(name = "content_author")
    private String contentAuthor;

    /**
     * 类别
     */
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 状态id
     */
    @Column(name = "status_id")
    private Long statusId;

    /**
     * 备注
     */
    private String notes;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取通知id
     *
     * @return notice_id - 通知id
     */
    public Long getNoticeId() {
        return noticeId;
    }

    /**
     * 设置通知id
     *
     * @param noticeId 通知id
     */
    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取图片作者
     *
     * @return image_author - 图片作者
     */
    public String getImageAuthor() {
        return imageAuthor;
    }

    /**
     * 设置图片作者
     *
     * @param imageAuthor 图片作者
     */
    public void setImageAuthor(String imageAuthor) {
        this.imageAuthor = imageAuthor;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    /**
     * 获取文章作者
     *
     * @return content_author - 文章作者
     */
    public String getContentAuthor() {
        return contentAuthor;
    }

    /**
     * 设置文章作者
     *
     * @param contentAuthor 文章作者
     */
    public void setContentAuthor(String contentAuthor) {
        this.contentAuthor = contentAuthor;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取状态id
     *
     * @return status_id - 状态id
     */
    public Long getStatusId() {
        return statusId;
    }

    /**
     * 设置状态id
     *
     * @param statusId 状态id
     */
    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    /**
     * 获取备注
     *
     * @return notes - 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置备注
     *
     * @param notes 备注
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return create_user - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新人
     *
     * @return update_user - 更新人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新人
     *
     * @param updateUser 更新人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imageAuthor='" + imageAuthor + '\'' +
                ", top=" + top +
                ", contentAuthor='" + contentAuthor + '\'' +
                ", typeId=" + typeId +
                ", statusId=" + statusId +
                ", notes='" + notes + '\'' +
                ", createTime='" + createTime + '\'' +
                ", createUser='" + createUser + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", userId=" + userId +
                '}';
    }
}