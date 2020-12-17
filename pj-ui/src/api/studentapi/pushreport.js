import request from '@/utils/request'

//信息上报
export function inforeport(user_id,report)
{
    return request({
        url: '/user/inforeport',
        method: 'post',
        data: {
            user_id:user_id,
            report:report
        }
    })
}