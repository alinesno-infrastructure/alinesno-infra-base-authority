package com.alinesno.infra.base.authority.api.vo;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerResourceVo extends InfraBaseEntity {

	private String resourceName;
	private String resourceLink;
	private String resourceIcon;
	private Long resourceParent = 0L;
	private String component;
	private Integer resourceOrder;
	private String menuType = "0"; // MenuEnums.MENU_ITEM.value ;
	private String openTarget;
	private String permission;
	private String permissionScript;
	private String visible ;
	private Long projectId;

}
