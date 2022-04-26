package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 后遗症对象 epidemic_sequelae
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicSequelae extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 后遗症id */
    @Excel(name = "后遗症id")
    private Long sequelaeId;

    /** 传染病id（引发） */
    @Excel(name = "传染病id", readConverterExp = "引=发")
    private Long infectiousId;

    public void setSequelaeId(Long sequelaeId) 
    {
        this.sequelaeId = sequelaeId;
    }

    public Long getSequelaeId() 
    {
        return sequelaeId;
    }
    public void setInfectiousId(Long infectiousId) 
    {
        this.infectiousId = infectiousId;
    }

    public Long getInfectiousId() 
    {
        return infectiousId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sequelaeId", getSequelaeId())
            .append("infectiousId", getInfectiousId())
            .toString();
    }
}
