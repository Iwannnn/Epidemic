package zstu.epidemic.cases.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 病人管理对象 epidemic_patient
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicPatient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 病人id */
    @Excel(name = "病人id")
    private Long patientId;

    /** 名称 */
    @Excel(name = "名称")
    private String patientName;

    /** 病人性别 */
    @Excel(name = "病人性别")
    private String patientSex;

    /** 照片 */
    @Excel(name = "照片")
    private String avatar;

    /** 身高（cm 0为没数据） */
    @Excel(name = "身高", readConverterExp = "c=m,0=为没数据")
    private Long height;

    /** 体重（kg 0为没数据） */
    @Excel(name = "体重", readConverterExp = "k=g,0=为没数据")
    private Long weight;

    /** 体脂率（0为没数据） */
    @Excel(name = "体脂率", readConverterExp = "0=为没数据")
    private Long fat;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 住址地区id */
    @Excel(name = "住址地区id")
    private Long liveRegionId;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String liveAddress;

    /** 病人年龄 */
    @Excel(name = "病人年龄")
    private Long patientAge;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,1=代表删除")
    private Long isDelete;

    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }
    public void setPatientName(String patientName) 
    {
        this.patientName = patientName;
    }

    public String getPatientName() 
    {
        return patientName;
    }
    public void setPatientSex(String patientSex) 
    {
        this.patientSex = patientSex;
    }

    public String getPatientSex() 
    {
        return patientSex;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setHeight(Long height) 
    {
        this.height = height;
    }

    public Long getHeight() 
    {
        return height;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }
    public void setFat(Long fat) 
    {
        this.fat = fat;
    }

    public Long getFat() 
    {
        return fat;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setLiveRegionId(Long liveRegionId) 
    {
        this.liveRegionId = liveRegionId;
    }

    public Long getLiveRegionId() 
    {
        return liveRegionId;
    }
    public void setLiveAddress(String liveAddress) 
    {
        this.liveAddress = liveAddress;
    }

    public String getLiveAddress() 
    {
        return liveAddress;
    }
    public void setPatientAge(Long patientAge) 
    {
        this.patientAge = patientAge;
    }

    public Long getPatientAge() 
    {
        return patientAge;
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
            .append("patientId", getPatientId())
            .append("patientName", getPatientName())
            .append("patientSex", getPatientSex())
            .append("avatar", getAvatar())
            .append("height", getHeight())
            .append("weight", getWeight())
            .append("fat", getFat())
            .append("phone", getPhone())
            .append("liveRegionId", getLiveRegionId())
            .append("liveAddress", getLiveAddress())
            .append("patientAge", getPatientAge())
            .append("isDelete", getIsDelete())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
