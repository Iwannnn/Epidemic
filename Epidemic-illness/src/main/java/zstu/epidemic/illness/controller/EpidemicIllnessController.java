package zstu.epidemic.illness.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zstu.epidemic.common.annotation.Log;
import zstu.epidemic.common.core.controller.BaseController;
import zstu.epidemic.common.core.domain.AjaxResult;
import zstu.epidemic.common.enums.BusinessType;
import zstu.epidemic.illness.domain.EpidemicIllness;
import zstu.epidemic.illness.service.IEpidemicIllnessService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 疾病管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/illness")
public class EpidemicIllnessController extends BaseController
{
    @Autowired
    private IEpidemicIllnessService epidemicIllnessService;

    /**
     * 查询疾病管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:illness:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicIllness epidemicIllness)
    {
        startPage();
        List<EpidemicIllness> list = epidemicIllnessService.selectEpidemicIllnessList(epidemicIllness);
        return getDataTable(list);
    }

    /**
     * 导出疾病管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:illness:export')")
    @Log(title = "疾病管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicIllness epidemicIllness)
    {
        List<EpidemicIllness> list = epidemicIllnessService.selectEpidemicIllnessList(epidemicIllness);
        ExcelUtil<EpidemicIllness> util = new ExcelUtil<EpidemicIllness>(EpidemicIllness.class);
        util.exportExcel(response, list, "疾病管理数据");
    }

    /**
     * 获取疾病管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:illness:query')")
    @GetMapping(value = "/{illnessId}")
    public AjaxResult getInfo(@PathVariable("illnessId") Long illnessId)
    {
        return AjaxResult.success(epidemicIllnessService.selectEpidemicIllnessByIllnessId(illnessId));
    }

    /**
     * 新增疾病管理
     */
    @PreAuthorize("@ss.hasPermi('illness:illness:add')")
    @Log(title = "疾病管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicIllness epidemicIllness)
    {
        return toAjax(epidemicIllnessService.insertEpidemicIllness(epidemicIllness));
    }

    /**
     * 修改疾病管理
     */
    @PreAuthorize("@ss.hasPermi('illness:illness:edit')")
    @Log(title = "疾病管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicIllness epidemicIllness)
    {
        return toAjax(epidemicIllnessService.updateEpidemicIllness(epidemicIllness));
    }

    /**
     * 删除疾病管理
     */
    @PreAuthorize("@ss.hasPermi('illness:illness:remove')")
    @Log(title = "疾病管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{illnessIds}")
    public AjaxResult remove(@PathVariable Long[] illnessIds)
    {
        return toAjax(epidemicIllnessService.deleteEpidemicIllnessByIllnessIds(illnessIds));
    }
}
