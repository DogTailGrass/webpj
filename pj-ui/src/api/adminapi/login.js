import request from '@/utils/request'


// 导出的是普通成员函数

// 登录
export function adminlogin(userId,pwd){
    return request({
        url: `/api/user/adminlogin?userId=${userId}&pwd=${pwd}`,
        method: 'post',
        //data:{
        //    userId:userId,
        //    pwd:pwd
        //}
    })
}

// 获取用户信息
export function getAdminInfo(user_id){
    return request({
        url: '/api/user/admininfo', 
        method: 'get',
        data:{
            user_id:user_id
        }
    })
}
