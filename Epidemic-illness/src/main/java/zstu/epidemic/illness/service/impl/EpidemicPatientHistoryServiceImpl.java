package zstu.epidemic.illness.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicPatientHistoryMapper;
import zstu.epidemic.illness.domain.EpidemicPatientHistory;
import zstu.epidemic.illness.service.IEpidemicPatientHistoryService;

/**
 * 病史管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicPatientHistoryServiceImpl implements IEpidemicPatientHistoryService 
{
    @Autowired
    private EpidemicPatientHistoryMapper epidemicPatientHistoryMapper;

    /**
     * 查询病史管理
     * 
     * @param patientId 病史管理主键
     * @return 病史管理
     */
    @Override
    public EpidemicPatientHistory selectEpidemicPatientHistoryByPatientId(Long patientId)
    {
        return epidemicPatientHistoryMapper.selectEpidemicPatientHistoryByPatientId(patientId);
    }

    /**
     * 查询病史管理列表
     * 
     * @param epidemicPatientHistory 病史管理
     * @return 病史管理
     */
    @Override
    public List<EpidemicPatientHistory> selectEpidemicPatientHistoryList(EpidemicPatientHistory epidemicPatientHistory)
    {
        return epidemicPatientHistoryMapper.selectEpidemicPatientHistoryList(epidemicPatientHistory);
    }

    /**
     * 新增病史管理
     * 
     * @param epidemicPatientHistory 病史管理
     * @return 结果
     */
    @Override
    public int insertEpidemicPatientHistory(EpidemicPatientHistory epidemicPatientHistory)
    {
        return epidemicPatientHistoryMapper.insertEpidemicPatientHistory(epidemicPatientHistory);
    }

    /**
     * 修改病史管理
     * 
     * @param epidemicPatientHistory 病史管理
     * @return 结果
     */
    @Override
    public int updateEpidemicPatientHistory(EpidemicPatientHistory epidemicPatientHistory)
    {
        return epidemicPatientHistoryMapper.updateEpidemicPatientHistory(epidemicPatientHistory);
    }

    /**
     * 批量删除病史管理
     * 
     * @param patientIds 需要删除的病史管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPatientHistoryByPatientIds(Long[] patientIds)
    {
        return epidemicPatientHistoryMapper.deleteEpidemicPatientHistoryByPatientIds(patientIds);
    }

    /**
     * 删除病史管理信息
     * 
     * @param patientId 病史管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPatientHistoryByPatientId(Long patientId)
    {
        return epidemicPatientHistoryMapper.deleteEpidemicPatientHistoryByPatientId(patientId);
    }
}
