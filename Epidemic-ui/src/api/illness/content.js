import request from '@/utils/request'

// 查询文章内容列表
export function listContent(query) {
  return request({
    url: '/illness/content/list',
    method: 'get',
    params: query
  })
}

// 查询文章内容详细
export function getContent(contentId) {
  return request({
    url: '/illness/content/' + contentId,
    method: 'get'
  })
}

// 新增文章内容
export function addContent(data) {
  return request({
    url: '/illness/content',
    method: 'post',
    data: data
  })
}

// 修改文章内容
export function updateContent(data) {
  return request({
    url: '/illness/content',
    method: 'put',
    data: data
  })
}

// 删除文章内容
export function delContent(contentId) {
  return request({
    url: '/illness/content/' + contentId,
    method: 'delete'
  })
}
