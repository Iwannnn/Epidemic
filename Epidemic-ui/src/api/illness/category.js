import request from '@/utils/request'

// 查询疾病分类列表
export function listCategory(query) {
  return request({
    url: '/illness/category/list',
    method: 'get',
    params: query
  })
}

// 查询疾病分类详细
export function getCategory(categoryId) {
  return request({
    url: '/illness/category/' + categoryId,
    method: 'get'
  })
}

// 新增疾病分类
export function addCategory(data) {
  return request({
    url: '/illness/category',
    method: 'post',
    data: data
  })
}

// 修改疾病分类
export function updateCategory(data) {
  return request({
    url: '/illness/category',
    method: 'put',
    data: data
  })
}

// 删除疾病分类
export function delCategory(categoryId) {
  return request({
    url: '/illness/category/' + categoryId,
    method: 'delete'
  })
}
