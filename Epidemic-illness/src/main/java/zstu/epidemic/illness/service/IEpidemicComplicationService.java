package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicComplication;

/**
 * 并发症管理Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicComplicationService 
{
    /**
     * 查询并发症管理
     * 
     * @param complicationId 并发症管理主键
     * @return 并发症管理
     */
    public EpidemicComplication selectEpidemicComplicationByComplicationId(Long complicationId);

    /**
     * 查询并发症管理列表
     * 
     * @param epidemicComplication 并发症管理
     * @return 并发症管理集合
     */
    public List<EpidemicComplication> selectEpidemicComplicationList(EpidemicComplication epidemicComplication);

    /**
     * 新增并发症管理
     * 
     * @param epidemicComplication 并发症管理
     * @return 结果
     */
    public int insertEpidemicComplication(EpidemicComplication epidemicComplication);

    /**
     * 修改并发症管理
     * 
     * @param epidemicComplication 并发症管理
     * @return 结果
     */
    public int updateEpidemicComplication(EpidemicComplication epidemicComplication);

    /**
     * 批量删除并发症管理
     * 
     * @param complicationIds 需要删除的并发症管理主键集合
     * @return 结果
     */
    public int deleteEpidemicComplicationByComplicationIds(Long[] complicationIds);

    /**
     * 删除并发症管理信息
     * 
     * @param complicationId 并发症管理主键
     * @return 结果
     */
    public int deleteEpidemicComplicationByComplicationId(Long complicationId);
}
