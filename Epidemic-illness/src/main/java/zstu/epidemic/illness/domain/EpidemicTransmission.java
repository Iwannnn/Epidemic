package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 传播管理对象 epidemic_transmission
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicTransmission extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 传播途径id */
    @Excel(name = "传播途径id")
    private Long transmissionId;

    /** 传播途径名 */
    @Excel(name = "传播途径名")
    private String transmissionName;

    /** 影响范围 */
    @Excel(name = "影响范围")
    private String distance;

    /** 持续时间 */
    @Excel(name = "持续时间")
    private String duration;

    /** 传播源 */
    @Excel(name = "传播源")
    private String transSource;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,1=代表删除")
    private Long isDelete;

    public void setTransmissionId(Long transmissionId) 
    {
        this.transmissionId = transmissionId;
    }

    public Long getTransmissionId() 
    {
        return transmissionId;
    }
    public void setTransmissionName(String transmissionName) 
    {
        this.transmissionName = transmissionName;
    }

    public String getTransmissionName() 
    {
        return transmissionName;
    }
    public void setDistance(String distance) 
    {
        this.distance = distance;
    }

    public String getDistance() 
    {
        return distance;
    }
    public void setDuration(String duration) 
    {
        this.duration = duration;
    }

    public String getDuration() 
    {
        return duration;
    }
    public void setTransSource(String transSource) 
    {
        this.transSource = transSource;
    }

    public String getTransSource() 
    {
        return transSource;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("transmissionId", getTransmissionId())
            .append("transmissionName", getTransmissionName())
            .append("distance", getDistance())
            .append("duration", getDuration())
            .append("transSource", getTransSource())
            .append("isDelete", getIsDelete())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
