package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 文章管理对象 epidemic_passage
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicPassage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章id */
    @Excel(name = "文章id")
    private Long passageId;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 文章作者 */
    @Excel(name = "文章作者")
    private String author;

    /** 内容id */
    @Excel(name = "内容id")
    private Long contentId;

    /** 类别 */
    @Excel(name = "类别")
    private String type;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,1=代表删除")
    private Long isDelete;

    public void setPassageId(Long passageId) 
    {
        this.passageId = passageId;
    }

    public Long getPassageId() 
    {
        return passageId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }
    public void setContentId(Long contentId) 
    {
        this.contentId = contentId;
    }

    public Long getContentId() 
    {
        return contentId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("passageId", getPassageId())
            .append("title", getTitle())
            .append("author", getAuthor())
            .append("contentId", getContentId())
            .append("type", getType())
            .append("isDelete", getIsDelete())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
