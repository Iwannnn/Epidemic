package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 疾病药品对象 epidemic_drug_illness
 * 
 * @author iwan
 * @date 2022-05-04
 */
public class EpidemicDrugIllness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 药品疾病id */
    private Long drugIllnessId;

    /** 疾病id */
    @Excel(name = "疾病id")
    private Long diseaseId;

    /** 药物id */
    @Excel(name = "药物id")
    private Long drugId;

    public void setDrugIllnessId(Long drugIllnessId) 
    {
        this.drugIllnessId = drugIllnessId;
    }

    public Long getDrugIllnessId() 
    {
        return drugIllnessId;
    }
    public void setDiseaseId(Long diseaseId) 
    {
        this.diseaseId = diseaseId;
    }

    public Long getDiseaseId() 
    {
        return diseaseId;
    }
    public void setDrugId(Long drugId) 
    {
        this.drugId = drugId;
    }

    public Long getDrugId() 
    {
        return drugId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("drugIllnessId", getDrugIllnessId())
            .append("diseaseId", getDiseaseId())
            .append("drugId", getDrugId())
            .toString();
    }
}
