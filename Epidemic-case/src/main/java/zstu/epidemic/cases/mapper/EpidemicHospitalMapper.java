package zstu.epidemic.cases.mapper;

import java.util.List;
import zstu.epidemic.cases.domain.EpidemicHospital;

/**
 * 医院管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicHospitalMapper 
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
     * 删除医院管理
     * 
     * @param hospitalId 医院管理主键
     * @return 结果
     */
    public int deleteEpidemicHospitalByHospitalId(Long hospitalId);

    /**
     * 批量删除医院管理
     * 
     * @param hospitalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicHospitalByHospitalIds(Long[] hospitalIds);
}
