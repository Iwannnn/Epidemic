import request from '@/utils/request'

// 查询病例医院管理列表
export function listCase_hospital(query) {
  return request({
    url: '/cases/case_hospital/list',
    method: 'get',
    params: query
  })
}

// 查询病例医院管理详细
export function getCase_hospital(caseHospitalId) {
  return request({
    url: '/cases/case_hospital/' + caseHospitalId,
    method: 'get'
  })
}

// 新增病例医院管理
export function addCase_hospital(data) {
  return request({
    url: '/cases/case_hospital',
    method: 'post',
    data: data
  })
}

// 修改病例医院管理
export function updateCase_hospital(data) {
  return request({
    url: '/cases/case_hospital',
    method: 'put',
    data: data
  })
}

// 删除病例医院管理
export function delCase_hospital(caseHospitalId) {
  return request({
    url: '/cases/case_hospital/' + caseHospitalId,
    method: 'delete'
  })
}
