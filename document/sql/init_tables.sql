SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for content_comments
-- ----------------------------
DROP TABLE IF EXISTS `content_comments`;
CREATE TABLE `content_comments` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(50) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `comment_author` varchar(100) DEFAULT NULL COMMENT '评论作者',
    `comment_author_email` varchar(100) DEFAULT NULL COMMENT '评论作者邮箱',
    `comment_author_ip` varchar(100) DEFAULT NULL COMMENT '评论作者IP',
    `comment_author_url` varchar(100) DEFAULT NULL COMMENT '评论作者链接',
    `comment_content` varchar(100) DEFAULT NULL COMMENT '评论内容',
    `comment_date` date DEFAULT NULL COMMENT '评论日期',
    `comment_date_gmt` date DEFAULT NULL COMMENT '评论日期（GMT）',
    `comment_post_id` bigint DEFAULT NULL COMMENT '评论文章',
    `user_id` bigint DEFAULT NULL COMMENT '评论用户ID',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='内容评论表';

-- ----------------------------
-- Table structure for content_links
-- ----------------------------
DROP TABLE IF EXISTS `content_links`;
CREATE TABLE `content_links` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(50) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `link_description` varchar(100) DEFAULT NULL COMMENT '链接描述',
    `link_image` varchar(100) DEFAULT NULL COMMENT '链接图片',
    `link_name` varchar(100) DEFAULT NULL COMMENT '链接名称',
    `link_notes` varchar(100) DEFAULT NULL COMMENT '链接注释',
    `link_owner` bigint DEFAULT NULL COMMENT '链接所有者',
    `link_rating` int DEFAULT NULL COMMENT '链接评级',
    `link_target` varchar(100) DEFAULT NULL COMMENT '链接目标',
    `link_updated` date DEFAULT NULL COMMENT '链接更新日期',
    `link_url` varchar(100) DEFAULT NULL COMMENT '链接URL',
    `link_visible` varchar(100) DEFAULT NULL COMMENT '链接可见性',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='内容链接表';


