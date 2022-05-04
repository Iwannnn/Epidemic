import request from '@/utils/request'

// 查询公司药品管理列表
export function listDrug_company(query) {
  return request({
    url: '/illness/drug_company/list',
    method: 'get',
    params: query
  })
}

// 查询公司药品管理详细
export function getDrug_company(drugCompanyId) {
  return request({
    url: '/illness/drug_company/' + drugCompanyId,
    method: 'get'
  })
}

// 新增公司药品管理
export function addDrug_company(data) {
  return request({
    url: '/illness/drug_company',
    method: 'post',
    data: data
  })
}

// 修改公司药品管理
export function updateDrug_company(data) {
  return request({
    url: '/illness/drug_company',
    method: 'put',
    data: data
  })
}

// 删除公司药品管理
export function delDrug_company(drugCompanyId) {
  return request({
    url: '/illness/drug_company/' + drugCompanyId,
    method: 'delete'
  })
}
