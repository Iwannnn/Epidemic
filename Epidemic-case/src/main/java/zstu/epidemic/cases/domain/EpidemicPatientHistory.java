package zstu.epidemic.cases.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 病史管理对象 epidemic_patient_history
 * 
 * @author iwan
 * @date 2022-05-04
 */
public class EpidemicPatientHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 病史id */
    private Long patientHistoryId;

    /** 病人id */
    @Excel(name = "病人id")
    private Long patId;

    /** 病id（病史未登记） */
    @Excel(name = "病id", readConverterExp = "病=史未登记")
    private Long diseaseId;

    public void setPatientHistoryId(Long patientHistoryId) 
    {
        this.patientHistoryId = patientHistoryId;
    }

    public Long getPatientHistoryId() 
    {
        return patientHistoryId;
    }
    public void setPatId(Long patId) 
    {
        this.patId = patId;
    }

    public Long getPatId() 
    {
        return patId;
    }
    public void setDiseaseId(Long diseaseId) 
    {
        this.diseaseId = diseaseId;
    }

    public Long getDiseaseId() 
    {
        return diseaseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("patientHistoryId", getPatientHistoryId())
            .append("patId", getPatId())
            .append("diseaseId", getDiseaseId())
            .toString();
    }
}
