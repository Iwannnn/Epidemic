import request from '@/utils/request'

// 查询传播管理列表
export function listTransmission(query) {
  return request({
    url: '/illness/transmission/list',
    method: 'get',
    params: query
  })
}

// 查询传播管理详细
export function getTransmission(transmissionId) {
  return request({
    url: '/illness/transmission/' + transmissionId,
    method: 'get'
  })
}

// 新增传播管理
export function addTransmission(data) {
  return request({
    url: '/illness/transmission',
    method: 'post',
    data: data
  })
}

// 修改传播管理
export function updateTransmission(data) {
  return request({
    url: '/illness/transmission',
    method: 'put',
    data: data
  })
}

// 删除传播管理
export function delTransmission(transmissionId) {
  return request({
    url: '/illness/transmission/' + transmissionId,
    method: 'delete'
  })
}
