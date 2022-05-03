package zstu.epidemic.cases.vo;

import lombok.Data;

@Data
public class CureTimeVo {
	// 治愈天数
	private int cureTime;
	// 痊愈的人数
	private int curedCount;
}
