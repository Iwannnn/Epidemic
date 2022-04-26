package zstu.epidemic.cases.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.cases.mapper.EpidemicHospitalMapper;
import zstu.epidemic.cases.domain.EpidemicHospital;
import zstu.epidemic.cases.service.IEpidemicHospitalService;

/**
 * 医院管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicHospitalServiceImpl implements IEpidemicHospitalService 
{
    @Autowired
    private EpidemicHospitalMapper epidemicHospitalMapper;

    /**
     * 查询医院管理
     * 
     * @param hospitalId 医院管理主键
     * @return 医院管理
     */
    @Override
    public EpidemicHospital selectEpidemicHospitalByHospitalId(Long hospitalId)
    {
        return epidemicHospitalMapper.selectEpidemicHospitalByHospitalId(hospitalId);
    }

    /**
     * 查询医院管理列表
     * 
     * @param epidemicHospital 医院管理
     * @return 医院管理
     */
    @Override
    public List<EpidemicHospital> selectEpidemicHospitalList(EpidemicHospital epidemicHospital)
    {
        return epidemicHospitalMapper.selectEpidemicHospitalList(epidemicHospital);
    }

    /**
     * 新增医院管理
     * 
     * @param epidemicHospital 医院管理
     * @return 结果
     */
    @Override
    public int insertEpidemicHospital(EpidemicHospital epidemicHospital)
    {
        epidemicHospital.setCreateTime(DateUtils.getNowDate());
        return epidemicHospitalMapper.insertEpidemicHospital(epidemicHospital);
    }

    /**
     * 修改医院管理
     * 
     * @param epidemicHospital 医院管理
     * @return 结果
     */
    @Override
    public int updateEpidemicHospital(EpidemicHospital epidemicHospital)
    {
        epidemicHospital.setUpdateTime(DateUtils.getNowDate());
        return epidemicHospitalMapper.updateEpidemicHospital(epidemicHospital);
    }

    /**
     * 批量删除医院管理
     * 
     * @param hospitalIds 需要删除的医院管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicHospitalByHospitalIds(Long[] hospitalIds)
    {
        return epidemicHospitalMapper.deleteEpidemicHospitalByHospitalIds(hospitalIds);
    }

    /**
     * 删除医院管理信息
     * 
     * @param hospitalId 医院管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicHospitalByHospitalId(Long hospitalId)
    {
        return epidemicHospitalMapper.deleteEpidemicHospitalByHospitalId(hospitalId);
    }
}
