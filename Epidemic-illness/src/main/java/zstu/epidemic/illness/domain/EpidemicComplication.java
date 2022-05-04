package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 并发症管理对象 epidemic_complication
 * 
 * @author iwan
 * @date 2022-05-04
 */
public class EpidemicComplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 传染病并发症关联id */
    private Long infectCompId;

    /** 传染病id */
    @Excel(name = "传染病id")
    private Long infectiousId;

    /** 并发症id */
    @Excel(name = "并发症id")
    private Long compId;

    public void setInfectCompId(Long infectCompId) 
    {
        this.infectCompId = infectCompId;
    }

    public Long getInfectCompId() 
    {
        return infectCompId;
    }
    public void setInfectiousId(Long infectiousId) 
    {
        this.infectiousId = infectiousId;
    }

    public Long getInfectiousId() 
    {
        return infectiousId;
    }
    public void setCompId(Long compId) 
    {
        this.compId = compId;
    }

    public Long getCompId() 
    {
        return compId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("infectCompId", getInfectCompId())
            .append("infectiousId", getInfectiousId())
            .append("compId", getCompId())
            .toString();
    }
}
