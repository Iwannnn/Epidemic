import request from '@/utils/request'

// 查询并发症管理列表
export function listComplication(query) {
  return request({
    url: '/illness/complication/list',
    method: 'get',
    params: query
  })
}

// 查询并发症管理详细
export function getComplication(complicationId) {
  return request({
    url: '/illness/complication/' + complicationId,
    method: 'get'
  })
}

// 新增并发症管理
export function addComplication(data) {
  return request({
    url: '/illness/complication',
    method: 'post',
    data: data
  })
}

// 修改并发症管理
export function updateComplication(data) {
  return request({
    url: '/illness/complication',
    method: 'put',
    data: data
  })
}

// 删除并发症管理
export function delComplication(complicationId) {
  return request({
    url: '/illness/complication/' + complicationId,
    method: 'delete'
  })
}
