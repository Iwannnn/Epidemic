package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicSequelae;

/**
 * 后遗症Mapper接口
 * 
 * @author iwan
 * @date 2022-05-04
 */
public interface EpidemicSequelaeMapper 
{
    /**
     * 查询后遗症
     * 
     * @param illnessSeqId 后遗症主键
     * @return 后遗症
     */
    public EpidemicSequelae selectEpidemicSequelaeByIllnessSeqId(Long illnessSeqId);

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
     * 删除后遗症
     * 
     * @param illnessSeqId 后遗症主键
     * @return 结果
     */
    public int deleteEpidemicSequelaeByIllnessSeqId(Long illnessSeqId);

    /**
     * 批量删除后遗症
     * 
     * @param illnessSeqIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicSequelaeByIllnessSeqIds(Long[] illnessSeqIds);
}
