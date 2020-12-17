import request from '@/utils/request'


// 导出的是普通成员函数

// 登录
export function studentlogin(username,password){
    return request({
        url: '/user/studentlogin',
        method: 'post',
        data: {
            username:username,
            password:password
        }
    })
}

// 获取用户信息
export function getStudentInfo(user_id){
    return request({
        url: `/user/studentinfo/${user_id}`, // 反单引号，动态获取token值
        method: 'get'
    })
}