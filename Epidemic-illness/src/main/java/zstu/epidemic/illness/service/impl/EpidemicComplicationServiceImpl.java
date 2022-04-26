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
 * @date 2022-04-26
 */
@Service
public class EpidemicComplicationServiceImpl implements IEpidemicComplicationService 
{
    @Autowired
    private EpidemicComplicationMapper epidemicComplicationMapper;

    /**
     * 查询并发症管理
     * 
     * @param complicationId 并发症管理主键
     * @return 并发症管理
     */
    @Override
    public EpidemicComplication selectEpidemicComplicationByComplicationId(Long complicationId)
    {
        return epidemicComplicationMapper.selectEpidemicComplicationByComplicationId(complicationId);
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
     * @param complicationIds 需要删除的并发症管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicComplicationByComplicationIds(Long[] complicationIds)
    {
        return epidemicComplicationMapper.deleteEpidemicComplicationByComplicationIds(complicationIds);
    }

    /**
     * 删除并发症管理信息
     * 
     * @param complicationId 并发症管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicComplicationByComplicationId(Long complicationId)
    {
        return epidemicComplicationMapper.deleteEpidemicComplicationByComplicationId(complicationId);
    }
}
