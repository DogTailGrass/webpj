import request from '@/utils/request'


// 导出的是普通成员函数

// 登录
export function studentregister(form){
    return request({
        url: '/user/studentlogin',
        method: 'post',
        data: {
            username:form.username,
            password:form.password,
            number:form.number,
            email:form.email,
            phonenumber:form.phonenumber
        }
    })
}
