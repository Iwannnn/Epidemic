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
import zstu.epidemic.illness.domain.EpidemicDrugIllness;
import zstu.epidemic.illness.service.IEpidemicDrugIllnessService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 疾病药品Controller
 * 
 * @author iwan
 * @date 2022-05-04
 */
@RestController
@RequestMapping("/illness/drug_illness")
public class EpidemicDrugIllnessController extends BaseController
{
    @Autowired
    private IEpidemicDrugIllnessService epidemicDrugIllnessService;

    /**
     * 查询疾病药品列表
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_illness:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicDrugIllness epidemicDrugIllness)
    {
        startPage();
        List<EpidemicDrugIllness> list = epidemicDrugIllnessService.selectEpidemicDrugIllnessList(epidemicDrugIllness);
        return getDataTable(list);
    }

    /**
     * 导出疾病药品列表
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_illness:export')")
    @Log(title = "疾病药品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicDrugIllness epidemicDrugIllness)
    {
        List<EpidemicDrugIllness> list = epidemicDrugIllnessService.selectEpidemicDrugIllnessList(epidemicDrugIllness);
        ExcelUtil<EpidemicDrugIllness> util = new ExcelUtil<EpidemicDrugIllness>(EpidemicDrugIllness.class);
        util.exportExcel(response, list, "疾病药品数据");
    }

    /**
     * 获取疾病药品详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_illness:query')")
    @GetMapping(value = "/{drugIllnessId}")
    public AjaxResult getInfo(@PathVariable("drugIllnessId") Long drugIllnessId)
    {
        return AjaxResult.success(epidemicDrugIllnessService.selectEpidemicDrugIllnessByDrugIllnessId(drugIllnessId));
    }

    /**
     * 新增疾病药品
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_illness:add')")
    @Log(title = "疾病药品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicDrugIllness epidemicDrugIllness)
    {
        return toAjax(epidemicDrugIllnessService.insertEpidemicDrugIllness(epidemicDrugIllness));
    }

    /**
     * 修改疾病药品
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_illness:edit')")
    @Log(title = "疾病药品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicDrugIllness epidemicDrugIllness)
    {
        return toAjax(epidemicDrugIllnessService.updateEpidemicDrugIllness(epidemicDrugIllness));
    }

    /**
     * 删除疾病药品
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_illness:remove')")
    @Log(title = "疾病药品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{drugIllnessIds}")
    public AjaxResult remove(@PathVariable Long[] drugIllnessIds)
    {
        return toAjax(epidemicDrugIllnessService.deleteEpidemicDrugIllnessByDrugIllnessIds(drugIllnessIds));
    }
}
