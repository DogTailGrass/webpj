import request from '@/utils/request'

//信息上报
export function get_newest_announcement(user_id)
{
    return request({
        url: '/user/get_newest_announcement',
        method: 'post',
        data:{
            user_id:user_id
        }
    })
}

export function get_all_announcement(user_id)
{
    return request({
        url: '/user/get_all_announcement',
        method: 'post',
        data:{
            user_id:user_id
        }
    })
}