package com.alinesno.infra.base.authority.identity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpUtil;
import com.alinesno.infra.base.authority.api.identity.WechatUserDto;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.gateway.dto.AuthManagerAccountDto;
import com.alinesno.infra.base.authority.identity.domain.WechatUserEntity;
import com.alinesno.infra.base.authority.identity.mapper.WechatUserMapper;
import com.alinesno.infra.base.authority.identity.service.IWechatUserService;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Slf4j
@Service
public class IWechatUserServiceImpl extends IBaseServiceImpl<WechatUserEntity, WechatUserMapper> implements IWechatUserService {

    @Autowired
    private IManagerAccountService accountService ;

    /**
     * 保存微信信息，然后更新到用户信息表中
     *
     * @param dto
     * @return
     */
    @Override
    public WechatUserEntity saveWechatUser(WechatUserDto dto) {

        // 通过openid查询用户信息
        LambdaQueryWrapper<WechatUserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WechatUserEntity::getOpenid, dto.getOpenid());
        WechatUserEntity user = getOne(wrapper);

        // 如果为空则创建新的账户
        if (user == null) {

            user = new WechatUserEntity();

            CopyOptions copyOptions = CopyOptions.create()
                    .setIgnoreNullValue(true)
                    .setIgnoreError(true) ;

            BeanUtil.copyProperties(dto, user , copyOptions);

            AuthManagerAccountDto authManagerAccountDto = getAuthManagerAccountDto(dto);
            user.setAccountId(authManagerAccountDto.getId());

            // 新增加账户
            save(user);
        }

        // 判断是否绑定用户
        if (user.getAccountId() == null) {
            AuthManagerAccountDto authManagerAccountDto = getAuthManagerAccountDto(dto);
            user.setAccountId(authManagerAccountDto.getId());
            // 更新微信用户信息
            updateById(user);
        }

        return user ;
    }

    @NotNull
    private AuthManagerAccountDto getAuthManagerAccountDto(WechatUserDto dto) {
        // 绑定微信用户
        AuthManagerAccountDto authManagerAccountDto =  accountService.findByLoginNameWithRegister(
                dto.getPhone(),
                IdUtil.nanoId(8) , // 生成随机的密码
                "account") ;

        // 更新账户信息
        ManagerAccountEntity account = accountService.getById(authManagerAccountDto.getId())  ;
        account.setName(dto.getNickname());
        account.setSex(dto.getSex() == 1 ? "1" : dto.getSex() == 2 ? "0":"-1");

        accountService.update(account);

        // 更新头像信息
        accountService.updateAvatarBase64(getHeaderBase64(dto.getHeadimgurl()), authManagerAccountDto.getId()) ;
        return authManagerAccountDto;
    }

    @Override
    public boolean isBindOpenId(String openid) {

        // 通过openid查询用户信息
        LambdaQueryWrapper<WechatUserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WechatUserEntity::getOpenid, openid) ;
        WechatUserEntity user = getOne(wrapper);

        // 如果为空则创建新的账户
        if (user != null) {
            return user.getAccountId() != null;
        }

        return false;
    }

    @Override
    public boolean isBindPhone(String openId, String phone) {
        LambdaQueryWrapper<WechatUserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WechatUserEntity::getOpenid, openId) ;
        wrapper.eq(WechatUserEntity::getPhone, phone) ;

        return count(wrapper) > 0 ;
    }

    private String getHeaderBase64(String headimgurl) {

        byte[] bytes = null ;

        try {
            bytes = HttpUtil.downloadBytes(headimgurl);
        } catch (Exception e) {
            log.error("获取微信头像失败", e);
        }

        return Base64.getEncoder().encodeToString(bytes);
    }

}
