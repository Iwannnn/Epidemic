package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 公司药品管理对象 epidemic_drug_company
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicDrugCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公司id */
    @Excel(name = "公司id")
    private Long companyId;

    /** 药品id */
    @Excel(name = "药品id")
    private Long drugId;

    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
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
            .append("companyId", getCompanyId())
            .append("drugId", getDrugId())
            .toString();
    }
}
