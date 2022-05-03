package zstu.epidemic.cases.service;

import java.util.ArrayList;
import java.util.List;
import zstu.epidemic.cases.domain.EpidemicPatient;

/**
 * 病人管理Service接口
 *
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicPatientService
{
    /**
     * 查询病人管理
     *
     * @param patientId 病人管理主键
     * @return 病人管理
     */
    public EpidemicPatient selectEpidemicPatientByPatientId(Long patientId);

    /**
     * 查询病人管理列表
     *
     * @param epidemicPatient 病人管理
     * @return 病人管理集合
     */
    public List<EpidemicPatient> selectEpidemicPatientList(EpidemicPatient epidemicPatient);

    /**
     * 新增病人管理
     *
     * @param epidemicPatient 病人管理
     * @return 结果
     */
    public int insertEpidemicPatient(EpidemicPatient epidemicPatient);

    /**
     * 修改病人管理
     *
     * @param epidemicPatient 病人管理
     * @return 结果
     */
    public int updateEpidemicPatient(EpidemicPatient epidemicPatient);

    /**
     * 批量删除病人管理
     *
     * @param patientIds 需要删除的病人管理主键集合
     * @return 结果
     */
    public int deleteEpidemicPatientByPatientIds(Long[] patientIds);

    /**
     * 删除病人管理信息
     *
     * @param patientId 病人管理主键
     * @return 结果
     */
    public int deleteEpidemicPatientByPatientId(Long patientId);

    ArrayList<EpidemicPatient> getPatientListByIllnessName(String illness_name);
}
