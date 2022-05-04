package zstu.epidemic.illness.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicIllnessTransMapper;
import zstu.epidemic.illness.domain.EpidemicIllnessTrans;
import zstu.epidemic.illness.service.IEpidemicIllnessTransService;

/**
 * 疾病传播方式Service业务层处理
 * 
 * @author iwan
 * @date 2022-05-04
 */
@Service
public class EpidemicIllnessTransServiceImpl implements IEpidemicIllnessTransService 
{
    @Autowired
    private EpidemicIllnessTransMapper epidemicIllnessTransMapper;

    /**
     * 查询疾病传播方式
     * 
     * @param illnessTransId 疾病传播方式主键
     * @return 疾病传播方式
     */
    @Override
    public EpidemicIllnessTrans selectEpidemicIllnessTransByIllnessTransId(Long illnessTransId)
    {
        return epidemicIllnessTransMapper.selectEpidemicIllnessTransByIllnessTransId(illnessTransId);
    }

    /**
     * 查询疾病传播方式列表
     * 
     * @param epidemicIllnessTrans 疾病传播方式
     * @return 疾病传播方式
     */
    @Override
    public List<EpidemicIllnessTrans> selectEpidemicIllnessTransList(EpidemicIllnessTrans epidemicIllnessTrans)
    {
        return epidemicIllnessTransMapper.selectEpidemicIllnessTransList(epidemicIllnessTrans);
    }

    /**
     * 新增疾病传播方式
     * 
     * @param epidemicIllnessTrans 疾病传播方式
     * @return 结果
     */
    @Override
    public int insertEpidemicIllnessTrans(EpidemicIllnessTrans epidemicIllnessTrans)
    {
        return epidemicIllnessTransMapper.insertEpidemicIllnessTrans(epidemicIllnessTrans);
    }

    /**
     * 修改疾病传播方式
     * 
     * @param epidemicIllnessTrans 疾病传播方式
     * @return 结果
     */
    @Override
    public int updateEpidemicIllnessTrans(EpidemicIllnessTrans epidemicIllnessTrans)
    {
        return epidemicIllnessTransMapper.updateEpidemicIllnessTrans(epidemicIllnessTrans);
    }

    /**
     * 批量删除疾病传播方式
     * 
     * @param illnessTransIds 需要删除的疾病传播方式主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicIllnessTransByIllnessTransIds(Long[] illnessTransIds)
    {
        return epidemicIllnessTransMapper.deleteEpidemicIllnessTransByIllnessTransIds(illnessTransIds);
    }

    /**
     * 删除疾病传播方式信息
     * 
     * @param illnessTransId 疾病传播方式主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicIllnessTransByIllnessTransId(Long illnessTransId)
    {
        return epidemicIllnessTransMapper.deleteEpidemicIllnessTransByIllnessTransId(illnessTransId);
    }
}
