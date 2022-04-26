import request from '@/utils/request'

// 查询文章管理列表
export function listPassage(query) {
  return request({
    url: '/illness/passage/list',
    method: 'get',
    params: query
  })
}

// 查询文章管理详细
export function getPassage(passageId) {
  return request({
    url: '/illness/passage/' + passageId,
    method: 'get'
  })
}

// 新增文章管理
export function addPassage(data) {
  return request({
    url: '/illness/passage',
    method: 'post',
    data: data
  })
}

// 修改文章管理
export function updatePassage(data) {
  return request({
    url: '/illness/passage',
    method: 'put',
    data: data
  })
}

// 删除文章管理
export function delPassage(passageId) {
  return request({
    url: '/illness/passage/' + passageId,
    method: 'delete'
  })
}
