import request from '@/utils/request'
import qs from 'qs'


// 导出的是普通成员函数

// 登录
export function studentlogin(userId,pwd){
    return request({
        url: `/api/user/login?userId=${userId}&pwd=${pwd}`,
        method: 'post',
        //data:{
        //    userId:userId,
        //    pwd:pwd
        //}
    })
}

// 获取用户信息
export function getStudentInfo(user_id){
    return request({
        url: `/api/user/studentinfo/${user_id}`, // 反单引号，动态获取token值
        method: 'get'
    })
}

export function resetpwd(form){
    return request({
        url: `/api/user/resetpwd?&userId=${form.number}&phone=${form.phone}&newpwd=${form.pwd}`, 
        method: 'post',
        data:{
            username:form.username
        }
    })
}