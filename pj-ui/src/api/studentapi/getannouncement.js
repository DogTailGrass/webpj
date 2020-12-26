import request from '@/utils/request'

export function get_notice()
{
    return request({
        url: '/api/notice/get_all',
        method: 'get',
    })
}

export function get_all_announcement()
{
    return request({
        url: '/api/user/get_all_announcement',
        method: 'get',
    })
}

export function get_announcement_content()
{
    return request({
        url: '/api/user/get_announcement_content',
        method: 'get',
    })
}