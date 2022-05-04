package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 文章疾病对象 epidemic_passage_illness
 * 
 * @author iwan
 * @date 2022-05-04
 */
public class EpidemicPassageIllness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章疾病id */
    private Long passageIllnessId;

    /** 文章id */
    @Excel(name = "文章id")
    private Long passId;

    /** 疾病id */
    @Excel(name = "疾病id")
    private Long infectId;

    public void setPassageIllnessId(Long passageIllnessId) 
    {
        this.passageIllnessId = passageIllnessId;
    }

    public Long getPassageIllnessId() 
    {
        return passageIllnessId;
    }
    public void setPassId(Long passId) 
    {
        this.passId = passId;
    }

    public Long getPassId() 
    {
        return passId;
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
            .append("passageIllnessId", getPassageIllnessId())
            .append("passId", getPassId())
            .append("infectId", getInfectId())
            .toString();
    }
}
