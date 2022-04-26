package zstu.epidemic.cases.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.cases.mapper.EpidemicCaseMapper;
import zstu.epidemic.cases.domain.EpidemicCase;
import zstu.epidemic.cases.service.IEpidemicCaseService;

/**
 * 病例管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicCaseServiceImpl implements IEpidemicCaseService 
{
    @Autowired
    private EpidemicCaseMapper epidemicCaseMapper;

    /**
     * 查询病例管理
     * 
     * @param caseId 病例管理主键
     * @return 病例管理
     */
    @Override
    public EpidemicCase selectEpidemicCaseByCaseId(Long caseId)
    {
        return epidemicCaseMapper.selectEpidemicCaseByCaseId(caseId);
    }

    /**
     * 查询病例管理列表
     * 
     * @param epidemicCase 病例管理
     * @return 病例管理
     */
    @Override
    public List<EpidemicCase> selectEpidemicCaseList(EpidemicCase epidemicCase)
    {
        return epidemicCaseMapper.selectEpidemicCaseList(epidemicCase);
    }

    /**
     * 新增病例管理
     * 
     * @param epidemicCase 病例管理
     * @return 结果
     */
    @Override
    public int insertEpidemicCase(EpidemicCase epidemicCase)
    {
        epidemicCase.setCreateTime(DateUtils.getNowDate());
        return epidemicCaseMapper.insertEpidemicCase(epidemicCase);
    }

    /**
     * 修改病例管理
     * 
     * @param epidemicCase 病例管理
     * @return 结果
     */
    @Override
    public int updateEpidemicCase(EpidemicCase epidemicCase)
    {
        epidemicCase.setUpdateTime(DateUtils.getNowDate());
        return epidemicCaseMapper.updateEpidemicCase(epidemicCase);
    }

    /**
     * 批量删除病例管理
     * 
     * @param caseIds 需要删除的病例管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicCaseByCaseIds(Long[] caseIds)
    {
        return epidemicCaseMapper.deleteEpidemicCaseByCaseIds(caseIds);
    }

    /**
     * 删除病例管理信息
     * 
     * @param caseId 病例管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicCaseByCaseId(Long caseId)
    {
        return epidemicCaseMapper.deleteEpidemicCaseByCaseId(caseId);
    }
}
