package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicCompany;

/**
 * 公司管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicCompanyMapper 
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
     * 删除公司管理
     * 
     * @param companyId 公司管理主键
     * @return 结果
     */
    public int deleteEpidemicCompanyByCompanyId(Long companyId);

    /**
     * 批量删除公司管理
     * 
     * @param companyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicCompanyByCompanyIds(Long[] companyIds);
}
