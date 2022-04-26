import request from '@/utils/request'

// 查询病例管理列表
export function listCases(query) {
  return request({
    url: '/cases/cases/list',
    method: 'get',
    params: query
  })
}

// 查询病例管理详细
export function getCases(caseId) {
  return request({
    url: '/cases/cases/' + caseId,
    method: 'get'
  })
}

// 新增病例管理
export function addCases(data) {
  return request({
    url: '/cases/cases',
    method: 'post',
    data: data
  })
}

// 修改病例管理
export function updateCases(data) {
  return request({
    url: '/cases/cases',
    method: 'put',
    data: data
  })
}

// 删除病例管理
export function delCases(caseId) {
  return request({
    url: '/cases/cases/' + caseId,
    method: 'delete'
  })
}
