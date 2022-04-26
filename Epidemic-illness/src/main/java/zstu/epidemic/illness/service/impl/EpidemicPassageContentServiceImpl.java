package zstu.epidemic.illness.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicPassageContentMapper;
import zstu.epidemic.illness.domain.EpidemicPassageContent;
import zstu.epidemic.illness.service.IEpidemicPassageContentService;

/**
 * 文章内容Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicPassageContentServiceImpl implements IEpidemicPassageContentService 
{
    @Autowired
    private EpidemicPassageContentMapper epidemicPassageContentMapper;

    /**
     * 查询文章内容
     * 
     * @param contentId 文章内容主键
     * @return 文章内容
     */
    @Override
    public EpidemicPassageContent selectEpidemicPassageContentByContentId(Long contentId)
    {
        return epidemicPassageContentMapper.selectEpidemicPassageContentByContentId(contentId);
    }

    /**
     * 查询文章内容列表
     * 
     * @param epidemicPassageContent 文章内容
     * @return 文章内容
     */
    @Override
    public List<EpidemicPassageContent> selectEpidemicPassageContentList(EpidemicPassageContent epidemicPassageContent)
    {
        return epidemicPassageContentMapper.selectEpidemicPassageContentList(epidemicPassageContent);
    }

    /**
     * 新增文章内容
     * 
     * @param epidemicPassageContent 文章内容
     * @return 结果
     */
    @Override
    public int insertEpidemicPassageContent(EpidemicPassageContent epidemicPassageContent)
    {
        epidemicPassageContent.setCreateTime(DateUtils.getNowDate());
        return epidemicPassageContentMapper.insertEpidemicPassageContent(epidemicPassageContent);
    }

    /**
     * 修改文章内容
     * 
     * @param epidemicPassageContent 文章内容
     * @return 结果
     */
    @Override
    public int updateEpidemicPassageContent(EpidemicPassageContent epidemicPassageContent)
    {
        epidemicPassageContent.setUpdateTime(DateUtils.getNowDate());
        return epidemicPassageContentMapper.updateEpidemicPassageContent(epidemicPassageContent);
    }

    /**
     * 批量删除文章内容
     * 
     * @param contentIds 需要删除的文章内容主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPassageContentByContentIds(Long[] contentIds)
    {
        return epidemicPassageContentMapper.deleteEpidemicPassageContentByContentIds(contentIds);
    }

    /**
     * 删除文章内容信息
     * 
     * @param contentId 文章内容主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPassageContentByContentId(Long contentId)
    {
        return epidemicPassageContentMapper.deleteEpidemicPassageContentByContentId(contentId);
    }
}
