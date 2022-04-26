package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicDrugCompany;

/**
 * 公司药品管理Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicDrugCompanyService 
{
    /**
     * 查询公司药品管理
     * 
     * @param companyId 公司药品管理主键
     * @return 公司药品管理
     */
    public EpidemicDrugCompany selectEpidemicDrugCompanyByCompanyId(Long companyId);

    /**
     * 查询公司药品管理列表
     * 
     * @param epidemicDrugCompany 公司药品管理
     * @return 公司药品管理集合
     */
    public List<EpidemicDrugCompany> selectEpidemicDrugCompanyList(EpidemicDrugCompany epidemicDrugCompany);

    /**
     * 新增公司药品管理
     * 
     * @param epidemicDrugCompany 公司药品管理
     * @return 结果
     */
    public int insertEpidemicDrugCompany(EpidemicDrugCompany epidemicDrugCompany);

    /**
     * 修改公司药品管理
     * 
     * @param epidemicDrugCompany 公司药品管理
     * @return 结果
     */
    public int updateEpidemicDrugCompany(EpidemicDrugCompany epidemicDrugCompany);

    /**
     * 批量删除公司药品管理
     * 
     * @param companyIds 需要删除的公司药品管理主键集合
     * @return 结果
     */
    public int deleteEpidemicDrugCompanyByCompanyIds(Long[] companyIds);

    /**
     * 删除公司药品管理信息
     * 
     * @param companyId 公司药品管理主键
     * @return 结果
     */
    public int deleteEpidemicDrugCompanyByCompanyId(Long companyId);
}
