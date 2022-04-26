package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 疾病药品对象 epidemic_drug_illness
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicDrugIllness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 药物id */
    @Excel(name = "药物id")
    private Long drugId;

    /** 疾病id */
    @Excel(name = "疾病id")
    private Long illnessId;

    public void setDrugId(Long drugId) 
    {
        this.drugId = drugId;
    }

    public Long getDrugId() 
    {
        return drugId;
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
            .append("drugId", getDrugId())
            .append("illnessId", getIllnessId())
            .toString();
    }
}
