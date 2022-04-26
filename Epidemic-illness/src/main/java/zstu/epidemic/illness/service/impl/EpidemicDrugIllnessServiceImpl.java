package zstu.epidemic.illness.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicDrugIllnessMapper;
import zstu.epidemic.illness.domain.EpidemicDrugIllness;
import zstu.epidemic.illness.service.IEpidemicDrugIllnessService;

/**
 * 疾病药品Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicDrugIllnessServiceImpl implements IEpidemicDrugIllnessService 
{
    @Autowired
    private EpidemicDrugIllnessMapper epidemicDrugIllnessMapper;

    /**
     * 查询疾病药品
     * 
     * @param drugId 疾病药品主键
     * @return 疾病药品
     */
    @Override
    public EpidemicDrugIllness selectEpidemicDrugIllnessByDrugId(Long drugId)
    {
        return epidemicDrugIllnessMapper.selectEpidemicDrugIllnessByDrugId(drugId);
    }

    /**
     * 查询疾病药品列表
     * 
     * @param epidemicDrugIllness 疾病药品
     * @return 疾病药品
     */
    @Override
    public List<EpidemicDrugIllness> selectEpidemicDrugIllnessList(EpidemicDrugIllness epidemicDrugIllness)
    {
        return epidemicDrugIllnessMapper.selectEpidemicDrugIllnessList(epidemicDrugIllness);
    }

    /**
     * 新增疾病药品
     * 
     * @param epidemicDrugIllness 疾病药品
     * @return 结果
     */
    @Override
    public int insertEpidemicDrugIllness(EpidemicDrugIllness epidemicDrugIllness)
    {
        return epidemicDrugIllnessMapper.insertEpidemicDrugIllness(epidemicDrugIllness);
    }

    /**
     * 修改疾病药品
     * 
     * @param epidemicDrugIllness 疾病药品
     * @return 结果
     */
    @Override
    public int updateEpidemicDrugIllness(EpidemicDrugIllness epidemicDrugIllness)
    {
        return epidemicDrugIllnessMapper.updateEpidemicDrugIllness(epidemicDrugIllness);
    }

    /**
     * 批量删除疾病药品
     * 
     * @param drugIds 需要删除的疾病药品主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicDrugIllnessByDrugIds(Long[] drugIds)
    {
        return epidemicDrugIllnessMapper.deleteEpidemicDrugIllnessByDrugIds(drugIds);
    }

    /**
     * 删除疾病药品信息
     * 
     * @param drugId 疾病药品主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicDrugIllnessByDrugId(Long drugId)
    {
        return epidemicDrugIllnessMapper.deleteEpidemicDrugIllnessByDrugId(drugId);
    }
}
