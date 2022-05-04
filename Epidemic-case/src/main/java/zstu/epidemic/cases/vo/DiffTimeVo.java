package zstu.epidemic.cases.vo;

import lombok.Data;

@Data
public class DiffTimeVo {
	// 治愈天数
	private int diff_time;
	// 痊愈的人数
	private int cure_count;
}
