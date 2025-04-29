package com.alinesno.infra.base.authority.identity.service;

import com.alinesno.infra.base.authority.api.identity.WechatUserDto;
import com.alinesno.infra.base.authority.identity.domain.WechatUserEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IWechatUserService extends IBaseService<WechatUserEntity> {

    /**
     * 保存微信用户信息
     *
     * @param dto
     * @return
     */
    WechatUserEntity saveWechatUser(WechatUserDto dto);

    /**
     * 判断openid是否存在
     * @param openid
     * @return
     */
    boolean isBindOpenId(String openid);

    /**
     * 判断手机号是否存在
     *
     * @param phone
     * @param dtoPhone
     * @return
     */
    boolean isBindPhone(String phone,String dtoPhone);
}