-- ----------------------------
-- Table structure for basic_resources
-- 基础资源表
-- ----------------------------
DROP TABLE IF EXISTS `basic_resources`;
CREATE TABLE `basic_resources` (
    `id` bigint NOT NULL COMMENT '资源ID',
    `add_time` datetime(6) DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '应用ID',
    `delete_manager` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '删除管理员',
    `delete_time` datetime(6) DEFAULT NULL COMMENT '删除时间',
    `department_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部门ID',
    `field_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段ID',
    `field_prop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段属性',
    `has_delete` int NOT NULL COMMENT '是否删除',
    `has_status` int NOT NULL COMMENT '是否有状态',
    `last_update_operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '最后更新操作员ID',
    `operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作员ID',
    `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
    `update_time` datetime(6) DEFAULT NULL COMMENT '更新时间',
    `menu_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单类型',
    `open_target` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '打开目标',
    `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限',
    `permission_script` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限脚本',
    `resource_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源图标',
    `resource_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源链接',
    `resource_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源名称',
    `resource_order` int DEFAULT NULL COMMENT '资源排序',
    `resource_parent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父级资源',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for basic_settings
-- 基础设置表
-- ----------------------------
DROP TABLE IF EXISTS `basic_settings`;
CREATE TABLE `basic_settings` (
    `id` bigint NOT NULL COMMENT '设置ID',
    `add_time` datetime(6) DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '应用ID',
    `delete_manager` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '删除管理员',
    `delete_time` datetime(6) DEFAULT NULL COMMENT '删除时间',
    `department_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部门ID',
    `field_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段ID',
    `field_prop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段属性',
    `has_delete` int NOT NULL COMMENT '是否删除',
    `has_status` int NOT NULL COMMENT '是否有状态',
    `last_update_operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '最后更新操作员ID',
    `operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作员ID',
    `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
    `update_time` datetime(6) DEFAULT NULL COMMENT '更新时间',
    `current_use` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '当前使用',
    `settings_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设置描述',
    `settings_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设置键',
    `settings_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设置名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;


-- ----------------------------
-- Table structure for content_notice
-- 内容通知表
-- ----------------------------
DROP TABLE IF EXISTS `content_notice`;
CREATE TABLE `content_notice` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `notice_author` varchar(255) DEFAULT NULL COMMENT '通知作者',
    `notice_content` varchar(255) DEFAULT NULL COMMENT '通知内容',
    `notice_date` date DEFAULT NULL COMMENT '通知日期',
    `notice_modifield` date DEFAULT NULL COMMENT '通知修改日期',
    `notice_name` varchar(255) DEFAULT NULL COMMENT '通知名称',
    `notice_password` varchar(255) DEFAULT NULL COMMENT '通知密码',
    `notice_status` int DEFAULT NULL COMMENT '通知状态',
    `notice_title` varchar(255) DEFAULT NULL COMMENT '通知标题',
    `notice_type` varchar(255) DEFAULT NULL COMMENT '通知类型',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for content_post_type
-- 内容类型表
-- ----------------------------
DROP TABLE IF EXISTS `content_post_type`;
CREATE TABLE `content_post_type` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `type_add_time` date DEFAULT NULL COMMENT '类型添加时间',
    `type_name` varchar(255) DEFAULT NULL COMMENT '类型名称',
    `type_status` int DEFAULT NULL COMMENT '类型状态',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    `pid` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for content_postmeta
-- 内容元数据表
-- ----------------------------
DROP TABLE IF EXISTS `content_postmeta`;
CREATE TABLE `content_postmeta` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `meta_key` varchar(255) DEFAULT NULL COMMENT '元数据键',
    `meta_value` varchar(255) DEFAULT NULL COMMENT '元数据值',
    `post_id` bigint DEFAULT NULL COMMENT '内容ID',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for content_posts
-- 内容表
-- ----------------------------
DROP TABLE IF EXISTS `content_posts`;
CREATE TABLE `content_posts` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `comment_count` int DEFAULT NULL COMMENT '评论数',
    `post_author` varchar(255) DEFAULT NULL COMMENT '内容作者',
    `post_content` longtext COMMENT '内容',
    `post_date` date DEFAULT NULL COMMENT '内容日期',
    `post_mime_type` varchar(255) DEFAULT NULL COMMENT '内容MIME类型',
    `post_modifield` date DEFAULT NULL COMMENT '内容修改日期',
    `post_name` varchar(255) DEFAULT NULL COMMENT '内容名称',
    `post_password` varchar(255) DEFAULT NULL COMMENT '内容密码',
    `post_status` int DEFAULT NULL COMMENT '内容状态',
    `post_title` varchar(255) DEFAULT NULL COMMENT '内容标题',
    `post_type` varchar(255) DEFAULT NULL COMMENT '内容类型',
    `to_ping` varchar(255) DEFAULT NULL COMMENT '待审核',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for enterprise
-- 企业表
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `department_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段属性',
    `has_delete` int NOT NULL COMMENT '是否删除',
    `has_status` int NOT NULL COMMENT '状态',
    `last_update_operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作员',
    `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
    `logo` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'LOGO',
    `en_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '英文描述',
    `domain_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '域名',
    `credit_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '信用代码',
    `application_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '应用名称',
    `saas_url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '工作台地址',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for enterprise_account
-- 企业账号表
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_account`;
CREATE TABLE `enterprise_account` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `department_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段属性',
    `has_delete` int NOT NULL COMMENT '是否删除',
    `has_status` int NOT NULL COMMENT '状态',
    `last_update_operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作员',
    `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `enterprise_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '企业ID',
    `account_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '账号ID',
    `credit_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '信用代码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for enterprise_seo
-- 企业SEO表
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_seo`;
CREATE TABLE `enterprise_seo` (
    `seo_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'SEO描述',
    `seo_keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'SEO关键字',
    `seo_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'SEO标题',
    `site_language` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '站点语言',
    `site_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '站点名称',
    `site_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '站点路径',
    `config_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置名称',
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `department_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段属性',
    `has_delete` int NOT NULL COMMENT '是否删除',
    `has_status` int NOT NULL COMMENT '状态',
    `last_update_operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作员',
    `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `application_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '应用名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for enterprise_setting
-- 企业设置表
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_setting`;
CREATE TABLE `enterprise_setting` (
    `company` varchar(255) DEFAULT NULL COMMENT '所属公司',
    `company_address` varchar(255) DEFAULT NULL COMMENT '公司地址',
    `company_phone` varchar(255) DEFAULT NULL COMMENT '公司电话',
    `company_qrcode` varchar(255) DEFAULT NULL COMMENT '公司二维码',
    `service_qq` varchar(255) DEFAULT NULL COMMENT '客服QQ',
    `logo` varchar(255) DEFAULT NULL COMMENT 'logo',
    `company_email` varchar(255) DEFAULT NULL COMMENT '公司邮箱',
    `copy_right` varchar(255) DEFAULT NULL COMMENT '版权所有',
    `tech_support` varchar(255) DEFAULT NULL COMMENT '技术支持',
    `application_name` varchar(255) DEFAULT NULL,
    `config_name` varchar(36) DEFAULT NULL COMMENT '配置名称',
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(36) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(255) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `department_id` varchar(36) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(36) DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(255) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int NOT NULL COMMENT '是否删除',
    `has_status` int NOT NULL COMMENT '状态',
    `last_update_operator_id` varchar(36) DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` varchar(36) DEFAULT NULL COMMENT '操作员',
    `tenant_id` varchar(36) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `website` varchar(256) DEFAULT NULL COMMENT '企业官网'
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for enterprise_theme
-- 企业主题表
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_theme`;
CREATE TABLE `enterprise_theme` (
    `login_seo_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录SEO标题',
    `login_seo_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录SEO描述',
    `login_seo_keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录SEO关键字',
    `login_logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录LOGO',
    `logo_background` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录背景图',
    `logo_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录标题',
    `config_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置名称',
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `department_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字段属性',
    `has_delete` int NOT NULL COMMENT '是否删除',
    `has_status` int NOT NULL COMMENT '状态',
    `last_update_operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作员',
    `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `application_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '应用名称',
    `login_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录描述',
    `login_color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登录主题色',
    `power_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限描述',
    `has_qr_login` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;


-- ----------------------------
-- Table structure for info_address
-- 通讯地址表
-- ----------------------------
DROP TABLE IF EXISTS `info_address`;
CREATE TABLE `info_address` (
    `id` bigint NOT NULL COMMENT '主键',
    `parent_id` bigint DEFAULT NULL COMMENT '父级ID',
    `district_name` varchar(50) DEFAULT NULL COMMENT '行政区划名称',
    `short_name` varchar(50) DEFAULT NULL COMMENT '行政区划简称',
    `longitude` decimal(10,6) DEFAULT NULL COMMENT '经度',
    `latitude` decimal(10,6) DEFAULT NULL COMMENT '纬度',
    `level` int DEFAULT NULL COMMENT '行政区划级别',
    `sort` int DEFAULT NULL COMMENT '排序',
    `is_deleted` int DEFAULT NULL COMMENT '是否删除',
    `create_time` date DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `index_info_address_level` (`level`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='通讯地址表';

-- ----------------------------
-- Table structure for info_code
-- 信息代码表
-- ----------------------------
DROP TABLE IF EXISTS `info_code`;
CREATE TABLE `info_code` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `code_name` varchar(100) DEFAULT NULL COMMENT '代码名称',
    `code_type` varchar(100) DEFAULT NULL COMMENT '代码类型',
    `code_value` varchar(100) DEFAULT NULL COMMENT '代码值',
    `owners` varchar(100) DEFAULT NULL COMMENT '所有者',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='信息代码表';

-- ----------------------------
-- Table structure for info_job
-- 职位信息表
-- ----------------------------
DROP TABLE IF EXISTS `info_job`;
CREATE TABLE `info_job` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `job_name` varchar(100) DEFAULT NULL COMMENT '职位名称',
    `job_parent` varchar(100) DEFAULT NULL COMMENT '上级职位',
    `job_type` varchar(100) DEFAULT NULL COMMENT '职位类型',
    `owners` varchar(100) DEFAULT NULL COMMENT '所有者',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='职位信息表';

-- ----------------------------
-- Table structure for info_professional
-- 专业信息表
-- ----------------------------
DROP TABLE IF EXISTS `info_professional`;
CREATE TABLE `info_professional` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `owners` varchar(100) DEFAULT NULL COMMENT '所有者',
    `professional_name` varchar(100) DEFAULT NULL COMMENT '专业名称',
    `professional_prop` varchar(100) DEFAULT NULL COMMENT '专业属性',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='专业信息表';

-- ----------------------------
-- Table structure for info_school
-- 学校信息表
-- ----------------------------
DROP TABLE IF EXISTS `info_school`;
CREATE TABLE `info_school` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `owners` varchar(100) DEFAULT NULL COMMENT '所有者',
    `school_address` varchar(100) DEFAULT NULL COMMENT '学校地址',
    `school_code` varchar(100) DEFAULT NULL COMMENT '学校代码',
    `school_name` varchar(100) DEFAULT NULL COMMENT '学校名称',
    `school_owner` varchar(100) DEFAULT NULL COMMENT '学校所有者',
    `school_owner_code` varchar(100) DEFAULT NULL COMMENT '学校所有者代码',
    `school_properties` varchar(100) DEFAULT NULL COMMENT '学校属性',
    `school_properties_code` varchar(100) DEFAULT NULL COMMENT '学校属性代码',
    `school_province` varchar(100) DEFAULT NULL COMMENT '学校所在省份',
    `school_province_code` varchar(100) DEFAULT NULL COMMENT '学校所在省份代码',
    `school_type` varchar(100) DEFAULT NULL COMMENT '学校类型',
    `school_type_name` varchar(100) DEFAULT NULL COMMENT '学校类型名称',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='学校信息表';

-- ----------------------------
-- Table structure for info_settings
-- 信息设置表
-- ----------------------------
DROP TABLE IF EXISTS `info_settings`;
CREATE TABLE `info_settings` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `owners` varchar(100) DEFAULT NULL COMMENT '所有者',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='信息设置表';

-- ----------------------------
-- Table structure for info_zipcode
-- 邮政编码表
-- ----------------------------
DROP TABLE IF EXISTS `info_zipcode`;
CREATE TABLE `info_zipcode` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `area` varchar(100) DEFAULT NULL COMMENT '地区',
    `owners` varchar(100) DEFAULT NULL COMMENT '所有者',
    `zip_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='邮政编码表';


-- ----------------------------
-- Table structure for invoice_application
-- ----------------------------
DROP TABLE IF EXISTS `invoice_application`;
CREATE TABLE `invoice_application` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(255) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(255) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int NOT NULL,
    `has_status` int NOT NULL,
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `contract_number` varchar(100) DEFAULT NULL COMMENT '合同编号',
    `identification_number` varchar(100) DEFAULT NULL COMMENT '身份证号',
    `invoice_amount` decimal(19,2) DEFAULT NULL COMMENT '发票金额',
    `invoice_content` varchar(100) DEFAULT NULL COMMENT '发票内容',
    `invoice_issue_date` datetime DEFAULT NULL COMMENT '发票开具日期',
    `invoice_name` varchar(100) DEFAULT NULL COMMENT '发票名称',
    `invoice_number` varchar(100) DEFAULT NULL COMMENT '发票号码',
    `invoice_reciprocal` varchar(100) DEFAULT NULL COMMENT '发票对方',
    `invoice_result` varchar(100) DEFAULT NULL COMMENT '发票结果',
    `invoice_status` varchar(100) DEFAULT NULL COMMENT '发票状态',
    `invoice_type` varchar(100) DEFAULT NULL COMMENT '发票类型',
    `tax_point` int DEFAULT NULL COMMENT '税点',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='发票申请表';

-- ----------------------------
-- Table structure for manager_account
-- ----------------------------
DROP TABLE IF EXISTS `manager_account`;
CREATE TABLE `manager_account` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `account_status` varchar(100) DEFAULT NULL COMMENT '账户状态',
    `last_login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
    `last_login_time` varchar(100) DEFAULT NULL,
    `login_name` varchar(100) DEFAULT NULL,
    `name` varchar(100) DEFAULT NULL,
    `owners` varchar(100) DEFAULT NULL COMMENT '所属者',
    `password` varchar(100) DEFAULT NULL,
    `role_id` varchar(100) DEFAULT NULL,
    `role_power` varchar(100) DEFAULT NULL,
    `salt` varchar(100) DEFAULT NULL,
    `user_id` varchar(100) DEFAULT NULL,
    `department` varchar(100) DEFAULT NULL,
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `email` varchar(100) DEFAULT NULL,
    `phone` varchar(100) DEFAULT NULL,
    `sex` varchar(100) DEFAULT NULL,
    `has_editor` varchar(100) DEFAULT NULL,
    `avator_path` varchar(100) DEFAULT NULL COMMENT '用户头像',
    `enterprise_properties` varchar(100) DEFAULT NULL COMMENT '企业属性',
    `portal_prop` varchar(100) DEFAULT NULL,
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    `position_id` varchar(100) DEFAULT NULL COMMENT '岗位id',
    `bailor` varchar(100) DEFAULT NULL COMMENT '委托人',
    `cas_account_id` varchar(100) DEFAULT NULL COMMENT 'cas用户Id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='账户表';

-- ----------------------------
-- Table structure for manager_account_record
-- ----------------------------
DROP TABLE IF EXISTS `manager_account_record`;
CREATE TABLE `manager_account_record` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `account_id` varchar(100) DEFAULT NULL,
    `account_name` varchar(100) DEFAULT NULL,
    `agent` text,
    `create_time` date DEFAULT NULL,
    `ip` varchar(100) DEFAULT NULL,
    `login_name` varchar(100) DEFAULT NULL,
    `method` varchar(100) DEFAULT NULL,
    `method_desc` varchar(100) DEFAULT NULL,
    `method_time` bigint DEFAULT NULL,
    `operation` varchar(100) DEFAULT NULL,
    `params` longtext,
    `role_power` varchar(100) DEFAULT NULL,
    `url` varchar(100) DEFAULT NULL,
    `record_type` varchar(100) DEFAULT NULL,
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `index_manager_account_record_add_time` (`add_time`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='账户操作记录表';

-- ----------------------------
-- Table structure for manager_account_role
-- ----------------------------
DROP TABLE IF EXISTS `manager_account_role`;
CREATE TABLE `manager_account_role` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `account_id` varchar(100) DEFAULT NULL,
    `role_id` varchar(100) DEFAULT NULL,
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='账户角色关联表';

-- ----------------------------
-- Table structure for manager_account_temp
-- ----------------------------
DROP TABLE IF EXISTS `manager_account_temp`;
CREATE TABLE `manager_account_temp` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(255) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(255) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL,
    `account_status` varchar(255) DEFAULT NULL COMMENT '账户状态',
    `last_login_ip` varchar(255) DEFAULT NULL,
    `last_login_time` varchar(255) DEFAULT NULL,
    `bailor` varchar(100) DEFAULT NULL COMMENT '委托人',
    `login_name` varchar(255) DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    `owners` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `role_id` varchar(255) DEFAULT NULL,
    `role_power` varchar(255) DEFAULT NULL,
    `salt` varchar(255) DEFAULT NULL,
    `user_id` varchar(255) DEFAULT NULL,
    `department` varchar(255) DEFAULT NULL,
    `department_id` bigint DEFAULT NULL,
    `field_id` bigint DEFAULT NULL,
    `operator_id` bigint DEFAULT NULL,
    `last_update_operator_id` bigint DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `phone` varchar(255) DEFAULT NULL,
    `sex` varchar(255) DEFAULT NULL,
    `has_editor` varchar(255) DEFAULT NULL,
    `avator_path` varchar(512) DEFAULT NULL COMMENT '用户头像',
    `enterprise_properties` varchar(255) DEFAULT NULL COMMENT '企业属性',
    `portal_prop` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='临时账户表';

-- ----------------------------
-- Table structure for manager_application
-- ----------------------------
DROP TABLE IF EXISTS `manager_application`;
CREATE TABLE `manager_application` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `application_desc` varchar(255) DEFAULT NULL COMMENT '应用描述',
    `application_icons` varchar(255) DEFAULT NULL COMMENT '应用图标',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    `pid` bigint DEFAULT NULL COMMENT '父类Id',
    `application_link` varchar(255) DEFAULT NULL COMMENT '应用链接',
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `application_code` varchar(255) DEFAULT NULL COMMENT '应用编码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='应用表';

-- ----------------------------
-- Table structure for manager_code
-- ----------------------------
DROP TABLE IF EXISTS `manager_code`;
CREATE TABLE `manager_code` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `code_name` varchar(255) DEFAULT NULL COMMENT '代码名称',
    `code_type_name` varchar(255) DEFAULT NULL COMMENT '代码类型名称',
    `code_type_value` varchar(255) DEFAULT NULL COMMENT '代码类型值',
    `code_value` varchar(255) DEFAULT NULL COMMENT '代码值',
    `code_desc` varchar(255) DEFAULT NULL COMMENT '代码描述',
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='代码表';

-- ----------------------------
-- Table structure for manager_code_type
-- ----------------------------
DROP TABLE IF EXISTS `manager_code_type`;
CREATE TABLE `manager_code_type` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `code_type_name` varchar(255) DEFAULT NULL COMMENT '代码类型名称',
    `code_type_value` varchar(255) DEFAULT NULL COMMENT '代码类型值',
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='代码类型表';

-- ----------------------------
-- Table structure for manager_department
-- ----------------------------
DROP TABLE IF EXISTS `manager_department`;
CREATE TABLE `manager_department` (
    `pid` varchar(255) DEFAULT NULL,
    `pids` varchar(255) DEFAULT NULL,
    `simple_name` varchar(255) DEFAULT NULL,
    `full_name` varchar(255) DEFAULT NULL,
    `versions` int DEFAULT NULL,
    `sort` int DEFAULT NULL,
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    `description` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Table structure for manager_files
-- ----------------------------
DROP TABLE IF EXISTS `manager_files`;
CREATE TABLE `manager_files` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(255) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(255) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int NOT NULL,
    `has_status` int NOT NULL,
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL,
    `file_name` varchar(256) DEFAULT NULL COMMENT '文件名',
    `file_remark` varchar(64) DEFAULT NULL COMMENT '文件备注',
    `path` varchar(256) DEFAULT NULL COMMENT '路径',
    `size` varchar(64) DEFAULT NULL COMMENT '文件大小',
    `type` varchar(32) DEFAULT NULL COMMENT '文件类型',
    `business_key_id` varchar(32) DEFAULT NULL COMMENT '业务键ID',
    `application_name` varchar(255) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='文件表';

-- ----------------------------
-- Table structure for manager_holidays
-- ----------------------------
DROP TABLE IF EXISTS `manager_holidays`;
CREATE TABLE `manager_holidays` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `holidays` varchar(255) DEFAULT NULL COMMENT '假期名称',
    `holidays_date` date DEFAULT NULL COMMENT '假期日期',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='节假日表';

-- ----------------------------
-- Table structure for user_job
-- ----------------------------
DROP TABLE IF EXISTS `user_job`;
CREATE TABLE `user_job` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户工作表';

-- ----------------------------
-- Table structure for user_location
-- ----------------------------
DROP TABLE IF EXISTS `user_location`;
CREATE TABLE `user_location` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `user_id` varchar(100) DEFAULT NULL,
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户位置表';

-- ----------------------------
-- Table structure for user_pic
-- ----------------------------
DROP TABLE IF EXISTS `user_pic`;
CREATE TABLE `user_pic` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `is_use` varchar(100) DEFAULT NULL,
    `pic_name` varchar(100) DEFAULT NULL,
    `pic_path` varchar(100) DEFAULT NULL,
    `use_end_time` varchar(100) DEFAULT NULL,
    `use_start_time` varchar(100) DEFAULT NULL,
    `user_id` varchar(100) DEFAULT NULL,
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户照片表';

-- ----------------------------
-- Table structure for user_professional
-- ----------------------------
DROP TABLE IF EXISTS `user_professional`;
CREATE TABLE `user_professional` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `is_use` varchar(100) DEFAULT NULL,
    `professional_name` varchar(100) DEFAULT NULL,
    `use_end_time` varchar(100) DEFAULT NULL,
    `use_start_time` varchar(100) DEFAULT NULL,
    `user_id` varchar(100) DEFAULT NULL,
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户职业表';

-- ----------------------------
-- Table structure for user_school
-- ----------------------------
DROP TABLE IF EXISTS `user_school`;
CREATE TABLE `user_school` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户学校表';

-- ----------------------------
-- Table structure for user_session
-- ----------------------------
DROP TABLE IF EXISTS `user_session`;
CREATE TABLE `user_session` (
    `browser` varchar(255) DEFAULT NULL,
    `os` varchar(255) DEFAULT NULL,
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` bigint DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `department_id` bigint DEFAULT NULL COMMENT '部门权限',
    `field_id` bigint DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(128) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `last_update_operator_id` bigint DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` bigint DEFAULT NULL COMMENT '操作员',
    `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `dept_name` varchar(255) DEFAULT NULL,
    `last_access_time` date DEFAULT NULL,
    `login_location` varchar(255) DEFAULT NULL,
    `login_name` varchar(255) DEFAULT NULL,
    `session_id` varchar(255) DEFAULT NULL,
    `ip_addr` varchar(255) DEFAULT NULL,
    `start_time_stamp` date DEFAULT NULL,
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户会话表';

-- ----------------------------
-- Table structure for manager_login_record
-- ----------------------------
DROP TABLE IF EXISTS `manager_login_record`;
CREATE TABLE `manager_login_record` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(64) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `email_code` varchar(64) DEFAULT NULL COMMENT '邮件验证码',
    `error_password` varchar(64) DEFAULT NULL COMMENT '错误密码',
    `login_browser` varchar(64) DEFAULT NULL COMMENT '登录浏览器',
    `login_ip` varchar(64) DEFAULT NULL COMMENT '登录IP',
    `login_name` varchar(64) DEFAULT NULL COMMENT '登录名',
    `login_remark` varchar(64) DEFAULT NULL COMMENT '登录备注',
    `login_src` varchar(64) DEFAULT NULL COMMENT '登录来源',
    `login_status` varchar(64) DEFAULT NULL COMMENT '登录状态',
    `login_time` date DEFAULT NULL COMMENT '登录时间',
    `phone_code` varchar(64) DEFAULT NULL COMMENT '手机验证码',
    `sign_out_time` date DEFAULT NULL COMMENT '退出时间',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='管理员登录记录';

-- ----------------------------
-- Table structure for manager_position
-- ----------------------------
DROP TABLE IF EXISTS `manager_position`;
CREATE TABLE `manager_position` (
    `position_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '岗位名称',
    `position_rank` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '岗位级别',
    `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `delete_manager` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `department_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `field_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `field_prop` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `has_delete` int NOT NULL,
    `has_status` int NOT NULL,
    `last_update_operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `operator_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `application_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='岗位信息';

-- ----------------------------
-- Table structure for manager_resource
-- ----------------------------
DROP TABLE IF EXISTS `manager_resource`;
CREATE TABLE `manager_resource` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(64) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `menu_type` varchar(64) DEFAULT NULL COMMENT '菜单类型',
    `resource_icon` varchar(64) DEFAULT NULL COMMENT '资源图标',
    `resource_link` varchar(64) DEFAULT NULL COMMENT '资源链接',
    `resource_name` varchar(64) DEFAULT NULL COMMENT '资源名称',
    `resource_order` int DEFAULT NULL COMMENT '资源排序',
    `resource_parent` varchar(64) DEFAULT NULL COMMENT '资源父级',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `open_target` varchar(64) DEFAULT NULL COMMENT '打开目标',
    `permission` varchar(64) DEFAULT NULL COMMENT '权限',
    `permission_script` varchar(64) DEFAULT NULL COMMENT '权限脚本',
    `visible` varchar(64) DEFAULT NULL COMMENT '可见性',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='管理员资源';

-- ----------------------------
-- Table structure for manager_resource_action
-- ----------------------------
DROP TABLE IF EXISTS `manager_resource_action`;
CREATE TABLE `manager_resource_action` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(64) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `resource_action_icon` varchar(64) DEFAULT NULL COMMENT '资源动作图标',
    `resource_action_method` varchar(64) DEFAULT NULL COMMENT '资源动作方法',
    `resource_action_name` varchar(64) DEFAULT NULL COMMENT '资源动作名称',
    `resource_action_order` int DEFAULT NULL COMMENT '资源动作排序',
    `resource_action_status` bit(1) DEFAULT NULL COMMENT '资源动作状态',
    `resource_id` varchar(64) DEFAULT NULL COMMENT '资源ID',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='管理员资源动作';

-- ----------------------------
-- Table structure for manager_role
-- ----------------------------
DROP TABLE IF EXISTS `manager_role`;
CREATE TABLE `manager_role` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(64) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `role_status` int DEFAULT NULL COMMENT '角色状态',
    `role_title` varchar(64) DEFAULT NULL COMMENT '角色标题',
    `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `role_desc` varchar(64) DEFAULT NULL COMMENT '角色描述',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    `default_netrole` int DEFAULT NULL COMMENT '是否默认互联网角色',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='管理员角色';

-- ----------------------------
-- Table structure for manager_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `manager_role_resource`;
CREATE TABLE `manager_role_resource` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(64) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `resource_id` varchar(64) DEFAULT NULL COMMENT '资源ID',
    `resource_type` varchar(64) DEFAULT NULL COMMENT '资源类型',
    `role_id` varchar(64) DEFAULT NULL COMMENT '角色ID',
    `role_type` varchar(64) DEFAULT NULL COMMENT '角色类型',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='管理员角色资源';

-- ----------------------------
-- Table structure for manager_search
-- ----------------------------
DROP TABLE IF EXISTS `manager_search`;
CREATE TABLE `manager_search` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(64) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(64) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `field_prop` varchar(64) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(64) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `default_value` varchar(64) DEFAULT NULL COMMENT '默认值',
    `has_date` varchar(64) DEFAULT NULL COMMENT '是否有日期',
    `option_json` varchar(64) DEFAULT NULL COMMENT '选项JSON',
    `resource_id` varchar(64) DEFAULT NULL COMMENT '资源ID',
    `search_type` varchar(64) DEFAULT NULL COMMENT '搜索类型',
    `department_id` varchar(64) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(64) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(64) DEFAULT NULL COMMENT '最后更新操作员',
    `dict` varchar(64) DEFAULT NULL COMMENT '字典',
    `search_script` varchar(64) DEFAULT NULL COMMENT '搜索脚本',
    `application_name` varchar(64) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='管理员搜索';


-- ----------------------------
-- Table structure for manager_settings
-- ----------------------------
DROP TABLE IF EXISTS `manager_settings`;
CREATE TABLE `manager_settings` (
    `config_name` varchar(100) DEFAULT NULL COMMENT '配置名称',
    `config_key` varchar(100) DEFAULT NULL COMMENT '配置键',
    `config_value` varchar(100) DEFAULT NULL COMMENT '配置值',
    `config_type` varchar(100) DEFAULT NULL COMMENT '配置类型',
    `config_remark` varchar(100) DEFAULT NULL COMMENT '配置备注',
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(100) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(100) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL,
    `department_id` varchar(100) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(100) DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `operator_id` varchar(100) DEFAULT NULL COMMENT '操作员',
    `tenant_id` varchar(100) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `last_update_operator_id` varchar(100) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='管理员设置';


-- ----------------------------
-- Table structure for manager_tenant
-- ----------------------------
DROP TABLE IF EXISTS `manager_tenant`;
CREATE TABLE `manager_tenant` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(100) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(100) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime,
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(100) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `city_id` varchar(100) DEFAULT NULL,
    `end_time` date DEFAULT NULL,
    `province_id` varchar(100) DEFAULT NULL,
    `start_time` date DEFAULT NULL,
    `tenant_account` varchar(100) DEFAULT NULL,
    `tenant_address` varchar(100) DEFAULT NULL,
    `tenant_cost` int DEFAULT NULL,
    `tenant_name` varchar(100) DEFAULT NULL,
    `tenant_phone` varchar(100) DEFAULT NULL,
    `tenant_status` varchar(100) DEFAULT NULL,
    `department_id` varchar(100) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(100) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(100) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(100) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='管理员租户';

-- ----------------------------
-- Table structure for manager_tenant_log
-- ----------------------------
DROP TABLE IF EXISTS `manager_tenant_log`;
CREATE TABLE `manager_tenant_log` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(100) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(100) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime,
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(100) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `action_type` varchar(100) DEFAULT NULL,
    `end_time` date DEFAULT NULL,
    `log_business_id` varchar(100) DEFAULT NULL,
    `log_channel` varchar(100) DEFAULT NULL,
    `log_content` varchar(100) DEFAULT NULL,
    `log_ip` varchar(100) DEFAULT NULL,
    `log_machine` varchar(100) DEFAULT NULL,
    `department_id` varchar(100) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(100) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(100) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(100) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='管理员租户日志';

-- ----------------------------
-- Table structure for manager_user
-- ----------------------------
DROP TABLE IF EXISTS `manager_user`;
CREATE TABLE `manager_user` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(100) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(100) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime,
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `tenant_id` varchar(100) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `user_account` varchar(100) DEFAULT NULL COMMENT '用户账号',
    `user_addtime` date DEFAULT NULL COMMENT '用户添加时间',
    `user_password` varchar(100) DEFAULT NULL COMMENT '用户密码',
    `user_role` varchar(100) DEFAULT NULL COMMENT '用户角色',
    `user_salt` varchar(100) DEFAULT NULL COMMENT '用户盐值',
    `user_status` bit(1) DEFAULT NULL COMMENT '用户状态',
    `user_type` bit(1) DEFAULT NULL COMMENT '用户类型',
    `user_name` varchar(100) DEFAULT NULL COMMENT '用户姓名',
    `department_id` varchar(100) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(100) DEFAULT NULL COMMENT '字段权限',
    `operator_id` varchar(100) DEFAULT NULL COMMENT '操作员',
    `last_update_operator_id` varchar(100) DEFAULT NULL COMMENT '最后更新操作员',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='管理员用户';


-- ----------------------------
-- Table structure for manager_working_calendar
-- ----------------------------
DROP TABLE IF EXISTS `manager_working_calendar`;
CREATE TABLE `manager_working_calendar` (
    `working_start_time` date DEFAULT NULL COMMENT '工作开始时间',
    `working_content` varchar(100) DEFAULT NULL COMMENT '工作内容',
    `working_end_time` date DEFAULT NULL COMMENT '工作结束时间',
    `working_type` varchar(100) DEFAULT NULL COMMENT '工作类型',
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(100) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(100) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `department_id` varchar(100) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(100) DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int DEFAULT NULL COMMENT '是否删除',
    `has_status` int DEFAULT NULL COMMENT '状态',
    `last_update_operator_id` varchar(100) DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` varchar(100) DEFAULT NULL COMMENT '操作员',
    `tenant_id` varchar(100) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `application_name` varchar(100) DEFAULT NULL COMMENT '应用名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='工作日历';

-- ----------------------------
-- Table structure for message_remind
-- ----------------------------
DROP TABLE IF EXISTS `message_remind`;
CREATE TABLE `message_remind` (
    `id` bigint NOT NULL COMMENT '主键',
    `add_time` datetime DEFAULT NULL COMMENT '添加时间',
    `application_id` varchar(100) DEFAULT NULL COMMENT '所属应用',
    `delete_manager` varchar(100) DEFAULT NULL COMMENT '删除人员',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `department_id` varchar(100) DEFAULT NULL COMMENT '部门权限',
    `field_id` varchar(100) DEFAULT NULL COMMENT '字段权限',
    `field_prop` varchar(100) DEFAULT NULL COMMENT '字段属性',
    `has_delete` int NOT NULL COMMENT '是否删除',
    `has_status` int NOT NULL COMMENT '状态',
    `last_update_operator_id` varchar(100) DEFAULT NULL COMMENT '最后更新操作员',
    `operator_id` varchar(100) DEFAULT NULL COMMENT '操作员',
    `tenant_id` varchar(100) DEFAULT NULL COMMENT '所属租户',
    `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
    `event_name` varchar(100) DEFAULT NULL COMMENT '事件名称',
    `reminder_date` datetime DEFAULT NULL COMMENT '提醒日期',
    `reminders` varchar(100) DEFAULT NULL COMMENT '提醒人',
    `warning_date` datetime DEFAULT NULL COMMENT '预警日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='消息提醒';

SET FOREIGN_KEY_CHECKS = 1;

















