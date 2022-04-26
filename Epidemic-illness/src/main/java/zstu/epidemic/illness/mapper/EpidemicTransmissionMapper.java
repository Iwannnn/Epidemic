package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicTransmission;

/**
 * 传播管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicTransmissionMapper 
{
    /**
     * 查询传播管理
     * 
     * @param transmissionId 传播管理主键
     * @return 传播管理
     */
    public EpidemicTransmission selectEpidemicTransmissionByTransmissionId(Long transmissionId);

    /**
     * 查询传播管理列表
     * 
     * @param epidemicTransmission 传播管理
     * @return 传播管理集合
     */
    public List<EpidemicTransmission> selectEpidemicTransmissionList(EpidemicTransmission epidemicTransmission);

    /**
     * 新增传播管理
     * 
     * @param epidemicTransmission 传播管理
     * @return 结果
     */
    public int insertEpidemicTransmission(EpidemicTransmission epidemicTransmission);

    /**
     * 修改传播管理
     * 
     * @param epidemicTransmission 传播管理
     * @return 结果
     */
    public int updateEpidemicTransmission(EpidemicTransmission epidemicTransmission);

    /**
     * 删除传播管理
     * 
     * @param transmissionId 传播管理主键
     * @return 结果
     */
    public int deleteEpidemicTransmissionByTransmissionId(Long transmissionId);

    /**
     * 批量删除传播管理
     * 
     * @param transmissionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicTransmissionByTransmissionIds(Long[] transmissionIds);
}
