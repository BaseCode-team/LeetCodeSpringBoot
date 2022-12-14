-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: leetcode
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `leet_code_problem`
--

DROP TABLE IF EXISTS `leet_code_problem`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leet_code_problem`
(
    `id`          int NOT NULL AUTO_INCREMENT COMMENT '题目id',
    `no`          varchar(10) DEFAULT NULL COMMENT '题目编号',
    `name`        varchar(25) DEFAULT NULL COMMENT '题目标题',
    `description` text COMMENT '题目描述',
    `pass_rate`   varchar(20) DEFAULT NULL COMMENT '题目通过率',
    `level`       varchar(25) DEFAULT NULL COMMENT '题目难度等级',
    `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `create_by`   bigint      DEFAULT NULL COMMENT '创建人',
    `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    `update_by`   bigint      DEFAULT NULL COMMENT '最后更新人',
    `deleted`     varchar(30) DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='力扣题目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leet_code_problem`
--

LOCK TABLES `leet_code_problem` WRITE;
/*!40000 ALTER TABLE `leet_code_problem`
    DISABLE KEYS */;
INSERT INTO `leet_code_problem`
VALUES (1, '1', '题目一', '题目一描述', '50', '3', '2022-11-05 15:48:47.000', NULL, '2022-11-05 15:49:46.000', NULL,
        '0'),
       (2, '2', '题目二', '题目二描述', '30', '2', '2022-11-05 15:50:13.000', NULL, '2022-11-05 15:50:15.000', NULL,
        '0');
/*!40000 ALTER TABLE `leet_code_problem`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leet_code_solution`
--

DROP TABLE IF EXISTS `leet_code_solution`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leet_code_solution`
(
    `id`               int NOT NULL AUTO_INCREMENT COMMENT '题解id',
    `problem_id`       varchar(10) DEFAULT NULL COMMENT '题目id',
    `problem_solution` text COMMENT '解题代码',
    `solution_author`  varchar(40) DEFAULT NULL COMMENT '解题人',
    `create_time`      datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '首次提交解题时间',
    `create_by`        bigint      DEFAULT NULL COMMENT '创建人',
    `update_time`      datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新答案时间',
    `update_by`        bigint      DEFAULT NULL COMMENT '最后更新人',
    `deleted`          varchar(30) DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='力扣题解';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leet_code_solution`
--

LOCK TABLES `leet_code_solution` WRITE;
/*!40000 ALTER TABLE `leet_code_solution`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `leet_code_solution`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role`
(
    `id`          mediumtext COMMENT '角色Id',
    `name`        varchar(25) DEFAULT NULL COMMENT '角色名称',
    `code`        varchar(25) DEFAULT NULL COMMENT '角色code',
    `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `create_by`   bigint      DEFAULT NULL COMMENT '创建人',
    `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    `update_by`   bigint      DEFAULT NULL COMMENT '最后更新人',
    `deleted`     varchar(30) DEFAULT '0'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role`
    DISABLE KEYS */;
INSERT INTO `role`
VALUES ('1', '管理员', 'admin', '2022-11-26 10:43:43.398', NULL, '2022-11-26 10:43:43.398', NULL, '0'),
       ('2', '普通用户', 'normal_user', '2022-11-26 10:43:43.410', NULL, '2022-11-26 10:43:43.410', NULL, '0'),
       ('3', '尊贵用户', 'vip_user', '2022-11-26 10:43:43.420', NULL, '2022-11-26 10:43:43.420', NULL, '0');
