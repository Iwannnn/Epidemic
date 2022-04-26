package zstu.epidemic.illness.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zstu.epidemic.common.annotation.Excel;
import zstu.epidemic.common.core.domain.BaseEntity;

/**
 * 药品管理对象 epidemic_drug
 * 
 * @author iwan
 * @date 2022-04-26
 */
public class EpidemicDrug extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long drugId;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String drugName;

    /** 成分 */
    @Excel(name = "成分")
    private String ingredient;

    /** 药品特征 */
    @Excel(name = "药品特征")
    private String appearance;

    /** 规格 */
    @Excel(name = "规格")
    private String specification;

    /** 用法 */
    @Excel(name = "用法")
    private String usage;

    /** 禁忌 */
    @Excel(name = "禁忌")
    private String tabu;

    /** 不良反应 */
    @Excel(name = "不良反应")
    private String adverseReaction;

    /** 批准文号 */
    @Excel(name = "批准文号")
    private Long approvalNumber;

    /** 贮藏方法 */
    @Excel(name = "贮藏方法")
    private String storageMethod;

    /** 包装 */
    @Excel(name = "包装")
    private String packaging;

    /** 有效期 */
    @Excel(name = "有效期")
    private String indata;

    /** 工厂 */
    @Excel(name = "工厂")
    private Long factoryId;

    /** 公司 */
    @Excel(name = "公司")
    private Long companyId;

    /** 删除标志（0代表存在 1代表删除） */
    @Excel(name = "删除标志", readConverterExp = "0=代表存在,1=代表删除")
    private Long isDelete;

    public void setDrugId(Long drugId) 
    {
        this.drugId = drugId;
    }

    public Long getDrugId() 
    {
        return drugId;
    }
    public void setDrugName(String drugName) 
    {
        this.drugName = drugName;
    }

    public String getDrugName() 
    {
        return drugName;
    }
    public void setIngredient(String ingredient) 
    {
        this.ingredient = ingredient;
    }

    public String getIngredient() 
    {
        return ingredient;
    }
    public void setAppearance(String appearance) 
    {
        this.appearance = appearance;
    }

    public String getAppearance() 
    {
        return appearance;
    }
    public void setSpecification(String specification) 
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }
    public void setUsage(String usage) 
    {
        this.usage = usage;
    }

    public String getUsage() 
    {
        return usage;
    }
    public void setTabu(String tabu) 
    {
        this.tabu = tabu;
    }

    public String getTabu() 
    {
        return tabu;
    }
    public void setAdverseReaction(String adverseReaction) 
    {
        this.adverseReaction = adverseReaction;
    }

    public String getAdverseReaction() 
    {
        return adverseReaction;
    }
    public void setApprovalNumber(Long approvalNumber) 
    {
        this.approvalNumber = approvalNumber;
    }

    public Long getApprovalNumber() 
    {
        return approvalNumber;
    }
    public void setStorageMethod(String storageMethod) 
    {
        this.storageMethod = storageMethod;
    }

    public String getStorageMethod() 
    {
        return storageMethod;
    }
    public void setPackaging(String packaging) 
    {
        this.packaging = packaging;
    }

    public String getPackaging() 
    {
        return packaging;
    }
    public void setIndata(String indata) 
    {
        this.indata = indata;
    }

    public String getIndata() 
    {
        return indata;
    }
    public void setFactoryId(Long factoryId) 
    {
        this.factoryId = factoryId;
    }

    public Long getFactoryId() 
    {
        return factoryId;
    }
    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
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
            .append("drugId", getDrugId())
            .append("drugName", getDrugName())
            .append("ingredient", getIngredient())
            .append("appearance", getAppearance())
            .append("specification", getSpecification())
            .append("usage", getUsage())
            .append("tabu", getTabu())
            .append("adverseReaction", getAdverseReaction())
            .append("approvalNumber", getApprovalNumber())
            .append("storageMethod", getStorageMethod())
            .append("packaging", getPackaging())
            .append("indata", getIndata())
            .append("factoryId", getFactoryId())
            .append("companyId", getCompanyId())
            .append("isDelete", getIsDelete())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
