package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 文章疾病对象 epidemic_passage_illness
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicPassageIllness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章id */
    @Excel(name = "文章id")
    private Long passageId;

    /** 疾病id */
    @Excel(name = "疾病id")
    private Long illnessId;

    public void setPassageId(Long passageId) 
    {
        this.passageId = passageId;
    }

    public Long getPassageId() 
    {
        return passageId;
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
            .append("passageId", getPassageId())
            .append("illnessId", getIllnessId())
            .toString();
    }
}
