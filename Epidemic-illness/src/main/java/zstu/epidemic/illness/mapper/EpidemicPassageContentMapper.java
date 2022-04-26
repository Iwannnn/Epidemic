package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicPassageContent;

/**
 * 文章内容Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicPassageContentMapper 
{
    /**
     * 查询文章内容
     * 
     * @param contentId 文章内容主键
     * @return 文章内容
     */
    public EpidemicPassageContent selectEpidemicPassageContentByContentId(Long contentId);

    /**
     * 查询文章内容列表
     * 
     * @param epidemicPassageContent 文章内容
     * @return 文章内容集合
     */
    public List<EpidemicPassageContent> selectEpidemicPassageContentList(EpidemicPassageContent epidemicPassageContent);

    /**
     * 新增文章内容
     * 
     * @param epidemicPassageContent 文章内容
     * @return 结果
     */
    public int insertEpidemicPassageContent(EpidemicPassageContent epidemicPassageContent);

    /**
     * 修改文章内容
     * 
     * @param epidemicPassageContent 文章内容
     * @return 结果
     */
    public int updateEpidemicPassageContent(EpidemicPassageContent epidemicPassageContent);

    /**
     * 删除文章内容
     * 
     * @param contentId 文章内容主键
     * @return 结果
     */
    public int deleteEpidemicPassageContentByContentId(Long contentId);

    /**
     * 批量删除文章内容
     * 
     * @param contentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicPassageContentByContentIds(Long[] contentIds);
}
