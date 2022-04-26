package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 疾病传播方式对象 epidemic_illness_trans
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicIllnessTrans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 传播方式id */
    @Excel(name = "传播方式id")
    private Long transId;

    /** 疾病id */
    @Excel(name = "疾病id")
    private Long illnessId;

    public void setTransId(Long transId) 
    {
        this.transId = transId;
    }

    public Long getTransId() 
    {
        return transId;
    }
    public void setIllnessId(Long illnessId) 
    {
        this.illnessId = illnessId;
    }

    public Long getIllnessId() 
    {
        return illnessId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("transId", getTransId())
            .append("illnessId", getIllnessId())
            .toString();
    }
}
