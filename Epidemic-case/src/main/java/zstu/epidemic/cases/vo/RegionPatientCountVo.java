package zstu.epidemic.cases.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class RegionPatientCountVo implements Serializable {

	private static final long serialVersionUID = 1L;

	Long region_id;
	int count;
}
