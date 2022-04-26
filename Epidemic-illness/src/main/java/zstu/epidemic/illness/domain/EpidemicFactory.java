package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 工厂管理对象 epidemic_factory
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicFactory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工厂id */
    @Excel(name = "工厂id")
    private Long factoryId;

    /** 工厂名 */
    @Excel(name = "工厂名")
    private String factoryName;

    /** 工厂地址id */
    @Excel(name = "工厂地址id")
    private Long factoryRegionId;

    /** 工厂详细地址 */
    @Excel(name = "工厂详细地址")
    private String factoryAddress;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String postalCode;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNumber;

    /** 传真号码 */
    @Excel(name = "传真号码")
    private String faxNumber;

    /** 网址 */
    @Excel(name = "网址")
    private String siteUrl;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,1=代表删除")
    private Long isDelete;

    public void setFactoryId(Long factoryId) 
    {
        this.factoryId = factoryId;
    }

    public Long getFactoryId() 
    {
        return factoryId;
    }
    public void setFactoryName(String factoryName) 
    {
        this.factoryName = factoryName;
    }

    public String getFactoryName() 
    {
        return factoryName;
    }
    public void setFactoryRegionId(Long factoryRegionId) 
    {
        this.factoryRegionId = factoryRegionId;
    }

    public Long getFactoryRegionId() 
    {
        return factoryRegionId;
    }
    public void setFactoryAddress(String factoryAddress) 
    {
        this.factoryAddress = factoryAddress;
    }

    public String getFactoryAddress() 
    {
        return factoryAddress;
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
            .append("factoryId", getFactoryId())
            .append("factoryName", getFactoryName())
            .append("factoryRegionId", getFactoryRegionId())
            .append("factoryAddress", getFactoryAddress())
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
