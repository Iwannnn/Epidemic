package zstu.epidemic.illness.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicCompanyMapper;
import zstu.epidemic.illness.domain.EpidemicCompany;
import zstu.epidemic.illness.service.IEpidemicCompanyService;

/**
 * 公司管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicCompanyServiceImpl implements IEpidemicCompanyService 
{
    @Autowired
    private EpidemicCompanyMapper epidemicCompanyMapper;

    /**
     * 查询公司管理
     * 
     * @param companyId 公司管理主键
     * @return 公司管理
     */
    @Override
    public EpidemicCompany selectEpidemicCompanyByCompanyId(Long companyId)
    {
        return epidemicCompanyMapper.selectEpidemicCompanyByCompanyId(companyId);
    }

    /**
     * 查询公司管理列表
     * 
     * @param epidemicCompany 公司管理
     * @return 公司管理
     */
    @Override
    public List<EpidemicCompany> selectEpidemicCompanyList(EpidemicCompany epidemicCompany)
    {
        return epidemicCompanyMapper.selectEpidemicCompanyList(epidemicCompany);
    }

    /**
     * 新增公司管理
     * 
     * @param epidemicCompany 公司管理
     * @return 结果
     */
    @Override
    public int insertEpidemicCompany(EpidemicCompany epidemicCompany)
    {
        epidemicCompany.setCreateTime(DateUtils.getNowDate());
        return epidemicCompanyMapper.insertEpidemicCompany(epidemicCompany);
    }

    /**
     * 修改公司管理
     * 
     * @param epidemicCompany 公司管理
     * @return 结果
     */
    @Override
    public int updateEpidemicCompany(EpidemicCompany epidemicCompany)
    {
        epidemicCompany.setUpdateTime(DateUtils.getNowDate());
        return epidemicCompanyMapper.updateEpidemicCompany(epidemicCompany);
    }

    /**
     * 批量删除公司管理
     * 
     * @param companyIds 需要删除的公司管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicCompanyByCompanyIds(Long[] companyIds)
    {
        return epidemicCompanyMapper.deleteEpidemicCompanyByCompanyIds(companyIds);
    }

    /**
     * 删除公司管理信息
     * 
     * @param companyId 公司管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicCompanyByCompanyId(Long companyId)
    {
        return epidemicCompanyMapper.deleteEpidemicCompanyByCompanyId(companyId);
    }
}
