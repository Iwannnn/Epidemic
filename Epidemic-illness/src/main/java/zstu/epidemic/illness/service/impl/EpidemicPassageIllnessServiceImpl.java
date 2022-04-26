package zstu.epidemic.illness.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicPassageIllnessMapper;
import zstu.epidemic.illness.domain.EpidemicPassageIllness;
import zstu.epidemic.illness.service.IEpidemicPassageIllnessService;

/**
 * 文章疾病Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicPassageIllnessServiceImpl implements IEpidemicPassageIllnessService 
{
    @Autowired
    private EpidemicPassageIllnessMapper epidemicPassageIllnessMapper;

    /**
     * 查询文章疾病
     * 
     * @param passageId 文章疾病主键
     * @return 文章疾病
     */
    @Override
    public EpidemicPassageIllness selectEpidemicPassageIllnessByPassageId(Long passageId)
    {
        return epidemicPassageIllnessMapper.selectEpidemicPassageIllnessByPassageId(passageId);
    }

    /**
     * 查询文章疾病列表
     * 
     * @param epidemicPassageIllness 文章疾病
     * @return 文章疾病
     */
    @Override
    public List<EpidemicPassageIllness> selectEpidemicPassageIllnessList(EpidemicPassageIllness epidemicPassageIllness)
    {
        return epidemicPassageIllnessMapper.selectEpidemicPassageIllnessList(epidemicPassageIllness);
    }

    /**
     * 新增文章疾病
     * 
     * @param epidemicPassageIllness 文章疾病
     * @return 结果
     */
    @Override
    public int insertEpidemicPassageIllness(EpidemicPassageIllness epidemicPassageIllness)
    {
        return epidemicPassageIllnessMapper.insertEpidemicPassageIllness(epidemicPassageIllness);
    }

    /**
     * 修改文章疾病
     * 
     * @param epidemicPassageIllness 文章疾病
     * @return 结果
     */
    @Override
    public int updateEpidemicPassageIllness(EpidemicPassageIllness epidemicPassageIllness)
    {
        return epidemicPassageIllnessMapper.updateEpidemicPassageIllness(epidemicPassageIllness);
    }

    /**
     * 批量删除文章疾病
     * 
     * @param passageIds 需要删除的文章疾病主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPassageIllnessByPassageIds(Long[] passageIds)
    {
        return epidemicPassageIllnessMapper.deleteEpidemicPassageIllnessByPassageIds(passageIds);
    }

    /**
     * 删除文章疾病信息
     * 
     * @param passageId 文章疾病主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPassageIllnessByPassageId(Long passageId)
    {
        return epidemicPassageIllnessMapper.deleteEpidemicPassageIllnessByPassageId(passageId);
    }
}
