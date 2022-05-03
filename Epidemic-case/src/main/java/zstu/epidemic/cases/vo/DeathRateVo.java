package zstu.epidemic.cases.vo;

import lombok.Data;
import zstu.epidemic.common.annotation.Excel;

@Data
public class DeathRateVo {
    //染病总人数
    private int all_number;
    //死亡人数
    private int death_number;
}
