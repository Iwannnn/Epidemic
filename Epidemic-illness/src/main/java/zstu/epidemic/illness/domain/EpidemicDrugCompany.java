package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 公司药品管理对象 epidemic_drug_company
 * 
 * @author iwan
 * @date 2022-05-04
 */
public class EpidemicDrugCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 药品公司关联id */
    private Long drugCompanyId;

    /** 公司id */
    @Excel(name = "公司id")
    private Long compId;

    /** 药物id */
    @Excel(name = "药物id")
    private Long medicineId;

    public void setDrugCompanyId(Long drugCompanyId) 
    {
        this.drugCompanyId = drugCompanyId;
    }

    public Long getDrugCompanyId() 
    {
        return drugCompanyId;
    }
    public void setCompId(Long compId) 
    {
        this.compId = compId;
    }

    public Long getCompId() 
    {
        return compId;
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
            .append("drugCompanyId", getDrugCompanyId())
            .append("compId", getCompId())
            .append("medicineId", getMedicineId())
            .toString();
    }
}
