import request from '../utils/request'

//信息上报
export function pushpersonalinfo(name,
                            phone,
                            addr)
{
    return request({
        url: '/user/personalinfo',
        method: 'post',
        data: {
            name,
            phone,
            addr
        }
    })
}

export function getpersonalinfo(name,
                            phone,
                            addr)
{
    return request({
        url: '/user/personalinfo',
        method: 'get',
        data:{
            
        }
    })
}