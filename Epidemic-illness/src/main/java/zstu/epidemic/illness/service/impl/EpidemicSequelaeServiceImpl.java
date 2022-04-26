package zstu.epidemic.illness.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicSequelaeMapper;
import zstu.epidemic.illness.domain.EpidemicSequelae;
import zstu.epidemic.illness.service.IEpidemicSequelaeService;

/**
 * 后遗症Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicSequelaeServiceImpl implements IEpidemicSequelaeService 
{
    @Autowired
    private EpidemicSequelaeMapper epidemicSequelaeMapper;

    /**
     * 查询后遗症
     * 
     * @param sequelaeId 后遗症主键
     * @return 后遗症
     */
    @Override
    public EpidemicSequelae selectEpidemicSequelaeBySequelaeId(Long sequelaeId)
    {
        return epidemicSequelaeMapper.selectEpidemicSequelaeBySequelaeId(sequelaeId);
    }

    /**
     * 查询后遗症列表
     * 
     * @param epidemicSequelae 后遗症
     * @return 后遗症
     */
    @Override
    public List<EpidemicSequelae> selectEpidemicSequelaeList(EpidemicSequelae epidemicSequelae)
    {
        return epidemicSequelaeMapper.selectEpidemicSequelaeList(epidemicSequelae);
    }

    /**
     * 新增后遗症
     * 
     * @param epidemicSequelae 后遗症
     * @return 结果
     */
    @Override
    public int insertEpidemicSequelae(EpidemicSequelae epidemicSequelae)
    {
        return epidemicSequelaeMapper.insertEpidemicSequelae(epidemicSequelae);
    }

    /**
     * 修改后遗症
     * 
     * @param epidemicSequelae 后遗症
     * @return 结果
     */
    @Override
    public int updateEpidemicSequelae(EpidemicSequelae epidemicSequelae)
    {
        return epidemicSequelaeMapper.updateEpidemicSequelae(epidemicSequelae);
    }

    /**
     * 批量删除后遗症
     * 
     * @param sequelaeIds 需要删除的后遗症主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicSequelaeBySequelaeIds(Long[] sequelaeIds)
    {
        return epidemicSequelaeMapper.deleteEpidemicSequelaeBySequelaeIds(sequelaeIds);
    }

    /**
     * 删除后遗症信息
     * 
     * @param sequelaeId 后遗症主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicSequelaeBySequelaeId(Long sequelaeId)
    {
        return epidemicSequelaeMapper.deleteEpidemicSequelaeBySequelaeId(sequelaeId);
    }
}
