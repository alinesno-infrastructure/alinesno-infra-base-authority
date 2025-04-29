import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 接口配置项
var prefix = '/api/infra/base/authority/loginGlobalConfig/';
var managerUrl = {
    addGlobalConfig: prefix + "addGlobalConfig"
}

// 新增全局配置
export function addGlobalConfig(data){
    return request({
        url: managerUrl.addGlobalConfig,
        method: 'post',
        data: data
    })
}