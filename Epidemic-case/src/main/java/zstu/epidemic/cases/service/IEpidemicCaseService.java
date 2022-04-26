package zstu.epidemic.cases.service;

import java.util.List;
import zstu.epidemic.cases.domain.EpidemicCase;

/**
 * 病例管理Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicCaseService 
{
    /**
     * 查询病例管理
     * 
     * @param caseId 病例管理主键
     * @return 病例管理
     */
    public EpidemicCase selectEpidemicCaseByCaseId(Long caseId);

    /**
     * 查询病例管理列表
     * 
     * @param epidemicCase 病例管理
     * @return 病例管理集合
     */
    public List<EpidemicCase> selectEpidemicCaseList(EpidemicCase epidemicCase);

    /**
     * 新增病例管理
     * 
     * @param epidemicCase 病例管理
     * @return 结果
     */
    public int insertEpidemicCase(EpidemicCase epidemicCase);

    /**
     * 修改病例管理
     * 
     * @param epidemicCase 病例管理
     * @return 结果
     */
    public int updateEpidemicCase(EpidemicCase epidemicCase);

    /**
     * 批量删除病例管理
     * 
     * @param caseIds 需要删除的病例管理主键集合
     * @return 结果
     */
    public int deleteEpidemicCaseByCaseIds(Long[] caseIds);

    /**
     * 删除病例管理信息
     * 
     * @param caseId 病例管理主键
     * @return 结果
     */
    public int deleteEpidemicCaseByCaseId(Long caseId);
}
