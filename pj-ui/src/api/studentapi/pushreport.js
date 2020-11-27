import request from '@/utils/request'

//信息上报
export function inforeport(user_token,report)
{
    return request({
        url: '/user/inforeport',
        method: 'post',
        data: {
            token:user_token,
            report:report
        }
    })
}