/*!40000 ALTER TABLE `role`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_login_log`
--

DROP TABLE IF EXISTS `t_login_log`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_login_log`
(
    `id`               bigint NOT NULL COMMENT '主键',
    `request_ip`       varchar(50)  DEFAULT '' COMMENT '登录IP',
    `user_id`          bigint       DEFAULT NULL COMMENT '登录人ID',
    `user_name`        varchar(50)  DEFAULT '' COMMENT '登录人姓名',
    `account`          varchar(30)  DEFAULT '' COMMENT '登录人账号',
    `description`      varchar(255) DEFAULT '' COMMENT '登录描述',
    `login_date`       char(10)     DEFAULT '' COMMENT '登录时间',
    `ua`               varchar(500) DEFAULT '' COMMENT '浏览器请求头',
    `browser`          varchar(255) DEFAULT '' COMMENT '浏览器名称',
    `browser_version`  varchar(255) DEFAULT '' COMMENT '浏览器版本',
    `operating_system` varchar(255) DEFAULT '' COMMENT '操作系统',
    `location`         varchar(50)  DEFAULT '' COMMENT '登录地点',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `create_by`        bigint       DEFAULT NULL COMMENT '创建人',
    `update_time`      datetime(3)  DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '最后更新时间',
    `update_by`        bigint       DEFAULT NULL COMMENT '最后更新人',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='登录日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_login_log`
--

LOCK TABLES `t_login_log` WRITE;
/*!40000 ALTER TABLE `t_login_log`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `t_login_log`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_menu`
--

DROP TABLE IF EXISTS `t_menu`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_menu`
(
    `id`            bigint      NOT NULL COMMENT 'ID',
    `label`         varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
    `resource_type` char(2)              DEFAULT NULL COMMENT '[20-菜单 60-数据];\n@Echo(api = DICTIONARY_ITEM_FEIGN_CLASS,dictType = EchoDictType.RESOURCE_TYPE)',
    `tree_grade`    int                  DEFAULT NULL COMMENT '树层级',
    `tree_path`     varchar(512)         DEFAULT NULL COMMENT '树路径',
    `describe_`     varchar(200)         DEFAULT '' COMMENT '描述',
    `is_general`    bit(1)               DEFAULT b'0' COMMENT '通用菜单 \nTrue表示无需分配所有人就可以访问的',
    `path`          varchar(255)         DEFAULT NULL COMMENT '路径',
    `component`     varchar(255)         DEFAULT '' COMMENT '组件',
    `state`         bit(1)               DEFAULT b'1' COMMENT '状态',
    `sort_value`    int                  DEFAULT '1' COMMENT '排序',
    `icon`          varchar(255)         DEFAULT '' COMMENT '菜单图标',
    `group_`        varchar(20)          DEFAULT '' COMMENT '分组',
    `data_scope`    char(2)              DEFAULT NULL COMMENT '数据范围;[01-全部 02-本单位及子级 03-本单位 04-本部门 05-本部门及子级 06-个人 07-自定义]',
    `custom_class`  varchar(255)         DEFAULT NULL COMMENT '实现类',
    `is_def`        bit(1)               DEFAULT b'0' COMMENT '是否默认',
    `parent_id`     bigint               DEFAULT '0' COMMENT '父级菜单ID',
    `readonly_`     bit(1)               DEFAULT b'0' COMMENT '内置',
    `create_by`     bigint               DEFAULT NULL COMMENT '创建人id',
    `create_time`   datetime(3)          DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `update_by`     bigint               DEFAULT NULL COMMENT '更新人id',
    `update_time`   datetime(3)          DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_path` (`path`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_menu`
--

LOCK TABLES `t_menu` WRITE;
/*!40000 ALTER TABLE `t_menu`
    DISABLE KEYS */;
