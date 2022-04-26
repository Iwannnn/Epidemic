package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 病史管理对象 epidemic_patient_history
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicPatientHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 病人id */
    @Excel(name = "病人id")
    private Long patientId;

    /** 病id（病史未登记） */
    @Excel(name = "病id", readConverterExp = "病=史未登记")
    private Long illnessId;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("patientId", getPatientId())
            .append("illnessId", getIllnessId())
            .toString();
    }
}
