import request from '@/utils/request'

//信息上报
export function pushannouncement(user_id,announcement,push_date)
{
    return request({
        url: '/user/getannouncement',
        method: 'post',
        data:{
            user_id:user_id,
            announcement:announcement,
            push_date:push_date
        }
    })
}