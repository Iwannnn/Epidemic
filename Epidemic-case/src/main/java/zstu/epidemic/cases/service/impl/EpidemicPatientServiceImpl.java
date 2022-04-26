package zstu.epidemic.cases.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.cases.mapper.EpidemicPatientMapper;
import zstu.epidemic.cases.domain.EpidemicPatient;
import zstu.epidemic.cases.service.IEpidemicPatientService;

/**
 * 病人管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicPatientServiceImpl implements IEpidemicPatientService 
{
    @Autowired
    private EpidemicPatientMapper epidemicPatientMapper;

    /**
     * 查询病人管理
     * 
     * @param patientId 病人管理主键
     * @return 病人管理
     */
    @Override
    public EpidemicPatient selectEpidemicPatientByPatientId(Long patientId)
    {
        return epidemicPatientMapper.selectEpidemicPatientByPatientId(patientId);
    }

    /**
     * 查询病人管理列表
     * 
     * @param epidemicPatient 病人管理
     * @return 病人管理
     */
    @Override
    public List<EpidemicPatient> selectEpidemicPatientList(EpidemicPatient epidemicPatient)
    {
        return epidemicPatientMapper.selectEpidemicPatientList(epidemicPatient);
    }

    /**
     * 新增病人管理
     * 
     * @param epidemicPatient 病人管理
     * @return 结果
     */
    @Override
    public int insertEpidemicPatient(EpidemicPatient epidemicPatient)
    {
        epidemicPatient.setCreateTime(DateUtils.getNowDate());
        return epidemicPatientMapper.insertEpidemicPatient(epidemicPatient);
    }

    /**
     * 修改病人管理
     * 
     * @param epidemicPatient 病人管理
     * @return 结果
     */
    @Override
    public int updateEpidemicPatient(EpidemicPatient epidemicPatient)
    {
        epidemicPatient.setUpdateTime(DateUtils.getNowDate());
        return epidemicPatientMapper.updateEpidemicPatient(epidemicPatient);
    }

    /**
     * 批量删除病人管理
     * 
     * @param patientIds 需要删除的病人管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPatientByPatientIds(Long[] patientIds)
    {
        return epidemicPatientMapper.deleteEpidemicPatientByPatientIds(patientIds);
    }

    /**
     * 删除病人管理信息
     * 
     * @param patientId 病人管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPatientByPatientId(Long patientId)
    {
        return epidemicPatientMapper.deleteEpidemicPatientByPatientId(patientId);
    }
}
