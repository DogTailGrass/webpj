import request from '@/utils/request'

//信息上报
export function pushpersonalinfo(user_id,personalinfo)
{
    return request({
        url: '/user/inforeport',
        method: 'post',
        data: {
            user_id:user_id,
            personalinfo:personalinfo
        }
    })
}