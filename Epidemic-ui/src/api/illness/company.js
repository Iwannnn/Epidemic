import request from '@/utils/request'

// 查询公司管理列表
export function listCompany(query) {
  return request({
    url: '/illness/company/list',
    method: 'get',
    params: query
  })
}

// 查询公司管理详细
export function getCompany(companyId) {
  return request({
    url: '/illness/company/' + companyId,
    method: 'get'
  })
}

// 新增公司管理
export function addCompany(data) {
  return request({
    url: '/illness/company',
    method: 'post',
    data: data
  })
}

// 修改公司管理
export function updateCompany(data) {
  return request({
    url: '/illness/company',
    method: 'put',
    data: data
  })
}

// 删除公司管理
export function delCompany(companyId) {
  return request({
    url: '/illness/company/' + companyId,
    method: 'delete'
  })
}
