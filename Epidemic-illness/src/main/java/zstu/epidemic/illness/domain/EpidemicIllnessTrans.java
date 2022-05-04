package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 疾病传播方式对象 epidemic_illness_trans
 * 
 * @author iwan
 * @date 2022-05-04
 */
public class EpidemicIllnessTrans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 疾病传染方式id */
    private Long illnessTransId;

    /** 传播方式id */
    @Excel(name = "传播方式id")
    private Long tranId;

    /** 疾病id */
    @Excel(name = "疾病id")
    private Long infectId;

    public void setIllnessTransId(Long illnessTransId) 
    {
        this.illnessTransId = illnessTransId;
    }

    public Long getIllnessTransId() 
    {
        return illnessTransId;
    }
    public void setTranId(Long tranId) 
    {
        this.tranId = tranId;
    }

    public Long getTranId() 
    {
        return tranId;
    }
    public void setInfectId(Long infectId) 
    {
        this.infectId = infectId;
    }

    public Long getInfectId() 
    {
        return infectId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("illnessTransId", getIllnessTransId())
            .append("tranId", getTranId())
            .append("infectId", getInfectId())
            .toString();
    }
}
