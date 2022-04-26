package zstu.epidemic.cases.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 医院管理对象 epidemic_hospital
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicHospital extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 医院id */
    @Excel(name = "医院id")
    private Long hospitalId;

    /** 医院名称 */
    @Excel(name = "医院名称")
    private String hospitalName;

    /** 地区id */
    @Excel(name = "地区id")
    private Long establishRegionId;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String estabilshAddress;

    /** 是否公立（0是 1否） */
    @Excel(name = "是否公立", readConverterExp = "0=是,1=否")
    private Long isPublic;

    /** 院长 */
    @Excel(name = "院长")
    private String president;

    /** 医院等级 */
    @Excel(name = "医院等级")
    private String level;

    /** 医院类型 */
    @Excel(name = "医院类型")
    private String type;

    /** 建立时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "建立时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date establishTime;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,1=代表删除")
    private Long isDelete;

    public void setHospitalId(Long hospitalId) 
    {
        this.hospitalId = hospitalId;
    }

    public Long getHospitalId() 
    {
        return hospitalId;
    }
    public void setHospitalName(String hospitalName) 
    {
        this.hospitalName = hospitalName;
    }

    public String getHospitalName() 
    {
        return hospitalName;
    }
    public void setEstablishRegionId(Long establishRegionId) 
    {
        this.establishRegionId = establishRegionId;
    }

    public Long getEstablishRegionId() 
    {
        return establishRegionId;
    }
    public void setEstabilshAddress(String estabilshAddress) 
    {
        this.estabilshAddress = estabilshAddress;
    }

    public String getEstabilshAddress() 
    {
        return estabilshAddress;
    }
    public void setIsPublic(Long isPublic) 
    {
        this.isPublic = isPublic;
    }

    public Long getIsPublic() 
    {
        return isPublic;
    }
    public void setPresident(String president) 
    {
        this.president = president;
    }

    public String getPresident() 
    {
        return president;
    }
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setEstablishTime(Date establishTime) 
    {
        this.establishTime = establishTime;
    }

    public Date getEstablishTime() 
    {
        return establishTime;
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
            .append("hospitalId", getHospitalId())
            .append("hospitalName", getHospitalName())
            .append("establishRegionId", getEstablishRegionId())
            .append("estabilshAddress", getEstabilshAddress())
            .append("isPublic", getIsPublic())
            .append("president", getPresident())
            .append("level", getLevel())
            .append("type", getType())
            .append("establishTime", getEstablishTime())
            .append("isDelete", getIsDelete())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
