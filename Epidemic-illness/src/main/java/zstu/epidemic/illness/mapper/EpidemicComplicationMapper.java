package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicComplication;

/**
 * 并发症管理Mapper接口
 * 
 * @author iwan
 * @date 2022-05-04
 */
public interface EpidemicComplicationMapper 
{
    /**
     * 查询并发症管理
     * 
     * @param infectCompId 并发症管理主键
     * @return 并发症管理
     */
    public EpidemicComplication selectEpidemicComplicationByInfectCompId(Long infectCompId);

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
     * 删除并发症管理
     * 
     * @param infectCompId 并发症管理主键
     * @return 结果
     */
    public int deleteEpidemicComplicationByInfectCompId(Long infectCompId);

    /**
     * 批量删除并发症管理
     * 
     * @param infectCompIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicComplicationByInfectCompIds(Long[] infectCompIds);
}
