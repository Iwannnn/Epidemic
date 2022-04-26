import request from '@/utils/request'

// 查询病史管理列表
export function listHistory(query) {
  return request({
    url: '/cases/history/list',
    method: 'get',
    params: query
  })
}

// 查询病史管理详细
export function getHistory(patientId) {
  return request({
    url: '/cases/history/' + patientId,
    method: 'get'
  })
}

// 新增病史管理
export function addHistory(data) {
  return request({
    url: '/cases/history',
    method: 'post',
    data: data
  })
}

// 修改病史管理
export function updateHistory(data) {
  return request({
    url: '/cases/history',
    method: 'put',
    data: data
  })
}

// 删除病史管理
export function delHistory(patientId) {
  return request({
    url: '/cases/history/' + patientId,
    method: 'delete'
  })
}
