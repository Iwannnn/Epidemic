package zstu.epidemic.illness.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicIllnessMapper;
import zstu.epidemic.illness.domain.EpidemicIllness;
import zstu.epidemic.illness.service.IEpidemicIllnessService;

/**
 * 疾病管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicIllnessServiceImpl implements IEpidemicIllnessService 
{
    @Autowired
    private EpidemicIllnessMapper epidemicIllnessMapper;

    /**
     * 查询疾病管理
     * 
     * @param illnessId 疾病管理主键
     * @return 疾病管理
     */
    @Override
    public EpidemicIllness selectEpidemicIllnessByIllnessId(Long illnessId)
    {
        return epidemicIllnessMapper.selectEpidemicIllnessByIllnessId(illnessId);
    }

    /**
     * 查询疾病管理列表
     * 
     * @param epidemicIllness 疾病管理
     * @return 疾病管理
     */
    @Override
    public List<EpidemicIllness> selectEpidemicIllnessList(EpidemicIllness epidemicIllness)
    {
        return epidemicIllnessMapper.selectEpidemicIllnessList(epidemicIllness);
    }

    /**
     * 新增疾病管理
     * 
     * @param epidemicIllness 疾病管理
     * @return 结果
     */
    @Override
    public int insertEpidemicIllness(EpidemicIllness epidemicIllness)
    {
        return epidemicIllnessMapper.insertEpidemicIllness(epidemicIllness);
    }

    /**
     * 修改疾病管理
     * 
     * @param epidemicIllness 疾病管理
     * @return 结果
     */
    @Override
    public int updateEpidemicIllness(EpidemicIllness epidemicIllness)
    {
        epidemicIllness.setUpdateTime(DateUtils.getNowDate());
        return epidemicIllnessMapper.updateEpidemicIllness(epidemicIllness);
    }

    /**
     * 批量删除疾病管理
     * 
     * @param illnessIds 需要删除的疾病管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicIllnessByIllnessIds(Long[] illnessIds)
    {
        return epidemicIllnessMapper.deleteEpidemicIllnessByIllnessIds(illnessIds);
    }

    /**
     * 删除疾病管理信息
     * 
     * @param illnessId 疾病管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicIllnessByIllnessId(Long illnessId)
    {
        return epidemicIllnessMapper.deleteEpidemicIllnessByIllnessId(illnessId);
    }
}
