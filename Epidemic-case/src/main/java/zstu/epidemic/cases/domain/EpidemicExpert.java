package zstu.epidemic.cases.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 专家管理对象 epidemic_expert
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicExpert extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专家id */
    @Excel(name = "专家id")
    private Long expertId;

    /** 专家姓名 */
    @Excel(name = "专家姓名")
    private String expertName;

    /** 专家性别 */
    @Excel(name = "专家性别")
    private String expertSex;

    /** 专家年龄 */
    @Excel(name = "专家年龄")
    private Long expertAge;

    /** 专家介绍 */
    @Excel(name = "专家介绍")
    private String introduction;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idNumber;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String outlook;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 手机号 */
    @Excel(name = "手机号")
    private String telephone;

    /** 邮箱号 */
    @Excel(name = "邮箱号")
    private String email;

    /** 隶属医院id */
    @Excel(name = "隶属医院id")
    private Long hospitalId;

    /** 地址 */
    @Excel(name = "地址")
    private Long liveRegionId;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,1=代表删除")
    private Long isDelete;

    public void setExpertId(Long expertId) 
    {
        this.expertId = expertId;
    }

    public Long getExpertId() 
    {
        return expertId;
    }
    public void setExpertName(String expertName) 
    {
        this.expertName = expertName;
    }

    public String getExpertName() 
    {
        return expertName;
    }
    public void setExpertSex(String expertSex) 
    {
        this.expertSex = expertSex;
    }

    public String getExpertSex() 
    {
        return expertSex;
    }
    public void setExpertAge(Long expertAge) 
    {
        this.expertAge = expertAge;
    }

    public Long getExpertAge() 
    {
        return expertAge;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }
    public void setIdNumber(String idNumber) 
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber() 
    {
        return idNumber;
    }
    public void setOutlook(String outlook) 
    {
        this.outlook = outlook;
    }

    public String getOutlook() 
    {
        return outlook;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setHospitalId(Long hospitalId) 
    {
        this.hospitalId = hospitalId;
    }

    public Long getHospitalId() 
    {
        return hospitalId;
    }
    public void setLiveRegionId(Long liveRegionId) 
    {
        this.liveRegionId = liveRegionId;
    }

    public Long getLiveRegionId() 
    {
        return liveRegionId;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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
            .append("expertId", getExpertId())
            .append("expertName", getExpertName())
            .append("expertSex", getExpertSex())
            .append("expertAge", getExpertAge())
            .append("introduction", getIntroduction())
            .append("idNumber", getIdNumber())
            .append("outlook", getOutlook())
            .append("education", getEducation())
            .append("telephone", getTelephone())
            .append("email", getEmail())
            .append("hospitalId", getHospitalId())
            .append("liveRegionId", getLiveRegionId())
            .append("address", getAddress())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
