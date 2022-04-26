package zstu.epidemic.cases.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.cases.mapper.EpidemicCaseHospitalMapper;
import zstu.epidemic.cases.domain.EpidemicCaseHospital;
import zstu.epidemic.cases.service.IEpidemicCaseHospitalService;

/**
 * 病例医院管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicCaseHospitalServiceImpl implements IEpidemicCaseHospitalService 
{
    @Autowired
    private EpidemicCaseHospitalMapper epidemicCaseHospitalMapper;

    /**
     * 查询病例医院管理
     * 
     * @param caseHospitalId 病例医院管理主键
     * @return 病例医院管理
     */
    @Override
    public EpidemicCaseHospital selectEpidemicCaseHospitalByCaseHospitalId(Long caseHospitalId)
    {
        return epidemicCaseHospitalMapper.selectEpidemicCaseHospitalByCaseHospitalId(caseHospitalId);
    }

    /**
     * 查询病例医院管理列表
     * 
     * @param epidemicCaseHospital 病例医院管理
     * @return 病例医院管理
     */
    @Override
    public List<EpidemicCaseHospital> selectEpidemicCaseHospitalList(EpidemicCaseHospital epidemicCaseHospital)
    {
        return epidemicCaseHospitalMapper.selectEpidemicCaseHospitalList(epidemicCaseHospital);
    }

    /**
     * 新增病例医院管理
     * 
     * @param epidemicCaseHospital 病例医院管理
     * @return 结果
     */
    @Override
    public int insertEpidemicCaseHospital(EpidemicCaseHospital epidemicCaseHospital)
    {
        epidemicCaseHospital.setCreateTime(DateUtils.getNowDate());
        return epidemicCaseHospitalMapper.insertEpidemicCaseHospital(epidemicCaseHospital);
    }

    /**
     * 修改病例医院管理
     * 
     * @param epidemicCaseHospital 病例医院管理
     * @return 结果
     */
    @Override
    public int updateEpidemicCaseHospital(EpidemicCaseHospital epidemicCaseHospital)
    {
        epidemicCaseHospital.setUpdateTime(DateUtils.getNowDate());
        return epidemicCaseHospitalMapper.updateEpidemicCaseHospital(epidemicCaseHospital);
    }

    /**
     * 批量删除病例医院管理
     * 
     * @param caseHospitalIds 需要删除的病例医院管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicCaseHospitalByCaseHospitalIds(Long[] caseHospitalIds)
    {
        return epidemicCaseHospitalMapper.deleteEpidemicCaseHospitalByCaseHospitalIds(caseHospitalIds);
    }

    /**
     * 删除病例医院管理信息
     * 
     * @param caseHospitalId 病例医院管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicCaseHospitalByCaseHospitalId(Long caseHospitalId)
    {
        return epidemicCaseHospitalMapper.deleteEpidemicCaseHospitalByCaseHospitalId(caseHospitalId);
    }
}
