import request from '@/utils/request'

export function getTrend(pjname){
    return request({
        url: `/api/trend?projectindex=${pjname}`,
        method: 'post',
    })
}