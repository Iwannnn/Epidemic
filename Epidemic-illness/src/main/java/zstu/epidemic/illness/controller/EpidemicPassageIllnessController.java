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
import zstu.epidemic.illness.domain.EpidemicPassageIllness;
import zstu.epidemic.illness.service.IEpidemicPassageIllnessService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 文章疾病Controller
 * 
 * @author iwan
 * @date 2022-05-04
 */
@RestController
@RequestMapping("/illness/illness_passage")
public class EpidemicPassageIllnessController extends BaseController
{
    @Autowired
    private IEpidemicPassageIllnessService epidemicPassageIllnessService;

    /**
     * 查询文章疾病列表
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_passage:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicPassageIllness epidemicPassageIllness)
    {
        startPage();
        List<EpidemicPassageIllness> list = epidemicPassageIllnessService.selectEpidemicPassageIllnessList(epidemicPassageIllness);
        return getDataTable(list);
    }

    /**
     * 导出文章疾病列表
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_passage:export')")
    @Log(title = "文章疾病", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicPassageIllness epidemicPassageIllness)
    {
        List<EpidemicPassageIllness> list = epidemicPassageIllnessService.selectEpidemicPassageIllnessList(epidemicPassageIllness);
        ExcelUtil<EpidemicPassageIllness> util = new ExcelUtil<EpidemicPassageIllness>(EpidemicPassageIllness.class);
        util.exportExcel(response, list, "文章疾病数据");
    }

    /**
     * 获取文章疾病详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_passage:query')")
    @GetMapping(value = "/{passageIllnessId}")
    public AjaxResult getInfo(@PathVariable("passageIllnessId") Long passageIllnessId)
    {
        return AjaxResult.success(epidemicPassageIllnessService.selectEpidemicPassageIllnessByPassageIllnessId(passageIllnessId));
    }

    /**
     * 新增文章疾病
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_passage:add')")
    @Log(title = "文章疾病", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicPassageIllness epidemicPassageIllness)
    {
        return toAjax(epidemicPassageIllnessService.insertEpidemicPassageIllness(epidemicPassageIllness));
    }

    /**
     * 修改文章疾病
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_passage:edit')")
    @Log(title = "文章疾病", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicPassageIllness epidemicPassageIllness)
    {
        return toAjax(epidemicPassageIllnessService.updateEpidemicPassageIllness(epidemicPassageIllness));
    }

    /**
     * 删除文章疾病
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_passage:remove')")
    @Log(title = "文章疾病", businessType = BusinessType.DELETE)
	@DeleteMapping("/{passageIllnessIds}")
    public AjaxResult remove(@PathVariable Long[] passageIllnessIds)
    {
        return toAjax(epidemicPassageIllnessService.deleteEpidemicPassageIllnessByPassageIllnessIds(passageIllnessIds));
    }
}
