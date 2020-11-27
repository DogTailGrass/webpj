import request from '@/utils/request'

//信息上报
export function pushannouncement(user_token,announcement)
{
    return request({
        url: '/user/getannouncement',
        method: 'post',
        data:{
            token:user_token,
            announcement:announcement
        }
    })
}