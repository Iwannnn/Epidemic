package zstu.epidemic.illness.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicDrugCompanyMapper;
import zstu.epidemic.illness.domain.EpidemicDrugCompany;
import zstu.epidemic.illness.service.IEpidemicDrugCompanyService;

/**
 * 公司药品管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-05-04
 */
@Service
public class EpidemicDrugCompanyServiceImpl implements IEpidemicDrugCompanyService 
{
    @Autowired
    private EpidemicDrugCompanyMapper epidemicDrugCompanyMapper;

    /**
     * 查询公司药品管理
     * 
     * @param drugCompanyId 公司药品管理主键
     * @return 公司药品管理
     */
    @Override
    public EpidemicDrugCompany selectEpidemicDrugCompanyByDrugCompanyId(Long drugCompanyId)
    {
        return epidemicDrugCompanyMapper.selectEpidemicDrugCompanyByDrugCompanyId(drugCompanyId);
    }

    /**
     * 查询公司药品管理列表
     * 
     * @param epidemicDrugCompany 公司药品管理
     * @return 公司药品管理
     */
    @Override
    public List<EpidemicDrugCompany> selectEpidemicDrugCompanyList(EpidemicDrugCompany epidemicDrugCompany)
    {
        return epidemicDrugCompanyMapper.selectEpidemicDrugCompanyList(epidemicDrugCompany);
    }

    /**
     * 新增公司药品管理
     * 
     * @param epidemicDrugCompany 公司药品管理
     * @return 结果
     */
    @Override
    public int insertEpidemicDrugCompany(EpidemicDrugCompany epidemicDrugCompany)
    {
        return epidemicDrugCompanyMapper.insertEpidemicDrugCompany(epidemicDrugCompany);
    }

    /**
     * 修改公司药品管理
     * 
     * @param epidemicDrugCompany 公司药品管理
     * @return 结果
     */
    @Override
    public int updateEpidemicDrugCompany(EpidemicDrugCompany epidemicDrugCompany)
    {
        return epidemicDrugCompanyMapper.updateEpidemicDrugCompany(epidemicDrugCompany);
    }

    /**
     * 批量删除公司药品管理
     * 
     * @param drugCompanyIds 需要删除的公司药品管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicDrugCompanyByDrugCompanyIds(Long[] drugCompanyIds)
    {
        return epidemicDrugCompanyMapper.deleteEpidemicDrugCompanyByDrugCompanyIds(drugCompanyIds);
    }

    /**
     * 删除公司药品管理信息
     * 
     * @param drugCompanyId 公司药品管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicDrugCompanyByDrugCompanyId(Long drugCompanyId)
    {
        return epidemicDrugCompanyMapper.deleteEpidemicDrugCompanyByDrugCompanyId(drugCompanyId);
    }
}
