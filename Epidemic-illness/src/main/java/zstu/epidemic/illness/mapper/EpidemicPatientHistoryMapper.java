package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicPatientHistory;

/**
 * 病史管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicPatientHistoryMapper 
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
     * 删除病史管理
     * 
     * @param patientId 病史管理主键
     * @return 结果
     */
    public int deleteEpidemicPatientHistoryByPatientId(Long patientId);

    /**
     * 批量删除病史管理
     * 
     * @param patientIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicPatientHistoryByPatientIds(Long[] patientIds);
}
