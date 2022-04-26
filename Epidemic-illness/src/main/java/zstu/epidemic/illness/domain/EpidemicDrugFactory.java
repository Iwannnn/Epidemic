package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 工厂管理对象 epidemic_drug_factory
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicDrugFactory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工厂id */
    @Excel(name = "工厂id")
    private Long factoryId;

    /** 药物id */
    @Excel(name = "药物id")
    private Long drugId;

    public void setFactoryId(Long factoryId) 
    {
        this.factoryId = factoryId;
    }

    public Long getFactoryId() 
    {
        return factoryId;
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
            .append("factoryId", getFactoryId())
            .append("drugId", getDrugId())
            .toString();
    }
}
