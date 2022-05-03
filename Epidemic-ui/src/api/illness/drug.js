import request from '@/utils/request'

// 查询药品管理列表
export function listDrug(query) {
	return request({
		url: '/illness/drug/list',
		method: 'get',
		params: query
	})
}

// 查询药品管理详细
export function getDrug(drugId) {
	return request({
		url: '/illness/drug/' + drugId,
		method: 'get'
	})
}

// 新增药品管理
export function addDrug(data) {
	return request({
		url: '/illness/drug',
		method: 'post',
		data: data
	})
}

// 修改药品管理
export function updateDrug(data) {
	return request({
		url: '/illness/drug',
		method: 'put',
		data: data
	})
}

// 删除药品管理
export function delDrug(drugId) {
	return request({
		url: '/illness/drug/' + drugId,
		method: 'delete'
	})
}
