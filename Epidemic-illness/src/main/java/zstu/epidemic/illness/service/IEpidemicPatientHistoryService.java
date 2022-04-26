package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicPatientHistory;

/**
 * 病史管理Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicPatientHistoryService 
{
    /**
     * 查询病史管理
     * 
     * @param patientId 病史管理主键
     * @return 病史管理
     */
    public EpidemicPatientHistory selectEpidemicPatientHistoryByPatientId(Long patientId);

    /**
     * 查询病史管理列表
     * 
     * @param epidemicPatientHistory 病史管理
     * @return 病史管理集合
     */
    public List<EpidemicPatientHistory> selectEpidemicPatientHistoryList(EpidemicPatientHistory epidemicPatientHistory);

    /**
     * 新增病史管理
     * 
     * @param epidemicPatientHistory 病史管理
     * @return 结果
     */
    public int insertEpidemicPatientHistory(EpidemicPatientHistory epidemicPatientHistory);

    /**
     * 修改病史管理
     * 
     * @param epidemicPatientHistory 病史管理
     * @return 结果
     */
    public int updateEpidemicPatientHistory(EpidemicPatientHistory epidemicPatientHistory);

    /**
     * 批量删除病史管理
     * 
     * @param patientIds 需要删除的病史管理主键集合
     * @return 结果
     */
    public int deleteEpidemicPatientHistoryByPatientIds(Long[] patientIds);

    /**
     * 删除病史管理信息
     * 
     * @param patientId 病史管理主键
     * @return 结果
     */
    public int deleteEpidemicPatientHistoryByPatientId(Long patientId);
}