import request from '@/utils/request'


// 导出的是普通成员函数
// 获取学生上报
export function getReportInfo(token){
    return request({
        url: `/user/admininfo/${token}`, // 反单引号，动态获取token值
        method: 'get'
    })
}