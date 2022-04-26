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
import zstu.epidemic.illness.domain.EpidemicIllnessTrans;
import zstu.epidemic.illness.service.IEpidemicIllnessTransService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 疾病传播方式Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/illness_trans")
public class EpidemicIllnessTransController extends BaseController
{
    @Autowired
    private IEpidemicIllnessTransService epidemicIllnessTransService;

    /**
     * 查询疾病传播方式列表
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_trans:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicIllnessTrans epidemicIllnessTrans)
    {
        startPage();
        List<EpidemicIllnessTrans> list = epidemicIllnessTransService.selectEpidemicIllnessTransList(epidemicIllnessTrans);
        return getDataTable(list);
    }

    /**
     * 导出疾病传播方式列表
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_trans:export')")
    @Log(title = "疾病传播方式", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicIllnessTrans epidemicIllnessTrans)
    {
        List<EpidemicIllnessTrans> list = epidemicIllnessTransService.selectEpidemicIllnessTransList(epidemicIllnessTrans);
        ExcelUtil<EpidemicIllnessTrans> util = new ExcelUtil<EpidemicIllnessTrans>(EpidemicIllnessTrans.class);
        util.exportExcel(response, list, "疾病传播方式数据");
    }

    /**
     * 获取疾病传播方式详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_trans:query')")
    @GetMapping(value = "/{transId}")
    public AjaxResult getInfo(@PathVariable("transId") Long transId)
    {
        return AjaxResult.success(epidemicIllnessTransService.selectEpidemicIllnessTransByTransId(transId));
    }

    /**
     * 新增疾病传播方式
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_trans:add')")
    @Log(title = "疾病传播方式", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicIllnessTrans epidemicIllnessTrans)
    {
        return toAjax(epidemicIllnessTransService.insertEpidemicIllnessTrans(epidemicIllnessTrans));
    }

    /**
     * 修改疾病传播方式
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_trans:edit')")
    @Log(title = "疾病传播方式", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicIllnessTrans epidemicIllnessTrans)
    {
        return toAjax(epidemicIllnessTransService.updateEpidemicIllnessTrans(epidemicIllnessTrans));
    }

    /**
     * 删除疾病传播方式
     */
    @PreAuthorize("@ss.hasPermi('illness:illness_trans:remove')")
    @Log(title = "疾病传播方式", businessType = BusinessType.DELETE)
	@DeleteMapping("/{transIds}")
    public AjaxResult remove(@PathVariable Long[] transIds)
    {
        return toAjax(epidemicIllnessTransService.deleteEpidemicIllnessTransByTransIds(transIds));
    }
}
