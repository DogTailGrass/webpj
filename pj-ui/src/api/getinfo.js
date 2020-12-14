import request from '../utils/request'

//信息上报
export function getuserinfo()
{
    return request({
        url: '/user/userinfo',
        method: 'get'
    })
}