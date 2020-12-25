import request from '@/utils/request'

export function modifyPwd(user_id,newpwd)
{
    return request({
        url: `/api/user/modifyPwd?userId=${user_id}&newPw=${newpwd}`,
        method: 'post',
    })
}


