package com.alinesno.infra.base.authority.identity.enums;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 短信提供厂家
 */
@Getter
public enum SmsProviderEnums {

    ALIYUN("alibaba", "阿里云"),
    CLOOPEN("cloopen", "容联云"),
    CTYUN("ctyun", "天翼云"),
    EMAY("emay", "亿美软通"),
    HUAWEIYUN("huawei", "华为云短信"),
    JDCLOUD("jdcloud", "京东云短信"),
    NETEASE("netease", "网易云信"),
    TENCENT("tencent", "腾讯云短信"),
    UNISMS("unisms", "合一短信"),
    YUNPIAN("yunpian", "云片短信"),
    ZHUTONG("zhutong", "助通短信"),
    DINGZHONG("dingzhong", "鼎众短信"),
    LIANLU("lianlu", "联麓短信");

    private final String code;
    private final String label;

    SmsProviderEnums(String code, String label) {
        this.code = code;
        this.label = label;
    }

    /**
     * 返回所有短信列表
     * @return
     */
    public static List<SmsProviderBean> getAll() {
        List<SmsProviderEnums> beans =  Arrays.asList(SmsProviderEnums.values());

        List<SmsProviderBean> beanList = new ArrayList<>() ;

        for(SmsProviderEnums e : beans){
            SmsProviderBean b = new SmsProviderBean() ;
            b.setCode(e.getCode());
            b.setLabel(e.getLabel());
            beanList.add(b) ;
        }

        return beanList ;
    }

    @Data
    public static class SmsProviderBean {
        private String code ;
        private String label ;
    }

}