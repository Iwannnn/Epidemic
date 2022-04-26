import request from '@/utils/request'

// 查询疾病药品列表
export function listDrug_illness(query) {
  return request({
    url: '/illness/drug_illness/list',
    method: 'get',
    params: query
  })
}

// 查询疾病药品详细
export function getDrug_illness(drugId) {
  return request({
    url: '/illness/drug_illness/' + drugId,
    method: 'get'
  })
}

// 新增疾病药品
export function addDrug_illness(data) {
  return request({
    url: '/illness/drug_illness',
    method: 'post',
    data: data
  })
}

// 修改疾病药品
export function updateDrug_illness(data) {
  return request({
    url: '/illness/drug_illness',
    method: 'put',
    data: data
  })
}

// 删除疾病药品
export function delDrug_illness(drugId) {
  return request({
    url: '/illness/drug_illness/' + drugId,
    method: 'delete'
  })
}
