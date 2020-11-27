import request from '../utils/request'

//信息上报
export function inforeport(username,
                        isfever,
                        isinschool,
                        iscontantpatient,
                        iscough,
                        isinquarantine,
                        isinrisk,
                        temperature)
{
    return request({
        url: '/user/inforeport',
        method: 'post',
        data: {
            username,
            isfever,
            isinschool,
            iscontantpatient,
            iscough,
            isinquarantine,
            isinrisk,
            temperature
        }
    })
}