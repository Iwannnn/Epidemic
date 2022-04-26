package zstu.epidemic.cases.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 病例管理对象 epidemic_case
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicCase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 病例id */
    @Excel(name = "病例id")
    private Long caseId;

    /** 患者id */
    @Excel(name = "患者id")
    private Long patientId;

    /** 病id */
    @Excel(name = "病id")
    private Long illnessId;

    /** 感染地区id */
    @Excel(name = "感染地区id")
    private Long infectedRegionId;

    /** 感染详细地址 */
    @Excel(name = "感染详细地址")
    private String infectedAddress;

    /** 是否治愈（0否 1是） */
    @Excel(name = "是否治愈", readConverterExp = "0=否,1=是")
    private Long isCure;

    /** 是否住院（0否 1是） */
    @Excel(name = "是否住院", readConverterExp = "0=否,1=是")
    private Long isHosp;

    /** 是否死亡（0否 1是） */
    @Excel(name = "是否死亡", readConverterExp = "0=否,1=是")
    private Long isDie;

    /** 感染时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "感染时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date infectTime;

    /** 治愈时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "治愈时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cureTime;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,1=代表删除")
    private Integer isDelete;

    public void setCaseId(Long caseId) 
    {
        this.caseId = caseId;
    }

    public Long getCaseId() 
    {
        return caseId;
    }
    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }
    public void setIllnessId(Long illnessId) 
    {
        this.illnessId = illnessId;
    }

    public Long getIllnessId() 
    {
        return illnessId;
    }
    public void setInfectedRegionId(Long infectedRegionId) 
    {
        this.infectedRegionId = infectedRegionId;
    }

    public Long getInfectedRegionId() 
    {
        return infectedRegionId;
    }
    public void setInfectedAddress(String infectedAddress) 
    {
        this.infectedAddress = infectedAddress;
    }

    public String getInfectedAddress() 
    {
        return infectedAddress;
    }
    public void setIsCure(Long isCure) 
    {
        this.isCure = isCure;
    }

    public Long getIsCure() 
    {
        return isCure;
    }
    public void setIsHosp(Long isHosp) 
    {
        this.isHosp = isHosp;
    }

    public Long getIsHosp() 
    {
        return isHosp;
    }
    public void setIsDie(Long isDie) 
    {
        this.isDie = isDie;
    }

    public Long getIsDie() 
    {
        return isDie;
    }
    public void setInfectTime(Date infectTime) 
    {
        this.infectTime = infectTime;
    }

    public Date getInfectTime() 
    {
        return infectTime;
    }
    public void setCureTime(Date cureTime) 
    {
        this.cureTime = cureTime;
    }

    public Date getCureTime() 
    {
        return cureTime;
    }
    public void setIsDelete(Integer isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("caseId", getCaseId())
            .append("patientId", getPatientId())
            .append("illnessId", getIllnessId())
            .append("infectedRegionId", getInfectedRegionId())
            .append("infectedAddress", getInfectedAddress())
            .append("isCure", getIsCure())
            .append("isHosp", getIsHosp())
            .append("isDie", getIsDie())
            .append("infectTime", getInfectTime())
            .append("cureTime", getCureTime())
            .append("isDelete", getIsDelete())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
