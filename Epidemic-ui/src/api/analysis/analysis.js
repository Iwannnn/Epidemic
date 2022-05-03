import request from '@/utils/request'


//参数为查询的疾病名称

//获取该疾病的死亡人数，总人数
export function query_death_info(illness_name) {
	return request({
		url: '/cases/analysis/get_death_rate/' + illness_name,
		method: 'get',
	})
}

//获取该疾病痊愈病例下的，治愈所需时间和耗费该时间的病例个数
export function query_diff_time(illness_name) {
	return request({
		url: '/cases/analysis/get_diff_time/' + illness_name,
		method: 'get',
	})
}

//获取该疾病病人的身体信息
export function query_patient_info(illness_name) {
	return request({
		url: '/cases/analysis/get_patient_info/' + illness_name,
		method: 'get',
	})
}

//获取该疾病在各个地区的分布，地区id，数量
export function query_region_info(illness_name) {
	return request({
		url: '/cases/analysis/get_region_info/' + illness_name,
		method: 'get',

	})
}