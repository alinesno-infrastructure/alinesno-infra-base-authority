package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("content_notice")
public class ContentNoticeEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 文章作者
	 */
	@ColumnType(length = 50)
	@ColumnComment("文章作者")
	@TableField("notice_author")
	@Excel(name = "作者")
	private String noticeAuthor;

	/**
	 * 文章日期
	 */
	@ColumnType
	@ColumnComment("文章日期")
	@TableField("notice_date")
	private Date noticeDate;

	/**
	 * 文章内容
	 */
	@ColumnType(length = 1000)
	@ColumnComment("文章内容")
	@TableField("notice_content")
	@Excel(name = "通知内容")
	private String noticeContent;

	/**
	 * 文章标题
	 */
	@ColumnType(length = 100)
	@ColumnComment("文章标题")
	@TableField("notice_title")
	@Excel(name = "标题")
	private String noticeTitle;

	/**
	 * 当前状态(1草稿/2已发布)
	 */
	@ColumnType
	@ColumnComment("当前状态(1草稿/2已发布)")
	@TableField("notice_status")
	private Integer noticeStatus;

	/**
	 * 文章访问密码
	 */
	@ColumnType(length = 50)
	@ColumnComment("文章访问密码")
	@TableField("notice_password")
	private String noticePassword;

	/**
	 * 文章名称
	 */
	@ColumnType(length = 100)
	@ColumnComment("文章名称")
	@TableField("notice_name")
	private String noticeName;

	/**
	 * 文章最后修改时间
	 */
	@ColumnType
	@ColumnComment("文章最后修改时间")
	@TableField("notice_modifield")
	private Date noticeModifield;

	/**
	 * 文章类型
	 */
	@ColumnType(length = 50)
	@ColumnComment("文章类型")
	@TableField("notice_type")
	private String noticeType;

}
