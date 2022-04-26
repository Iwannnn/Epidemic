package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 并发症管理对象 epidemic_complication
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicComplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 并发症id */
    @Excel(name = "并发症id")
    private Long complicationId;

    /** 传染病id（引发） */
    @Excel(name = "传染病id", readConverterExp = "引=发")
    private Long infectiousId;

    public void setComplicationId(Long complicationId) 
    {
        this.complicationId = complicationId;
    }

    public Long getComplicationId() 
    {
        return complicationId;
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
            .append("complicationId", getComplicationId())
            .append("infectiousId", getInfectiousId())
            .toString();
    }
}
