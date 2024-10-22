package com.alinesno.infra.base.authority.config;

import com.alinesno.infra.base.authority.controller.AuthCommonLoginController;
import com.alinesno.infra.base.authority.controller.AuthSysDictDataController;
import com.alinesno.infra.common.web.adapter.enable.ApiConfigurationSelector;
import com.alinesno.infra.common.web.adapter.enable.CommonApiImport;
import com.alinesno.infra.common.web.adapter.login.controller.CommonCaptchaController;
import com.alinesno.infra.common.web.adapter.login.controller.kaptcha.CaptchaConfig;
import com.alinesno.infra.common.web.adapter.login.controller.kaptcha.KaptchaTextCreator;
import com.alinesno.infra.common.web.adapter.login.security.SecurityProperties;
import com.alinesno.infra.common.web.adapter.login.security.StpInterfaceImpl;
import com.alinesno.infra.common.web.adapter.sso.controller.SsoClientController;
import com.alinesno.infra.common.web.adapter.sso.controller.SsoH5Controller;
import com.alinesno.infra.common.web.adapter.sso.listener.SaTokenListener;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * 引入自动类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class AuthorityApiConfigurationSelector implements ImportSelector {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ApiConfigurationSelector.class);

	@NotNull
	@Override
	public String[] selectImports(@NotNull AnnotationMetadata importingClassMetadata) {

        List<String> importBean = new ArrayList<>(CommonApiImport.importCommonWeb());

		// 安全验证
		importBean.add(SecurityProperties.class.getName()) ;
		importBean.add(AuthSecurityConfig.class.getName()) ;
		importBean.add(StpInterfaceImpl.class.getName()) ;

		// 验证码信息
		importBean.add(KaptchaTextCreator.class.getName()) ;
		importBean.add(CaptchaConfig.class.getName()) ;

		// 登陆信息
		importBean.add(CommonCaptchaController.class.getName()) ;

		importBean.add(AuthCommonLoginController.class.getName()) ;
		importBean.add(AuthSysDictDataController.class.getName()) ;

		importBean.add(AuthCurrentAccountMethodArgumentResolver.class.getName()) ;

		// SSO单点登陆
		importBean.add(SsoH5Controller.class.getName()) ;
		importBean.add(SsoClientController.class.getName()) ;
		importBean.add(SaTokenListener.class.getName()) ;

		return importBean.toArray(new String[] {});
	}

}
