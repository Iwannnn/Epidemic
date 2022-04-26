package zstu.epidemic.illness.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicPassageMapper;
import zstu.epidemic.illness.domain.EpidemicPassage;
import zstu.epidemic.illness.service.IEpidemicPassageService;

/**
 * 文章管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicPassageServiceImpl implements IEpidemicPassageService 
{
    @Autowired
    private EpidemicPassageMapper epidemicPassageMapper;

    /**
     * 查询文章管理
     * 
     * @param passageId 文章管理主键
     * @return 文章管理
     */
    @Override
    public EpidemicPassage selectEpidemicPassageByPassageId(Long passageId)
    {
        return epidemicPassageMapper.selectEpidemicPassageByPassageId(passageId);
    }

    /**
     * 查询文章管理列表
     * 
     * @param epidemicPassage 文章管理
     * @return 文章管理
     */
    @Override
    public List<EpidemicPassage> selectEpidemicPassageList(EpidemicPassage epidemicPassage)
    {
        return epidemicPassageMapper.selectEpidemicPassageList(epidemicPassage);
    }

    /**
     * 新增文章管理
     * 
     * @param epidemicPassage 文章管理
     * @return 结果
     */
    @Override
    public int insertEpidemicPassage(EpidemicPassage epidemicPassage)
    {
        epidemicPassage.setCreateTime(DateUtils.getNowDate());
        return epidemicPassageMapper.insertEpidemicPassage(epidemicPassage);
    }

    /**
     * 修改文章管理
     * 
     * @param epidemicPassage 文章管理
     * @return 结果
     */
    @Override
    public int updateEpidemicPassage(EpidemicPassage epidemicPassage)
    {
        epidemicPassage.setUpdateTime(DateUtils.getNowDate());
        return epidemicPassageMapper.updateEpidemicPassage(epidemicPassage);
    }

    /**
     * 批量删除文章管理
     * 
     * @param passageIds 需要删除的文章管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPassageByPassageIds(Long[] passageIds)
    {
        return epidemicPassageMapper.deleteEpidemicPassageByPassageIds(passageIds);
    }

    /**
     * 删除文章管理信息
     * 
     * @param passageId 文章管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPassageByPassageId(Long passageId)
    {
        return epidemicPassageMapper.deleteEpidemicPassageByPassageId(passageId);
    }
}
