import request from '@/utils/request'

// 查询病人管理列表
export function listPatient(query) {
  return request({
    url: '/cases/patient/list',
    method: 'get',
    params: query
  })
}

// 查询病人管理详细
export function getPatient(patientId) {
  return request({
    url: '/cases/patient/' + patientId,
    method: 'get'
  })
}

// 新增病人管理
export function addPatient(data) {
  return request({
    url: '/cases/patient',
    method: 'post',
    data: data
  })
}

// 修改病人管理
export function updatePatient(data) {
  return request({
    url: '/cases/patient',
    method: 'put',
    data: data
  })
}

// 删除病人管理
export function delPatient(patientId) {
  return request({
    url: '/cases/patient/' + patientId,
    method: 'delete'
  })
}
