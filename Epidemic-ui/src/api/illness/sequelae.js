import request from '@/utils/request'

// 查询后遗症列表
export function listSequelae(query) {
  return request({
    url: '/illness/sequelae/list',
    method: 'get',
    params: query
  })
}

// 查询后遗症详细
export function getSequelae(sequelaeId) {
  return request({
    url: '/illness/sequelae/' + sequelaeId,
    method: 'get'
  })
}

// 新增后遗症
export function addSequelae(data) {
  return request({
    url: '/illness/sequelae',
    method: 'post',
    data: data
  })
}

// 修改后遗症
export function updateSequelae(data) {
  return request({
    url: '/illness/sequelae',
    method: 'put',
    data: data
  })
}

// 删除后遗症
export function delSequelae(sequelaeId) {
  return request({
    url: '/illness/sequelae/' + sequelaeId,
    method: 'delete'
  })
}
