package zstu.epidemic.illness.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicDrugMapper;
import zstu.epidemic.illness.domain.EpidemicDrug;
import zstu.epidemic.illness.service.IEpidemicDrugService;

/**
 * 药品管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicDrugServiceImpl implements IEpidemicDrugService 
{
    @Autowired
    private EpidemicDrugMapper epidemicDrugMapper;

    /**
     * 查询药品管理
     * 
     * @param drugId 药品管理主键
     * @return 药品管理
     */
    @Override
    public EpidemicDrug selectEpidemicDrugByDrugId(Long drugId)
    {
        return epidemicDrugMapper.selectEpidemicDrugByDrugId(drugId);
    }

    /**
     * 查询药品管理列表
     * 
     * @param epidemicDrug 药品管理
     * @return 药品管理
     */
    @Override
    public List<EpidemicDrug> selectEpidemicDrugList(EpidemicDrug epidemicDrug)
    {
        return epidemicDrugMapper.selectEpidemicDrugList(epidemicDrug);
    }

    /**
     * 新增药品管理
     * 
     * @param epidemicDrug 药品管理
     * @return 结果
     */
    @Override
    public int insertEpidemicDrug(EpidemicDrug epidemicDrug)
    {
        epidemicDrug.setCreateTime(DateUtils.getNowDate());
        return epidemicDrugMapper.insertEpidemicDrug(epidemicDrug);
    }

    /**
     * 修改药品管理
     * 
     * @param epidemicDrug 药品管理
     * @return 结果
     */
    @Override
    public int updateEpidemicDrug(EpidemicDrug epidemicDrug)
    {
        epidemicDrug.setUpdateTime(DateUtils.getNowDate());
        return epidemicDrugMapper.updateEpidemicDrug(epidemicDrug);
    }

    /**
     * 批量删除药品管理
     * 
     * @param drugIds 需要删除的药品管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicDrugByDrugIds(Long[] drugIds)
    {
        return epidemicDrugMapper.deleteEpidemicDrugByDrugIds(drugIds);
    }

    /**
     * 删除药品管理信息
     * 
     * @param drugId 药品管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicDrugByDrugId(Long drugId)
    {
        return epidemicDrugMapper.deleteEpidemicDrugByDrugId(drugId);
    }
}
