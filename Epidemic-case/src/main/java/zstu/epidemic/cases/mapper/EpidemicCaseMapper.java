package zstu.epidemic.cases.mapper;

import java.util.List;
import zstu.epidemic.cases.domain.EpidemicCase;

/**
 * 病例管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicCaseMapper 
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
     * 删除病例管理
     * 
     * @param caseId 病例管理主键
     * @return 结果
     */
    public int deleteEpidemicCaseByCaseId(Long caseId);

    /**
     * 批量删除病例管理
     * 
     * @param caseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicCaseByCaseIds(Long[] caseIds);
}
