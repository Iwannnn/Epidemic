package zstu.epidemic.cases.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 病例医院管理对象 epidemic_case_hospital
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicCaseHospital extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 病例医院id */
    @Excel(name = "病例医院id")
    private Long caseHospitalId;

    /** 病例id */
    @Excel(name = "病例id")
    private Long caseId;

    /** 医院id */
    @Excel(name = "医院id")
    private Long hospitalId;

    /** 看病次数 */
    @Excel(name = "看病次数")
    private Long visitTime;

    /** 第几个去的医院 */
    @Excel(name = "第几个去的医院")
    private Long number;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,1=代表删除")
    private Long isDelete;

    public void setCaseHospitalId(Long caseHospitalId) 
    {
        this.caseHospitalId = caseHospitalId;
    }

    public Long getCaseHospitalId() 
    {
        return caseHospitalId;
    }
    public void setCaseId(Long caseId) 
    {
        this.caseId = caseId;
    }

    public Long getCaseId() 
    {
        return caseId;
    }
    public void setHospitalId(Long hospitalId) 
    {
        this.hospitalId = hospitalId;
    }

    public Long getHospitalId() 
    {
        return hospitalId;
    }
    public void setVisitTime(Long visitTime) 
    {
        this.visitTime = visitTime;
    }

    public Long getVisitTime() 
    {
        return visitTime;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
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
            .append("caseHospitalId", getCaseHospitalId())
            .append("caseId", getCaseId())
            .append("hospitalId", getHospitalId())
            .append("visitTime", getVisitTime())
            .append("number", getNumber())
            .append("isDelete", getIsDelete())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
