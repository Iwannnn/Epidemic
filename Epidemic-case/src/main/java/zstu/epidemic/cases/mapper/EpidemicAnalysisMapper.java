package zstu.epidemic.cases.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zstu.epidemic.cases.domain.EpidemicCase;

import java.util.ArrayList;

@Mapper
@Repository
public interface EpidemicAnalysisMapper {
	ArrayList<EpidemicCase> getCaseListByIllnessName(String illness_name);
}
