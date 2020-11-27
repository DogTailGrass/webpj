import request from '@/utils/request'

//信息上报
export function getannouncement(user_token)
{
    return request({
        url: '/user/getannouncement',
        method: 'post',
        data:{
            token:user_token
        }
    })
}