package zstu.epidemic.cases.mapper;

import java.util.List;
import zstu.epidemic.cases.domain.EpidemicCaseHospital;

/**
 * 病例医院管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicCaseHospitalMapper 
{
    /**
     * 查询病例医院管理
     * 
     * @param caseHospitalId 病例医院管理主键
     * @return 病例医院管理
     */
    public EpidemicCaseHospital selectEpidemicCaseHospitalByCaseHospitalId(Long caseHospitalId);

    /**
     * 查询病例医院管理列表
     * 
     * @param epidemicCaseHospital 病例医院管理
     * @return 病例医院管理集合
     */
    public List<EpidemicCaseHospital> selectEpidemicCaseHospitalList(EpidemicCaseHospital epidemicCaseHospital);

    /**
     * 新增病例医院管理
     * 
     * @param epidemicCaseHospital 病例医院管理
     * @return 结果
     */
    public int insertEpidemicCaseHospital(EpidemicCaseHospital epidemicCaseHospital);

    /**
     * 修改病例医院管理
     * 
     * @param epidemicCaseHospital 病例医院管理
     * @return 结果
     */
    public int updateEpidemicCaseHospital(EpidemicCaseHospital epidemicCaseHospital);

    /**
     * 删除病例医院管理
     * 
     * @param caseHospitalId 病例医院管理主键
     * @return 结果
     */
    public int deleteEpidemicCaseHospitalByCaseHospitalId(Long caseHospitalId);

    /**
     * 批量删除病例医院管理
     * 
     * @param caseHospitalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicCaseHospitalByCaseHospitalIds(Long[] caseHospitalIds);
}
