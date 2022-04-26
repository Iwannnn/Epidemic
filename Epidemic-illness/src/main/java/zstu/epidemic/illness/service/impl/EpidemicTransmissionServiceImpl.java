package zstu.epidemic.illness.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicTransmissionMapper;
import zstu.epidemic.illness.domain.EpidemicTransmission;
import zstu.epidemic.illness.service.IEpidemicTransmissionService;

/**
 * 传播管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicTransmissionServiceImpl implements IEpidemicTransmissionService 
{
    @Autowired
    private EpidemicTransmissionMapper epidemicTransmissionMapper;

    /**
     * 查询传播管理
     * 
     * @param transmissionId 传播管理主键
     * @return 传播管理
     */
    @Override
    public EpidemicTransmission selectEpidemicTransmissionByTransmissionId(Long transmissionId)
    {
        return epidemicTransmissionMapper.selectEpidemicTransmissionByTransmissionId(transmissionId);
    }

    /**
     * 查询传播管理列表
     * 
     * @param epidemicTransmission 传播管理
     * @return 传播管理
     */
    @Override
    public List<EpidemicTransmission> selectEpidemicTransmissionList(EpidemicTransmission epidemicTransmission)
    {
        return epidemicTransmissionMapper.selectEpidemicTransmissionList(epidemicTransmission);
    }

    /**
     * 新增传播管理
     * 
     * @param epidemicTransmission 传播管理
     * @return 结果
     */
    @Override
    public int insertEpidemicTransmission(EpidemicTransmission epidemicTransmission)
    {
        epidemicTransmission.setCreateTime(DateUtils.getNowDate());
        return epidemicTransmissionMapper.insertEpidemicTransmission(epidemicTransmission);
    }

    /**
     * 修改传播管理
     * 
     * @param epidemicTransmission 传播管理
     * @return 结果
     */
    @Override
    public int updateEpidemicTransmission(EpidemicTransmission epidemicTransmission)
    {
        epidemicTransmission.setUpdateTime(DateUtils.getNowDate());
        return epidemicTransmissionMapper.updateEpidemicTransmission(epidemicTransmission);
    }

    /**
     * 批量删除传播管理
     * 
     * @param transmissionIds 需要删除的传播管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicTransmissionByTransmissionIds(Long[] transmissionIds)
    {
        return epidemicTransmissionMapper.deleteEpidemicTransmissionByTransmissionIds(transmissionIds);
    }

    /**
     * 删除传播管理信息
     * 
     * @param transmissionId 传播管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicTransmissionByTransmissionId(Long transmissionId)
    {
        return epidemicTransmissionMapper.deleteEpidemicTransmissionByTransmissionId(transmissionId);
    }
}