INSERT INTO `t_menu`
VALUES (20, '工作台', '20', 0, ',', '', _binary '\0', '/workbench', 'Layout', _binary '', 20,
        'ant-design:dashboard-filled', '', NULL, NULL, NULL, 0, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (30, '组织管理', '20', 0, ',', '', _binary '\0', '/org', 'Layout', _binary '', 30,
        'ant-design:cluster-outlined', '', NULL, NULL, NULL, 0, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (40, '资源中心', '20', 0, ',', '', _binary '\0', '/resources', 'Layout', _binary '', 40,
        'ant-design:cloud-server-outlined', '', NULL, NULL, NULL, 0, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (50, '流程管理', '20', 0, ',', '', _binary '\0', '/activiti', 'Layout', _binary '', 50, 'tabler:chart-dots', '',
        NULL, NULL, NULL, 0, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (60, '系统设置', '20', 0, ',', '', _binary '\0', '/system', 'Layout', _binary '', 60,
        'ant-design:setting-outlined', '', NULL, NULL, NULL, 0, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (70, '网关管理', '20', 0, ',', '', _binary '\0', '/gateway', 'Layout', _binary '', 70,
        'ant-design:sliders-filled', '', NULL, NULL, NULL, 0, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (80, '开发者管理', '20', 0, ',', '', _binary '\0', '/developer', 'Layout', _binary '', 80,
        'ant-design:bug-filled', '', NULL, NULL, NULL, 0, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (100, '更多功能', '20', 0, ',', '', _binary '', '/more', 'Layout', _binary '', 100,
        'ant-design:appstore-add-outlined', '', NULL, NULL, NULL, 0, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (111, '超级用户', '20', 1, ',10,', '', _binary '\0', '/tenant/user', 'lamp/tenant/user/index', _binary '', 30,
        '', '', NULL, NULL, NULL, 10, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (112, '数据源配置', '20', 1, ',10,', '', _binary '\0', '/tenant/datasourceConfig',
        'lamp/tenant/datasourceConfig/index', _binary '', 10, '', '', NULL, NULL, NULL, 10, _binary '\0', 1,
        '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (120, '通知公告', '20', 1, ',20,', '', _binary '\0', '/workbench/notice', 'lamp/workbench/notice/index',
        _binary '', 10, '', '', NULL, NULL, NULL, 20, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (121, '待我审批', '20', 1, ',20,', '', _binary '\0', '/workbench/todo', 'lamp/workbench/todo/index', _binary '',
        20, '', '', NULL, NULL, NULL, 20, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (122, '我已审批', '20', 1, ',20,', '', _binary '\0', '/workbench/done', 'lamp/workbench/done/index', _binary '',
        30, '', '', NULL, NULL, NULL, 20, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (123, '我发起的', '20', 1, ',20,', '', _binary '\0', '/workbench/started', 'lamp/workbench/started/index',
        _binary '', 40, '', '', NULL, NULL, NULL, 20, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (130, '机构管理', '20', 1, ',30,', '', _binary '\0', '/org/org', 'lamp/org/org/index', _binary '', 10, '', '',
        NULL, NULL, NULL, 30, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (131, '岗位管理', '20', 1, ',30,', '', _binary '\0', '/org/station', 'lamp/org/station/index', _binary '', 20,
        '', '', NULL, NULL, NULL, 30, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (132, '用户管理', '20', 1, ',30,', '', _binary '\0', '/org/user', 'lamp/org/user/index', _binary '', 30, '', '',
        NULL, NULL, NULL, 30, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (140, '消息中心', '20', 1, ',40,', '', _binary '\0', '/resources/msg', 'lamp/resources/msg/index', _binary '',
        10, '', '', NULL, NULL, NULL, 40, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (141, '短信模版', '20', 1, ',40,', '', _binary '\0', '/resources/smsTemplate',
        'lamp/resources/smsTemplate/index', _binary '', 20, '', '', NULL, NULL, NULL, 40, _binary '', 1,
        '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (142, '短信中心', '20', 1, ',40,', '', _binary '\0', '/resources/sms', 'lamp/resources/sms/index', _binary '',
        30, '', '', NULL, NULL, NULL, 40, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (143, '附件管理', '20', 1, ',40,', '', _binary '\0', '/resources/attachment', 'lamp/resources/attachment/index',
        _binary '', 40, '', '', NULL, NULL, NULL, 40, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (150, '流程部署', '20', 1, ',50,', '', _binary '\0', '/activiti/deploymentManager',
        'lamp/activiti/deploymentManager/index', _binary '', 10, '', '', NULL, NULL, NULL, 50, _binary '', 1,
        '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (151, '模型管理', '20', 1, ',50,', '', _binary '\0', '/activiti/modelManager',
        'lamp/activiti/modelManager/index', _binary '', 20, '', '', NULL, NULL, NULL, 50, _binary '', 1,
        '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (152, '请假流程', '20', 1, ',50,', '', _binary '\0', '/activiti/level', 'Layout', _binary '', 30, '', '', NULL,
        NULL, NULL, 50, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (153, '请假管理', '20', 2, ',50,152,', '', _binary '\0', '/activiti/leave/instant',
        'lamp/activiti/leave/instantManager/index', _binary '', 1, '', '', NULL, NULL, NULL, 152, _binary '', 1,
        '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (154, '请假任务', '20', 2, ',50,152,', '', _binary '\0', '/activiti/leave/ruTask',
        'lamp/activiti/leave/ruTask/index', _binary '', 2, '', '', NULL, NULL, NULL, 152, _binary '', 1,
        '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (155, '报销流程', '20', 1, ',50,', '', _binary '\0', '/activiti/reimbursement', 'Layout', _binary '', 40, '',
        '', NULL, NULL, NULL, 50, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (156, '报销管理', '20', 2, ',50,155,', '', _binary '\0', '/activiti/reimbursement/instantManager',
        'lamp/activiti/reimbursement/instantManager/index', _binary '', 1, '', '', NULL, NULL, NULL, 155, _binary '',
        1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (157, '报销任务', '20', 2, ',50,155,', '', _binary '\0', '/activiti/reimbursement/ruTask',
        'lamp/activiti/reimbursement/ruTask/index', _binary '', 2, '', '', NULL, NULL, NULL, 155, _binary '', 1,
        '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (160, '菜单管理', '20', 1, ',60,', '', _binary '\0', '/system/menu', 'lamp/system/menu/index', _binary '', 10,
        '', '', NULL, NULL, NULL, 60, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (161, '角色管理', '20', 1, ',60,', '', _binary '\0', '/system/role', 'lamp/system/role/index', _binary '', 20,
        '', '', NULL, NULL, NULL, 60, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (162, '字典管理', '20', 1, ',60,', '', _binary '\0', '/system/dictionary', 'lamp/system/dictionary/index',
        _binary '', 30, '', '', NULL, NULL, NULL, 60, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (163, '地区管理', '20', 1, ',60,', '', _binary '\0', '/system/area', 'lamp/system/area/index', _binary '', 40,
        '', '', NULL, NULL, NULL, 60, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (164, '参数管理', '20', 1, ',60,', '', _binary '\0', '/system/parameter', 'lamp/system/parameter/index',
        _binary '', 50, '', '', NULL, NULL, NULL, 60, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (165, '操作日志', '20', 1, ',60,', '', _binary '\0', '/system/optLog', 'lamp/system/optLog/index', _binary '',
        60, '', '', NULL, NULL, NULL, 60, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (166, '登录日志', '20', 1, ',60,', '', _binary '\0', '/system/loginLog', 'lamp/system/loginLog/index',
        _binary '', 70, '', '', NULL, NULL, NULL, 60, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (167, '在线用户', '20', 1, ',60,', '', _binary '\0', '/system/online', 'lamp/system/online/index', _binary '',
        80, '', '', NULL, NULL, NULL, 60, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (168, '应用管理', '20', 1, ',60,', '', _binary '\0', '/system/application', 'lamp/system/application/index',
        _binary '', 90, '', '', NULL, NULL, NULL, 60, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (180, '限流规则', '20', 1, ',70,', '', _binary '\0', '/gateway/ratelimiter', 'lamp/gateway/ratelimiter/index',
        _binary '', 10, '', '', NULL, NULL, NULL, 70, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (181, '阻止访问', '20', 1, ',70,', '', _binary '\0', '/gateway/blocklist', 'lamp/gateway/blocklist/index',
        _binary '', 20, '', '', NULL, NULL, NULL, 70, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (190, '定时任务', '20', 1, ',80,', '', _binary '\0', 'http://127.0.0.1:8767/xxl-job-admin', 'Layout',
        _binary '', 10, '', '', NULL, NULL, NULL, 80, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (191, '接口文档', '20', 1, ',80,', '', _binary '\0', 'http://127.0.0.1:8760/api/gate/doc.html', 'Layout',
        _binary '', 20, '', '', NULL, NULL, NULL, 80, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (192, 'nacos', '20', 1, ',80,', '', _binary '\0', 'http://127.0.0.1:8848/nacos', 'Layout', _binary '', 30, '',
        '', NULL, NULL, NULL, 80, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (193, '服务监控', '20', 1, ',80,', '', _binary '\0', 'http://127.0.0.1:8762/lamp-monitor', 'Layout', _binary '',
        40, '', '', NULL, NULL, NULL, 80, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (194, '数据库监控', '20', 1, ',80,', '', _binary '\0', '/developer/db', 'lamp/developer/db/index', _binary '',
        50, '', '', NULL, NULL, NULL, 80, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (195, '缓存监控', '20', 1, ',80,', '', _binary '\0', 'https://github.com/junegunn/redis-stat', 'Layout',
        _binary '', 60, '', '', NULL, NULL, NULL, 80, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (196, 'zipkin监控', '20', 1, ',80,', '', _binary '\0', 'http://127.0.0.1:8772/zipkin', 'Layout', _binary '', 70,
        '', '', NULL, NULL, NULL, 80, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (197, 'SkyWalking监控', '20', 1, ',80,', '', _binary '\0', 'http://127.0.0.1:12080', 'Layout', _binary '', 80,
        '', '', NULL, NULL, NULL, 80, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (210, '在线文档', '20', 1, ',90,', '', _binary '', 'https://www.kancloud.cn/zuihou/zuihou-admin-cloud',
        'Layout', _binary '', 10, '', '', NULL, NULL, NULL, 90, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (213, '问题反馈', '20', 1, ',90,', '', _binary '', 'https://github.com/dromara/lamp-cloud/issues', 'Layout',
        _binary '', 40, '', '', NULL, NULL, NULL, 90, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (214, '更新日志', '20', 1, ',90,', '', _binary '', 'https://www.kancloud.cn/zuihou/zuihou-admin-cloud/1465302',
        'Layout', _binary '', 50, '', '', NULL, NULL, NULL, 90, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (215, '蓝图', '20', 1, ',90,', '', _binary '', 'https://www.kancloud.cn/zuihou/zuihou-admin-cloud/2003640',
        'Layout', _binary '', 60, '', '', NULL, NULL, NULL, 90, _binary '', 1, '2022-08-29 00:00:00.000', 1,
        '2022-08-29 00:00:00.000'),
       (220, '多级菜单', '20', 1, ',100,', '', _binary '', '/more/multiMenu', 'Layout', _binary '', 1, '', '', NULL,
        NULL, NULL, 100, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (221, '菜单1-1', '20', 2, ',100,220,', '', _binary '', '/more/multiMenu/menu1-1', 'Layout', _binary '', 1, '',
        '', NULL, NULL, NULL, 220, _binary '', 1, '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (222, '菜单1-1-1', '20', 3, ',100,220,221,', '', _binary '', '/more/multiMenu/menu1-1/menu1-1-1',
        'lamp/more/multiMenu/menu1-1/menu1-1-1/index', _binary '', 1, '', '', NULL, NULL, NULL, 221, _binary '', 1,
        '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (223, '菜单1-1-2', '20', 3, ',100,220,221,', '', _binary '', '/more/multiMenu/menu1-1/menu1-1-2',
        'lamp/more/multiMenu/menu1-1/menu1-1-2/index', _binary '', 2, '', '', NULL, NULL, NULL, 221, _binary '', 1,
        '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000'),
       (224, '菜单1-2', '20', 2, ',100,220,', '', _binary '', '/more/multiMenu/menu1-2',
        'lamp/more/multiMenu/menu1-2/index', _binary '', 2, '', '', NULL, NULL, NULL, 220, _binary '', 1,
        '2022-08-29 00:00:00.000', 1, '2022-08-29 00:00:00.000');
/*!40000 ALTER TABLE `t_menu`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_opt_log`
--

DROP TABLE IF EXISTS `t_opt_log`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_opt_log`
(
    `id`             bigint    NOT NULL COMMENT '主键',
    `request_ip`     varchar(50)    DEFAULT '' COMMENT '操作IP',
    `type`           varchar(5)     DEFAULT '' COMMENT '日志类型 \n#LogType{OPT:操作类型;EX:异常类型}',
    `user_name`      varchar(50)    DEFAULT '' COMMENT '操作人',
    `description`    varchar(255)   DEFAULT '' COMMENT '操作描述',
    `class_path`     varchar(255)   DEFAULT '' COMMENT '类路径',
    `action_method`  varchar(50)    DEFAULT '' COMMENT '请求方法',
    `request_uri`    varchar(50)    DEFAULT '' COMMENT '请求地址',
    `http_method`    varchar(10)    DEFAULT '' COMMENT '请求类型 \n#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}',
    `start_time`     timestamp NULL DEFAULT NULL COMMENT '开始时间',
    `finish_time`    timestamp NULL DEFAULT NULL COMMENT '完成时间',
    `consuming_time` bigint         DEFAULT NULL COMMENT '消耗时间',
    `ua`             varchar(500)   DEFAULT '' COMMENT '浏览器',
    `create_time`    datetime(3)    DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `create_by`      bigint         DEFAULT NULL COMMENT '创建人',
    `update_by`      bigint         DEFAULT NULL COMMENT '最后更新人',
    `update_time`    datetime(3)    DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '最后更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_opt_log`
--

LOCK TABLES `t_opt_log` WRITE;
/*!40000 ALTER TABLE `t_opt_log`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `t_opt_log`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_opt_log_ext`
--

DROP TABLE IF EXISTS `t_opt_log_ext`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_opt_log_ext`
(
    `id`          bigint NOT NULL COMMENT '主键',
    `params`      longtext COMMENT '请求参数',
    `result`      longtext COMMENT '返回值',
    `ex_detail`   longtext COMMENT '异常描述',
    `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `create_by`   bigint      DEFAULT NULL COMMENT '创建人',
    `update_by`   bigint      DEFAULT NULL COMMENT '最后更新人',
    `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '最后更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统日志扩展';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_opt_log_ext`
--

LOCK TABLES `t_opt_log_ext` WRITE;
/*!40000 ALTER TABLE `t_opt_log_ext`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `t_opt_log_ext`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_resource`
--

DROP TABLE IF EXISTS `t_resource`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_resource`
(
    `id`          bigint       NOT NULL COMMENT 'ID',
    `code`        varchar(500)          DEFAULT '' COMMENT '编码',
    `name`        varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
    `menu_id`     bigint                DEFAULT NULL COMMENT '菜单\n#t_menu',
    `describe_`   varchar(255)          DEFAULT '' COMMENT '描述',
    `readonly_`   bit(1)                DEFAULT b'1' COMMENT '内置',
    `create_by`   bigint                DEFAULT NULL COMMENT '创建人id',
    `create_time` datetime(3)           DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `update_by`   bigint                DEFAULT NULL COMMENT '更新人id',
    `update_time` datetime(3)           DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_res_code` (`code`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='资源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_resource`
--

LOCK TABLES `t_resource` WRITE;
/*!40000 ALTER TABLE `t_resource`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `t_resource`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role_authority`
--

DROP TABLE IF EXISTS `t_role_authority`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_role_authority`
(
    `id`             bigint      NOT NULL COMMENT '主键',
    `authority_id`   bigint      NOT NULL COMMENT '资源id \n#t_resource #t_menu',
    `authority_type` varchar(10) NOT NULL COMMENT '权限类型 \n#AuthorizeType{MENU:菜单;RESOURCE:资源;}',
    `role_id`        bigint      NOT NULL COMMENT '角色id \n#t_role',
    `create_time`    datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `create_by`      bigint      DEFAULT NULL COMMENT '创建人',
    `update_time`    datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '最后更新时间',
    `update_by`      bigint      DEFAULT NULL COMMENT '最后更新人',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_role_authority` (`authority_id`, `authority_type`, `role_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色的资源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_authority`
--

LOCK TABLES `t_role_authority` WRITE;
/*!40000 ALTER TABLE `t_role_authority`
    DISABLE KEYS */;
INSERT INTO `t_role_authority`
VALUES (1, 220, 'MENU', 1, '2022-12-12 16:52:15.092', 1, '2022-12-13 17:39:59.465', NULL);
/*!40000 ALTER TABLE `t_role_authority`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user_role`
(
    `id`          bigint NOT NULL COMMENT 'ID',
    `role_id`     bigint NOT NULL COMMENT '角色\n#c_role',
    `user_id`     bigint NOT NULL COMMENT '用户\n#c_user',
    `create_by`   bigint      DEFAULT NULL COMMENT '创建人ID',
    `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '最后更新时间',
    `update_by`   bigint      DEFAULT NULL COMMENT '最后更新人',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_user_role` (`role_id`, `user_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色分配\n账号角色绑定';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_role`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user`
(
    `id`          bigint      DEFAULT NULL COMMENT '主键id',
    `user_name`   varchar(25) DEFAULT NULL COMMENT '用户名',
    `real_name`   varchar(25) DEFAULT NULL COMMENT '真实2姓名',
    `phone`       varchar(11) DEFAULT NULL COMMENT '手机号',
    `password`    varchar(25) DEFAULT NULL COMMENT '密码',
    `role_ids`    varchar(40) DEFAULT NULL COMMENT '关联角色id列表',
    `province`    varchar(10) DEFAULT NULL COMMENT '省份',
    `city`        varchar(10) DEFAULT NULL COMMENT '市',
    `county`      varchar(10) DEFAULT NULL COMMENT '区',
    `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `create_by`   bigint      DEFAULT NULL COMMENT '创建者',
    `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    `update_by`   bigint      DEFAULT NULL COMMENT '最后更新人',
    `deleted`     varchar(30) DEFAULT '0' COMMENT '是否删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user`
    DISABLE KEYS */;
INSERT INTO `user`
VALUES (1595303332723654657, 'test', '456', '13100000001', 'asdasdqwe', '1', '123', '123', '123',
        '2022-11-23 14:28:48.510', NULL, '2022-12-14 13:39:00.118', 1596340874801963010, '0'),
       (1595979978342486017, 'test', '456', '13100000001', 'asdasdqwe', '1', '123', '123', '123',
        '2022-11-25 11:17:33.394', NULL, '2022-12-13 18:24:54.452', NULL, '2022-12-13 18:24:54'),
       (1596340874801963010, '1234', '123', '123', '123', '1', '123', '123', '123', '2022-11-26 11:11:37.806', NULL,
        '2022-11-26 11:11:37.806', NULL, '0'),
       (1596534928391053313, 'test', '456', '13100000001', 'asdasdqwe', '1', '123', '123', '123',
        '2022-11-27 00:02:43.773', NULL, '2022-11-27 00:25:58.212', NULL, '2022-11-27 00:25:58');
/*!40000 ALTER TABLE `user`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2022-12-15  0:26:34
