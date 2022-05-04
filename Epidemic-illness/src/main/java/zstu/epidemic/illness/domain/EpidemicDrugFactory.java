package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 工厂管理对象 epidemic_drug_factory
 * 
 * @author iwan
 * @date 2022-05-04
 */
public class EpidemicDrugFactory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 药品工厂id */
    private Long drugFactoryId;

    /** 工厂id */
    @Excel(name = "工厂id")
    private Long factId;

    /** 药物id */
    @Excel(name = "药物id")
    private Long medicineId;

    public void setDrugFactoryId(Long drugFactoryId) 
    {
        this.drugFactoryId = drugFactoryId;
    }

    public Long getDrugFactoryId() 
    {
        return drugFactoryId;
    }
    public void setFactId(Long factId) 
    {
        this.factId = factId;
    }

    public Long getFactId() 
    {
        return factId;
    }
    public void setMedicineId(Long medicineId) 
    {
        this.medicineId = medicineId;
    }

    public Long getMedicineId() 
    {
        return medicineId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("drugFactoryId", getDrugFactoryId())
            .append("factId", getFactId())
            .append("medicineId", getMedicineId())
            .toString();
    }
}
