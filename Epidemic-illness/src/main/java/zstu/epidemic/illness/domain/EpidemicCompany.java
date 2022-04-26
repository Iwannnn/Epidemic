package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 公司管理对象 epidemic_company
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公司id */
    private Long companyId;

    /** 公司名 */
    @Excel(name = "公司名")
    private String companyName;

    /** 公司详细地址 */
    @Excel(name = "公司详细地址")
    private String companyAddress;

    /** 公司地址id */
    @Excel(name = "公司地址id")
    private Long companyRegionId;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String postalCode;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNumber;

    /** 邮编号码 */
    @Excel(name = "邮编号码")
    private String faxNumber;

    /** 网址 */
    @Excel(name = "网址")
    private String siteUrl;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,1=代表删除")
    private Long isDelete;

    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCompanyAddress(String companyAddress) 
    {
        this.companyAddress = companyAddress;
    }

    public String getCompanyAddress() 
    {
        return companyAddress;
    }
    public void setCompanyRegionId(Long companyRegionId) 
    {
        this.companyRegionId = companyRegionId;
    }

    public Long getCompanyRegionId() 
    {
        return companyRegionId;
    }
    public void setPostalCode(String postalCode) 
    {
        this.postalCode = postalCode;
    }

    public String getPostalCode() 
    {
        return postalCode;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setFaxNumber(String faxNumber) 
    {
        this.faxNumber = faxNumber;
    }

    public String getFaxNumber() 
    {
        return faxNumber;
    }
    public void setSiteUrl(String siteUrl) 
    {
        this.siteUrl = siteUrl;
    }

    public String getSiteUrl() 
    {
        return siteUrl;
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
            .append("companyId", getCompanyId())
            .append("companyName", getCompanyName())
            .append("companyAddress", getCompanyAddress())
            .append("companyRegionId", getCompanyRegionId())
            .append("postalCode", getPostalCode())
            .append("phoneNumber", getPhoneNumber())
            .append("faxNumber", getFaxNumber())
            .append("siteUrl", getSiteUrl())
            .append("isDelete", getIsDelete())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
