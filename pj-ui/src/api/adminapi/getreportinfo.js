import request from '@/utils/request'


// 导出的是普通成员函数
// 获取学生上报
export function getReportInfo(user_id){
    return request({
        url: '/api/user/admininfo', // 反单引号，动态获取token值
        method: 'get',
        data:{
            user_id:user_id
        }
    })
}