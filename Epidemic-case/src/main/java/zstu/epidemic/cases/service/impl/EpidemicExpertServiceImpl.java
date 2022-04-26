package zstu.epidemic.cases.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.cases.mapper.EpidemicExpertMapper;
import zstu.epidemic.cases.domain.EpidemicExpert;
import zstu.epidemic.cases.service.IEpidemicExpertService;

/**
 * 专家管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicExpertServiceImpl implements IEpidemicExpertService 
{
    @Autowired
    private EpidemicExpertMapper epidemicExpertMapper;

    /**
     * 查询专家管理
     * 
     * @param expertId 专家管理主键
     * @return 专家管理
     */
    @Override
    public EpidemicExpert selectEpidemicExpertByExpertId(Long expertId)
    {
        return epidemicExpertMapper.selectEpidemicExpertByExpertId(expertId);
    }

    /**
     * 查询专家管理列表
     * 
     * @param epidemicExpert 专家管理
     * @return 专家管理
     */
    @Override
    public List<EpidemicExpert> selectEpidemicExpertList(EpidemicExpert epidemicExpert)
    {
        return epidemicExpertMapper.selectEpidemicExpertList(epidemicExpert);
    }

    /**
     * 新增专家管理
     * 
     * @param epidemicExpert 专家管理
     * @return 结果
     */
    @Override
    public int insertEpidemicExpert(EpidemicExpert epidemicExpert)
    {
        epidemicExpert.setCreateTime(DateUtils.getNowDate());
        return epidemicExpertMapper.insertEpidemicExpert(epidemicExpert);
    }

    /**
     * 修改专家管理
     * 
     * @param epidemicExpert 专家管理
     * @return 结果
     */
    @Override
    public int updateEpidemicExpert(EpidemicExpert epidemicExpert)
    {
        epidemicExpert.setUpdateTime(DateUtils.getNowDate());
        return epidemicExpertMapper.updateEpidemicExpert(epidemicExpert);
    }

    /**
     * 批量删除专家管理
     * 
     * @param expertIds 需要删除的专家管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicExpertByExpertIds(Long[] expertIds)
    {
        return epidemicExpertMapper.deleteEpidemicExpertByExpertIds(expertIds);
    }

    /**
     * 删除专家管理信息
     * 
     * @param expertId 专家管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicExpertByExpertId(Long expertId)
    {
        return epidemicExpertMapper.deleteEpidemicExpertByExpertId(expertId);
    }
}
