import request from '@/utils/request'

// 查询文章疾病列表
export function listIllness_passage(query) {
  return request({
    url: '/illness/illness_passage/list',
    method: 'get',
    params: query
  })
}

// 查询文章疾病详细
export function getIllness_passage(passageId) {
  return request({
    url: '/illness/illness_passage/' + passageId,
    method: 'get'
  })
}

// 新增文章疾病
export function addIllness_passage(data) {
  return request({
    url: '/illness/illness_passage',
    method: 'post',
    data: data
  })
}

// 修改文章疾病
export function updateIllness_passage(data) {
  return request({
    url: '/illness/illness_passage',
    method: 'put',
    data: data
  })
}

// 删除文章疾病
export function delIllness_passage(passageId) {
  return request({
    url: '/illness/illness_passage/' + passageId,
    method: 'delete'
  })
}
