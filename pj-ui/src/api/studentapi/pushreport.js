import request from '@/utils/request'

//信息上报
export function inforeport(user_id,report)
{
    return request({
        url: `/api/student/report?userId=${user_id}&currentLocation=SH&hasFever=${report.isfever}&hasLeave=${report.isinschool}&todayBodyTemperature=${report.temperature}&hasContact=${report.iscontantpatient}&isolationPeriod=${report.isinquarantine}&remarks=None`,
        method: 'post',
    })
}
