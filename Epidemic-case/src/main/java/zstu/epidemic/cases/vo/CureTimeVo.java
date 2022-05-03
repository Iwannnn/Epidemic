package zstu.epidemic.cases.vo;

import lombok.Data;
import zstu.epidemic.cases.domain.EpidemicCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Data
public class CureTimeVo {
    //治愈天数
    private int cureTime;
    //痊愈的人数
    private int curedCount;
}
