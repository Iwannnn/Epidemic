package zstu.epidemic.cases.mapper;

import java.util.List;
import zstu.epidemic.cases.domain.EpidemicPatientHistory;

/**
 * 病史管理Mapper接口
 * 
 * @author iwan
 * @date 2022-05-04
 */
public interface EpidemicPatientHistoryMapper 
{
    /**
     * 查询病史管理
     * 
     * @param patientHistoryId 病史管理主键
     * @return 病史管理
     */
    public EpidemicPatientHistory selectEpidemicPatientHistoryByPatientHistoryId(Long patientHistoryId);

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
     * 删除病史管理
     * 
     * @param patientHistoryId 病史管理主键
     * @return 结果
     */
    public int deleteEpidemicPatientHistoryByPatientHistoryId(Long patientHistoryId);

    /**
     * 批量删除病史管理
     * 
     * @param patientHistoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicPatientHistoryByPatientHistoryIds(Long[] patientHistoryIds);
}
