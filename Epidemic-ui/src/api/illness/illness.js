import request from '@/utils/request'

// 查询疾病管理列表
export function listIllness(query) {
  return request({
    url: '/illness/illness/list',
    method: 'get',
    params: query
  })
}

// 查询疾病管理详细
export function getIllness(illnessId) {
  return request({
    url: '/illness/illness/' + illnessId,
    method: 'get'
  })
}

// 新增疾病管理
export function addIllness(data) {
  return request({
    url: '/illness/illness',
    method: 'post',
    data: data
  })
}

// 修改疾病管理
export function updateIllness(data) {
  return request({
    url: '/illness/illness',
    method: 'put',
    data: data
  })
}

// 删除疾病管理
export function delIllness(illnessId) {
  return request({
    url: '/illness/illness/' + illnessId,
    method: 'delete'
  })
}
