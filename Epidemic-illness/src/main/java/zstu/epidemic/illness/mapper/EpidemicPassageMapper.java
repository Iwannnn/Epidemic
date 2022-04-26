package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicPassage;

/**
 * 文章管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicPassageMapper 
{
    /**
     * 查询文章管理
     * 
     * @param passageId 文章管理主键
     * @return 文章管理
     */
    public EpidemicPassage selectEpidemicPassageByPassageId(Long passageId);

    /**
     * 查询文章管理列表
     * 
     * @param epidemicPassage 文章管理
     * @return 文章管理集合
     */
    public List<EpidemicPassage> selectEpidemicPassageList(EpidemicPassage epidemicPassage);

    /**
     * 新增文章管理
     * 
     * @param epidemicPassage 文章管理
     * @return 结果
     */
    public int insertEpidemicPassage(EpidemicPassage epidemicPassage);

    /**
     * 修改文章管理
     * 
     * @param epidemicPassage 文章管理
     * @return 结果
     */
    public int updateEpidemicPassage(EpidemicPassage epidemicPassage);

    /**
     * 删除文章管理
     * 
     * @param passageId 文章管理主键
     * @return 结果
     */
    public int deleteEpidemicPassageByPassageId(Long passageId);

    /**
     * 批量删除文章管理
     * 
     * @param passageIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicPassageByPassageIds(Long[] passageIds);
}
