package zstu.epidemic.cases.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.cases.mapper.EpidemicPatientHistoryMapper;
import zstu.epidemic.cases.domain.EpidemicPatientHistory;
import zstu.epidemic.cases.service.IEpidemicPatientHistoryService;

/**
 * 病史管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-05-04
 */
@Service
public class EpidemicPatientHistoryServiceImpl implements IEpidemicPatientHistoryService 
{
    @Autowired
    private EpidemicPatientHistoryMapper epidemicPatientHistoryMapper;

    /**
     * 查询病史管理
     * 
     * @param patientHistoryId 病史管理主键
     * @return 病史管理
     */
    @Override
    public EpidemicPatientHistory selectEpidemicPatientHistoryByPatientHistoryId(Long patientHistoryId)
    {
        return epidemicPatientHistoryMapper.selectEpidemicPatientHistoryByPatientHistoryId(patientHistoryId);
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
     * @param patientHistoryIds 需要删除的病史管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPatientHistoryByPatientHistoryIds(Long[] patientHistoryIds)
    {
        return epidemicPatientHistoryMapper.deleteEpidemicPatientHistoryByPatientHistoryIds(patientHistoryIds);
    }

    /**
     * 删除病史管理信息
     * 
     * @param patientHistoryId 病史管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPatientHistoryByPatientHistoryId(Long patientHistoryId)
    {
        return epidemicPatientHistoryMapper.deleteEpidemicPatientHistoryByPatientHistoryId(patientHistoryId);
    }
}
