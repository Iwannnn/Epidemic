import request from '@/utils/request'

// 查询工厂管理列表
export function listDrug_factory(query) {
  return request({
    url: '/illness/drug_factory/list',
    method: 'get',
    params: query
  })
}

// 查询工厂管理详细
export function getDrug_factory(factoryId) {
  return request({
    url: '/illness/drug_factory/' + factoryId,
    method: 'get'
  })
}

// 新增工厂管理
export function addDrug_factory(data) {
  return request({
    url: '/illness/drug_factory',
    method: 'post',
    data: data
  })
}

// 修改工厂管理
export function updateDrug_factory(data) {
  return request({
    url: '/illness/drug_factory',
    method: 'put',
    data: data
  })
}

// 删除工厂管理
export function delDrug_factory(factoryId) {
  return request({
    url: '/illness/drug_factory/' + factoryId,
    method: 'delete'
  })
}
