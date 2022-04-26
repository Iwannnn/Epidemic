package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicCompany;

/**
 * 公司管理Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicCompanyService 
{
    /**
     * 查询公司管理
     * 
     * @param companyId 公司管理主键
     * @return 公司管理
     */
    public EpidemicCompany selectEpidemicCompanyByCompanyId(Long companyId);

    /**
     * 查询公司管理列表
     * 
     * @param epidemicCompany 公司管理
     * @return 公司管理集合
     */
    public List<EpidemicCompany> selectEpidemicCompanyList(EpidemicCompany epidemicCompany);

    /**
     * 新增公司管理
     * 
     * @param epidemicCompany 公司管理
     * @return 结果
     */
    public int insertEpidemicCompany(EpidemicCompany epidemicCompany);

    /**
     * 修改公司管理
     * 
     * @param epidemicCompany 公司管理
     * @return 结果
     */
    public int updateEpidemicCompany(EpidemicCompany epidemicCompany);

    /**
     * 批量删除公司管理
     * 
     * @param companyIds 需要删除的公司管理主键集合
     * @return 结果
     */
    public int deleteEpidemicCompanyByCompanyIds(Long[] companyIds);

    /**
     * 删除公司管理信息
     * 
     * @param companyId 公司管理主键
     * @return 结果
     */
    public int deleteEpidemicCompanyByCompanyId(Long companyId);
}
