import request from '@/utils/request'

// 查询疾病传播方式列表
export function listIllness_trans(query) {
  return request({
    url: '/illness/illness_trans/list',
    method: 'get',
    params: query
  })
}

// 查询疾病传播方式详细
export function getIllness_trans(illnessTransId) {
  return request({
    url: '/illness/illness_trans/' + illnessTransId,
    method: 'get'
  })
}

// 新增疾病传播方式
export function addIllness_trans(data) {
  return request({
    url: '/illness/illness_trans',
    method: 'post',
    data: data
  })
}

// 修改疾病传播方式
export function updateIllness_trans(data) {
  return request({
    url: '/illness/illness_trans',
    method: 'put',
    data: data
  })
}

// 删除疾病传播方式
export function delIllness_trans(illnessTransId) {
  return request({
    url: '/illness/illness_trans/' + illnessTransId,
    method: 'delete'
  })
}
