//package com.alinesno.infra.base.authority.identity.adapter;
//
//import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
//import com.alinesno.infra.common.facade.response.R;
//import com.dtflys.forest.annotation.*;
//
///**
// * 账户接口
// */
//@BaseRequest(baseURL = "#{alinesno.infra.authority.host}" , connectTimeout = 30*1000)
//@Headers({
//        "Content-Type: application/json",
//        "Accept: */*",
//        "Connection: keep-alive"
//})
//public interface ManagerAccountConsumer {
//
////    /**
////     * 账户注册
////     * @param data
////     * @return
////     */
////    @Post(url = "/v1/api/base/authority/account/registerAccount")
////    ManagerAccountDto registerAccount(@Body ManagerAccountDto data);
//
////    /**
////     * 账户登陆
////     * @param data
////     * @return
////     */
////    @Post(url = "/v1/api/base/authority/account/login")
////    ManagerAccountDto loginAccount(@Body LoginParamDto data);
//
//    /**
//     * 根据用户登陆名查询用户
//     *
//     * @param loginName
//     * @param password
//     * @return
//     */
//    @Get(url = "/v1/api/base/authority/account/findByLoginNameWithRegister")
//    R<ManagerAccountDto> findByLoginNameWithRegister(@Query("loginName") String loginName,
//                                                     @Query("password") String password ,
//                                                     @Query("loginType") String loginType);
//
//    /**
//     * 查询账号的MFA密钥
//     * @param loginName
//     * @return
//     */
//    @Get(url = "/v1/api/base/authority/account/queryMfaSecret")
//    String queryMfaSecret(@Query("loginName") String loginName);
//
//}
