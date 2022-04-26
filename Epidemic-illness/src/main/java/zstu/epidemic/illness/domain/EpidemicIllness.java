package zstu.epidemic.illness.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 疾病管理对象 epidemic_illness
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicIllness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 病id */
    @Excel(name = "病id")
    private Long illnessId;

    /** 病名 */
    @Excel(name = "病名")
    private String illnessName;

    /** 所属类id */
    @Excel(name = "所属类id")
    private Long catrgoryId;

    /** 症状描述 */
    @Excel(name = "症状描述")
    private String symptom;

    /** 病原描述 */
    @Excel(name = "病原描述")
    private String pathogeny;

    /** 严重性描述 */
    @Excel(name = "严重性描述")
    private String ponderance;

    /** 是否传染（0否 1是） */
    @Excel(name = "是否传染", readConverterExp = "0=否,1=是")
    private Long isFectious;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,1=代表删除")
    private Long isDeleted;

    /** 创建者 */
    @Excel(name = "创建者")
    private String craetedBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    public void setIllnessId(Long illnessId) 
    {
        this.illnessId = illnessId;
    }

    public Long getIllnessId() 
    {
        return illnessId;
    }
    public void setIllnessName(String illnessName) 
    {
        this.illnessName = illnessName;
    }

    public String getIllnessName() 
    {
        return illnessName;
    }
    public void setCatrgoryId(Long catrgoryId) 
    {
        this.catrgoryId = catrgoryId;
    }

    public Long getCatrgoryId() 
    {
        return catrgoryId;
    }
    public void setSymptom(String symptom) 
    {
        this.symptom = symptom;
    }

    public String getSymptom() 
    {
        return symptom;
    }
    public void setPathogeny(String pathogeny) 
    {
        this.pathogeny = pathogeny;
    }

    public String getPathogeny() 
    {
        return pathogeny;
    }
    public void setPonderance(String ponderance) 
    {
        this.ponderance = ponderance;
    }

    public String getPonderance() 
    {
        return ponderance;
    }
    public void setIsFectious(Long isFectious) 
    {
        this.isFectious = isFectious;
    }

    public Long getIsFectious() 
    {
        return isFectious;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }
    public void setCraetedBy(String craetedBy) 
    {
        this.craetedBy = craetedBy;
    }

    public String getCraetedBy() 
    {
        return craetedBy;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("illnessId", getIllnessId())
            .append("illnessName", getIllnessName())
            .append("catrgoryId", getCatrgoryId())
            .append("symptom", getSymptom())
            .append("pathogeny", getPathogeny())
            .append("ponderance", getPonderance())
            .append("isFectious", getIsFectious())
            .append("isDeleted", getIsDeleted())
            .append("craetedBy", getCraetedBy())
            .append("createdTime", getCreatedTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
