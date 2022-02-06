// API
import $axios from 'axios'

// 로그인 요청
export function requestLogin ({ state }, payload) {
  console.log('requestLogin', state, payload)
  const url = '/auth/login'
  let body = payload
  return $axios.post(url, body)
}

// 회원가입 요청
export function requestRegister ({ state }, payload) {
  console.log('requestRegister', state, payload)
  const url = '/user'
  let body = payload
  return $axios.post(url, body)
}

// 중복 아이디 체크
export function checkDupId ({ state }, payload) {
  console.log('checkDupId', state, payload.userId)
  const url = `/user/${payload.userId}`
  console.log(url)
  // let body = payload
  return $axios.get(url)
}

// 메인 페이지 정보 가져오기
export function getProfile ({ state }, payload) {
  console.log('getProfile', state, payload)
  const url = '/user/me'
  const token = payload
  return $axios({ method: 'get', url: url, headers: { Authorization: `Bearer ${token}`}})
}


// 로그인한 유저가 소속된 팀 정보 가져오기
export function getTeamInfo ({ state }, payload) {
  console.log('getTeamInfo', state, payload)
  const url = '/user/teamList'
  const token = payload
  return $axios({ method: 'get', url: url, headers: { Authorization: `Bearer ${token}`}})
}

// 팀 생성하기
export function registerTeam ({ state }, payload) {
  console.log('registerTeam', state, payload)
  const url = `/team?userId=${payload.userId}`
  const teamDto = payload.teamDto
  const token = payload.token
  return $axios({ method: 'post', url: url, data: teamDto, headers: { Authorization: `Bearer ${token}`}})
}

// 닉네임 수정
export function editProfile ({ state }, payload) {
  // console.log('editProfile', state, payload)
  // console.log(payload)
  const url = '/user'
  const token = payload.token
  const body = payload.body
  // console.log(body)
  return $axios({ method: 'patch', url: url, headers: { Authorization: `Bearer ${token}`}, data: body})
  // return $axios.patch(url, body)
}

// 특정 달의 달력 개요 가져오기
export function getCategoryCount({ state }, payload) {
  const teamId = parseInt(payload.teamId)
  const uploadDate = payload.uploadDate
  const url = `/team/${teamId}/count/${uploadDate}`
  return $axios({
    method: 'get',
    url: url
  })
}

//google토큰확인
export function verifyToken ({state},payload){
  console.log('verifyToken', state, payload)
  const url='auth/token';
  let body=payload;
  return $axios.post(url,body)
}


// 회원탈퇴
export function deleteUser ({ state }, payload) {
  const userId = payload.body.userId
  const url = '/user/delete'
  const token = payload.token
  const body = payload.body
  console.log(body)
  return $axios({ method: 'delete', url: url, headers: { Authorization: `Bearer ${token}`}, data: body})
}

// 유저 한달 일정 가져오기
export function getSchedule ({ state }, payload) {
  // console.log('getTeamInfo', state, payload)
  console.log(payload)
  const url = 'event/user/month'
  const token = payload
  return $axios({ method: 'get', url: url, headers: { Authorization: `Bearer ${token}`}})
}

// 스케줄 추가하기
export function createSchedule ({ state }, payload) {
  console.log(payload)
  const teamId = payload.teamId
  // const url = `/event/${teamId}`
  const body = payload.body
  const url = `/event/${teamId}`
  // const url = `/event/${teamId}?eventContent=${body.eventContent}&eventTitle=${body.eventTitle}&eventDate=${body.eventDate}`
  const token = payload.token
  return $axios({ method: 'post', url: url, data: body, headers: { Authorization: `Bearer ${token}`}})
}
