import request from '@/utils/request'

//信息上报
export function pushpersonalinfo(user_token,personalinfo)
{
    return request({
        url: '/user/inforeport',
        method: 'post',
        data: {
            token:user_token,
            personalinfo:personalinfo
        }
    })
}