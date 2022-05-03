package zstu.epidemic.cases.vo;

import java.io.Serializable;

// import java.io.Serializable;

import lombok.Data;

@Data
public class DeathRateVo implements Serializable {

	private static final long serialVersionUID = 1L;
	// 染病总人数
	private int all_number;
	// 死亡人数
	private int death_number;
}
