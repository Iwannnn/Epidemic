package zstu.epidemic.illness.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicComplicationMapper;
import zstu.epidemic.illness.domain.EpidemicComplication;
import zstu.epidemic.illness.service.IEpidemicComplicationService;

/**
 * 并发症管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-05-04
 */
@Service
public class EpidemicComplicationServiceImpl implements IEpidemicComplicationService 
{
    @Autowired
    private EpidemicComplicationMapper epidemicComplicationMapper;

    /**
     * 查询并发症管理
     * 
     * @param infectCompId 并发症管理主键
     * @return 并发症管理
     */
    @Override
    public EpidemicComplication selectEpidemicComplicationByInfectCompId(Long infectCompId)
    {
        return epidemicComplicationMapper.selectEpidemicComplicationByInfectCompId(infectCompId);
    }

    /**
     * 查询并发症管理列表
     * 
     * @param epidemicComplication 并发症管理
     * @return 并发症管理
     */
    @Override
    public List<EpidemicComplication> selectEpidemicComplicationList(EpidemicComplication epidemicComplication)
    {
        return epidemicComplicationMapper.selectEpidemicComplicationList(epidemicComplication);
    }

    /**
     * 新增并发症管理
     * 
     * @param epidemicComplication 并发症管理
     * @return 结果
     */
    @Override
    public int insertEpidemicComplication(EpidemicComplication epidemicComplication)
    {
        return epidemicComplicationMapper.insertEpidemicComplication(epidemicComplication);
    }

    /**
     * 修改并发症管理
     * 
     * @param epidemicComplication 并发症管理
     * @return 结果
     */
    @Override
    public int updateEpidemicComplication(EpidemicComplication epidemicComplication)
    {
        return epidemicComplicationMapper.updateEpidemicComplication(epidemicComplication);
    }

    /**
     * 批量删除并发症管理
     * 
     * @param infectCompIds 需要删除的并发症管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicComplicationByInfectCompIds(Long[] infectCompIds)
    {
        return epidemicComplicationMapper.deleteEpidemicComplicationByInfectCompIds(infectCompIds);
    }

    /**
     * 删除并发症管理信息
     * 
     * @param infectCompId 并发症管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicComplicationByInfectCompId(Long infectCompId)
    {
        return epidemicComplicationMapper.deleteEpidemicComplicationByInfectCompId(infectCompId);
    }
}
