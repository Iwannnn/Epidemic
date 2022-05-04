package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 后遗症对象 epidemic_sequelae
 * 
 * @author iwan
 * @date 2022-05-04
 */
public class EpidemicSequelae extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 疾病后遗症id */
    private Long illnessSeqId;

    /** 后遗症id */
    @Excel(name = "后遗症id")
    private Long seqId;

    /** 传染病id（引发） */
    @Excel(name = "传染病id", readConverterExp = "引=发")
    private Long infectId;

    public void setIllnessSeqId(Long illnessSeqId) 
    {
        this.illnessSeqId = illnessSeqId;
    }

    public Long getIllnessSeqId() 
    {
        return illnessSeqId;
    }
    public void setSeqId(Long seqId) 
    {
        this.seqId = seqId;
    }

    public Long getSeqId() 
    {
        return seqId;
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
            .append("illnessSeqId", getIllnessSeqId())
            .append("seqId", getSeqId())
            .append("infectId", getInfectId())
            .toString();
    }
}
