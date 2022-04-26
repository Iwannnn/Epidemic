package zstu.epidemic.cases.service;

import java.util.List;
import zstu.epidemic.cases.domain.EpidemicHospital;

/**
 * 医院管理Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicHospitalService 
{
    /**
     * 查询医院管理
     * 
     * @param hospitalId 医院管理主键
     * @return 医院管理
     */
    public EpidemicHospital selectEpidemicHospitalByHospitalId(Long hospitalId);

    /**
     * 查询医院管理列表
     * 
     * @param epidemicHospital 医院管理
     * @return 医院管理集合
     */
    public List<EpidemicHospital> selectEpidemicHospitalList(EpidemicHospital epidemicHospital);

    /**
     * 新增医院管理
     * 
     * @param epidemicHospital 医院管理
     * @return 结果
     */
    public int insertEpidemicHospital(EpidemicHospital epidemicHospital);

    /**
     * 修改医院管理
     * 
     * @param epidemicHospital 医院管理
     * @return 结果
     */
    public int updateEpidemicHospital(EpidemicHospital epidemicHospital);

    /**
     * 批量删除医院管理
     * 
     * @param hospitalIds 需要删除的医院管理主键集合
     * @return 结果
     */
    public int deleteEpidemicHospitalByHospitalIds(Long[] hospitalIds);

    /**
     * 删除医院管理信息
     * 
     * @param hospitalId 医院管理主键
     * @return 结果
     */
    public int deleteEpidemicHospitalByHospitalId(Long hospitalId);
}
