package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicSequelae;

/**
 * 后遗症Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicSequelaeService 
{
    /**
     * 查询后遗症
     * 
     * @param sequelaeId 后遗症主键
     * @return 后遗症
     */
    public EpidemicSequelae selectEpidemicSequelaeBySequelaeId(Long sequelaeId);

    /**
     * 查询后遗症列表
     * 
     * @param epidemicSequelae 后遗症
     * @return 后遗症集合
     */
    public List<EpidemicSequelae> selectEpidemicSequelaeList(EpidemicSequelae epidemicSequelae);

    /**
     * 新增后遗症
     * 
     * @param epidemicSequelae 后遗症
     * @return 结果
     */
    public int insertEpidemicSequelae(EpidemicSequelae epidemicSequelae);

    /**
     * 修改后遗症
     * 
     * @param epidemicSequelae 后遗症
     * @return 结果
     */
    public int updateEpidemicSequelae(EpidemicSequelae epidemicSequelae);

    /**
     * 批量删除后遗症
     * 
     * @param sequelaeIds 需要删除的后遗症主键集合
     * @return 结果
     */
    public int deleteEpidemicSequelaeBySequelaeIds(Long[] sequelaeIds);

    /**
     * 删除后遗症信息
     * 
     * @param sequelaeId 后遗症主键
     * @return 结果
     */
    public int deleteEpidemicSequelaeBySequelaeId(Long sequelaeId);
}
