import request from '@/utils/request'

export function getinfo(user_id)
{
    return request({
        url: `/api/student_info/get?userId=${user_id}`,
        method: 'post',
    })
}

export function modifyinfo(user_id,personalinfo)
{
    return request({
        url: `/api/student_info/update?counselorName=${personalinfo.teacher_name}&address=${personalinfo.addr}&graduation=0&mobile=${personalinfo.phonenumber}&degree=${personalinfo.category}&fullTime=0&department=${personalinfo.school}&userId=${user_id}`,
        method: 'post',
    })
}
