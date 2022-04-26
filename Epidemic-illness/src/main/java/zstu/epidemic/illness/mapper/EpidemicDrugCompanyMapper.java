package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicDrugCompany;

/**
 * 公司药品管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicDrugCompanyMapper 
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
     * 删除公司药品管理
     * 
     * @param companyId 公司药品管理主键
     * @return 结果
     */
    public int deleteEpidemicDrugCompanyByCompanyId(Long companyId);

    /**
     * 批量删除公司药品管理
     * 
     * @param companyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicDrugCompanyByCompanyIds(Long[] companyIds);
}
