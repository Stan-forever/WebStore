/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : mybatistest

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2021-11-22 19:49:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `Name` varchar(255) DEFAULT NULL COMMENT '客户名称',
  `Mobile` varchar(255) DEFAULT NULL COMMENT '客户联系电话',
  `Address` varchar(255) DEFAULT NULL COMMENT '客户通讯地址',
  `Points` int(255) DEFAULT NULL COMMENT '积分消费一元一个积分',
  `Level` int(255) DEFAULT NULL COMMENT '等级 1 是青铜 （1000积分及以下），2是白银（1000积分到5000积分），3是黄金（5000积分到1000积分），4铂金（10000积分到30000万），5钻石（30000以上）  ',
  `PetsNumber` int(255) DEFAULT NULL COMMENT '宠物数量',
  `Money` float DEFAULT NULL COMMENT '余额',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `CreateUser` varchar(255) DEFAULT NULL COMMENT '创建人',
  `UpdateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `UpdateUser` varchar(255) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '徐俊生', '11', '福州', '21', '1', '1', '500', '2021-09-29 15:39:46', 'xjs', '2021-09-29 15:39:56', 'xjs');
INSERT INTO `customer` VALUES ('2', '两轮了', '11', '11', '2', '1', '1', '1', '2021-11-04 19:19:46', '1', '2021-09-27 19:19:52', '11');
INSERT INTO `customer` VALUES ('3', 'test', '15959403041', '福建', '0', '0', '1', '100', '2021-10-04 09:32:25', null, '2021-10-04 09:32:25', null);

-- ----------------------------
-- Table structure for smbms_address
-- ----------------------------
DROP TABLE IF EXISTS `smbms_address`;
CREATE TABLE `smbms_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `contact` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系人姓名',
  `addressDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '收货地址明细',
  `postCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮编',
  `tel` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系人电话',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '修改者',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_address
-- ----------------------------
INSERT INTO `smbms_address` VALUES ('1', '王丽', '北京市东城区东交民巷44号', '100010', '13678789999', '1', '2016-04-13 00:00:00', null, null, '1');
INSERT INTO `smbms_address` VALUES ('2', '张红丽', '北京市海淀区丹棱街3号', '100000', '18567672312', '1', '2016-04-13 00:00:00', null, null, '1');
INSERT INTO `smbms_address` VALUES ('3', '任志强', '北京市东城区美术馆后街23号', '100021', '13387906742', '1', '2016-04-13 00:00:00', null, null, '1');
INSERT INTO `smbms_address` VALUES ('4', '曹颖', '北京市朝阳区朝阳门南大街14号', '100053', '13568902323', '1', '2016-04-13 00:00:00', null, null, '2');
INSERT INTO `smbms_address` VALUES ('5', '李慧', '北京市西城区三里河路南三巷3号', '100032', '18032356666', '1', '2016-04-13 00:00:00', null, null, '3');
INSERT INTO `smbms_address` VALUES ('6', '王国强', '北京市顺义区高丽营镇金马工业区18号', '100061', '13787882222', '1', '2016-04-13 00:00:00', null, null, '3');

-- ----------------------------
-- Table structure for smbms_bill
-- ----------------------------
DROP TABLE IF EXISTS `smbms_bill`;
CREATE TABLE `smbms_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `billCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '账单编码',
  `productName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `productDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品描述',
  `productUnit` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品单位',
  `productCount` decimal(20,2) DEFAULT NULL COMMENT '商品数量',
  `totalPrice` decimal(20,2) DEFAULT NULL COMMENT '商品总额',
  `isPayment` int(10) DEFAULT NULL COMMENT '是否支付（1：未支付 2：已支付）',
  `createdBy` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者（userId）',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `providerId` bigint(20) DEFAULT NULL COMMENT '供应商ID',
  `isdelete` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_bill
-- ----------------------------
INSERT INTO `smbms_bill` VALUES ('1', 'BILL2016_001', '洗发水护发素', '日用品-洗发、护发', '瓶', '500.00', '25000.00', '2', '1', '2014-12-14 13:02:03', null, null, '13', '0');
INSERT INTO `smbms_bill` VALUES ('2', 'BILL2016_002', '香皂肥皂药皂', '日用品-皂类', '块', '1000.00', '10000.00', '2', '1', '2016-03-23 04:20:40', null, null, '13', '0');
INSERT INTO `smbms_bill` VALUES ('3', 'BILL2016_003', '大豆油', '食品-食用油', '斤', '300.00', '5890.00', '2', '1', '2014-12-14 13:02:03', null, null, '6', '0');
INSERT INTO `smbms_bill` VALUES ('4', 'BILL2016_004', '橄榄油', '食品-进口食用油', '斤', '200.00', '9800.00', '2', '1', '2013-10-10 03:12:13', null, null, '7', '0');
INSERT INTO `smbms_bill` VALUES ('5', 'BILL2016_005', '洗洁精', '日用品-厨房清洁', '瓶', '500.00', '7000.00', '2', '1', '2014-12-14 13:02:03', null, null, '9', '0');
INSERT INTO `smbms_bill` VALUES ('6', 'BILL2016_006', '美国大杏仁', '食品-坚果', '袋', '300.00', '5000.00', '2', '1', '2016-04-14 06:08:09', null, null, '4', '0');
INSERT INTO `smbms_bill` VALUES ('7', 'BILL2016_007', '沐浴液精油', '日用品-沐浴类', '瓶', '500.00', '23000.00', '1', '1', '2016-07-22 10:10:22', null, null, '14', '0');
INSERT INTO `smbms_bill` VALUES ('8', 'BILL2016_008', '不锈钢盘碗', '日用品-厨房用具', '个', '600.00', '6000.00', '2', '1', '2016-04-14 05:12:13', null, null, '14', '0');
INSERT INTO `smbms_bill` VALUES ('9', 'BILL2016_009', '塑料杯', '日用品-杯子', '个', '350.00', '1750.00', '2', '1', '2016-02-04 11:40:20', null, null, '14', '0');
INSERT INTO `smbms_bill` VALUES ('10', 'BILL2016_010', '豆瓣酱', '食品-调料', '瓶', '200.00', '2000.00', '2', '1', '2013-10-29 05:07:03', null, null, '8', '0');
INSERT INTO `smbms_bill` VALUES ('11', 'BILL2016_011', '海之蓝test', '饮料-国酒', '瓶', '50.00', '10000.00', '1', '1', '2016-04-14 16:16:00', null, null, '1', '0');
INSERT INTO `smbms_bill` VALUES ('12', 'BILL2016_012', '芝华士', '饮料-洋酒', '瓶', '20.00', '6000.00', '1', '1', '2016-09-09 17:00:00', null, null, '1', '0');
INSERT INTO `smbms_bill` VALUES ('13', 'BILL2016_013', '长城红葡萄酒', '饮料-红酒', '瓶', '60.00', '800.00', '2', '1', '2016-11-14 15:23:00', null, null, '1', '0');
INSERT INTO `smbms_bill` VALUES ('14', 'BILL2016_014', '泰国香米', '食品-大米', '斤', '400.00', '5000.00', '2', '1', '2016-10-09 15:20:00', null, null, '3', '0');
INSERT INTO `smbms_bill` VALUES ('15', 'BILL2016_015', '东北大米', '食品-大米', '斤', '600.00', '4000.00', '2', '1', '2016-11-14 14:00:00', null, null, '3', '0');
INSERT INTO `smbms_bill` VALUES ('16', 'BILL2016_016', '可口可乐', '饮料', '瓶', '2000.00', '6000.00', '2', '1', '2012-03-27 13:03:01', null, null, '2', '0');
INSERT INTO `smbms_bill` VALUES ('17', 'BILL2016_017', '脉动', '饮料', '瓶', '1500.00', '4500.00', '2', '1', '2016-05-10 12:00:00', null, null, '2', '0');
INSERT INTO `smbms_bill` VALUES ('18', 'BILL2016_018', '哇哈哈test', '饮料', '瓶', '2000.00', '4000.00', '2', '1', '2015-11-24 15:12:03', null, null, '2', '1');
INSERT INTO `smbms_bill` VALUES ('24', '23', '书包', '鼠标', '1', '1.00', '1.00', '2', 'admin', '2021-10-9 10:59:32', null, null, '6', '1');

-- ----------------------------
-- Table structure for smbms_code
-- ----------------------------
DROP TABLE IF EXISTS `smbms_code`;
CREATE TABLE `smbms_code` (
  `number` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_code
-- ----------------------------
INSERT INTO `smbms_code` VALUES ('13111111111', null, null, null);
INSERT INTO `smbms_code` VALUES ('13106611111', null, null, null);

-- ----------------------------
-- Table structure for smbms_provider
-- ----------------------------
DROP TABLE IF EXISTS `smbms_provider`;
CREATE TABLE `smbms_provider` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `proCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商编码',
  `proName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商名称',
  `proDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商详细描述',
  `proContact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商联系人',
  `proPhone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `proAddress` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `proFax` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '传真',
  `createdBy` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者（userId）',
  `isdelete` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_provider
-- ----------------------------
INSERT INTO `smbms_provider` VALUES ('1', 'BJ_GYS001', '北京三木堂商贸有限公司', '长期合作伙伴，主营产品:茅台、五粮液、郎酒、酒鬼酒、泸州老窖、赖茅酒、法国红酒等', '张国强', '13566667777', '北京市丰台区育芳园北路test', '010-5885878', '1', '2013-03-21 16:52:07', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('2', 'HB_GYS001', '石家庄帅益食品贸易有限公司', '长期合作伙伴，主营产品:饮料、水饮料、植物蛋白饮料、休闲食品、果汁饮料、功能饮料等', '王军', '13309094212', '河北省石家庄新华区', '0311-67738876', '1', '2016-04-13 04:20:40', '2021-04-27 18:00:35', '1', '0');
INSERT INTO `smbms_provider` VALUES ('3', 'GZ_GYS001test', '深圳市泰香米业有限公司', '初次合作伙伴，主营产品：良记金轮米,龙轮香米等', '郑程瀚', '13402013312', '广东省深圳市福田区深南大道6006华丰大厦', '0755-67776212', '1', '2014-03-21 16:56:07', '2021-04-27 18:03:27', '1', '0');
INSERT INTO `smbms_provider` VALUES ('4', 'GZ_GYS002', '深圳市喜来客商贸有限公司', '长期合作伙伴，主营产品：坚果炒货.果脯蜜饯.天然花茶.营养豆豆.特色美食.进口食品.海味零食.肉脯肉', '林妮', '18599897645', '广东省深圳市福龙工业区B2栋3楼西', '0755-67772341', '1', '2013-03-22 16:52:07', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('5', 'JS_GYS001', '兴化佳美调味品厂', '长期合作伙伴，主营产品：天然香辛料、鸡精、复合调味料', '徐国洋', '13754444221', '江苏省兴化市林湖工业区', '0523-21299098', '1', '2015-11-22 16:52:07', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('6', 'BJ_GYS002', '北京纳福尔食用油有限公司', '长期合作伙伴，主营产品：山茶油、大豆油、花生油、橄榄油等', '马莺', '13422235678', '北京市朝阳区珠江帝景1号楼', '010-588634233', '1', '2012-03-21 17:52:07', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('7', 'BJ_GYS003', '北京国粮食用油有限公司', '初次合作伙伴，主营产品：花生油、大豆油、小磨油等', '王驰', '13344441135', '北京大兴青云店开发区', '010-588134111', '1', '2016-04-13 00:00:00', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('8', 'ZJ_GYS001', '慈溪市广和绿色食品厂', '长期合作伙伴，主营产品：豆瓣酱、黄豆酱、甜面酱，辣椒，大蒜等农产品', '薛圣丹', '18099953223', '浙江省宁波市慈溪周巷小安村', '0574-34449090', '1', '2013-11-21 06:02:07', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('9', 'GX_GYS001', '优百商贸有限公司', '长期合作伙伴，主营产品：日化产品', '李立国', '13323566543', '广西南宁市秀厢大道42-1号', '0771-98861134', '1', '2013-03-21 19:52:07', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('10', 'JS_GYS002', '南京火头军信息技术有限公司', '长期合作伙伴，主营产品：不锈钢厨具等', '陈女士', '13098992113', '江苏省南京市浦口区浦口大道1号新城总部大厦A座903室', '025-86223345', '1', '2013-03-25 16:52:07', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('11', 'GZ_GYS003', '广州市白云区美星五金制品厂', '长期合作伙伴，主营产品：海绵床垫、坐垫、靠垫、海绵枕头、头枕等', '梁天', '13562276775', '广州市白云区钟落潭镇福龙路20号', '020-85542231', '1', '2016-12-21 06:12:17', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('12', 'BJ_GYS004', '北京隆盛日化科技', '长期合作伙伴，主营产品：日化环保清洗剂，家居洗涤专卖、洗涤用品网、墙体除霉剂、墙面霉菌清除剂等', '孙欣', '13689865678', '北京市大兴区旧宫', '010-35576786', '1', '2014-11-21 12:51:11', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('13', 'SD_GYS001', '山东豪克华光联合发展有限公司', '长期合作伙伴，主营产品：洗衣皂、洗衣粉、洗衣液、洗洁精、消杀类、香皂等', '吴洪转', '13245468787', '山东济阳济北工业区仁和街21号', '0531-53362445', '1', '2015-01-28 10:52:07', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('14', 'JS_GYS003', '无锡喜源坤商行', '长期合作伙伴，主营产品：日化品批销', '周一清', '18567674532', '江苏无锡盛岸西路', '0510-32274422', '1', '2016-04-23 11:11:11', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('15', 'ZJ_GYS002', '乐摆日用品厂', '长期合作伙伴，主营产品：各种中、高档塑料杯，塑料乐扣水杯（密封杯）、保鲜杯（保鲜盒）、广告杯、礼品杯', '王世杰', '13212331567', '浙江省金华市义乌市义东路', '0579-34452321', '1', '2016-08-22 10:01:30', null, null, '0');
INSERT INTO `smbms_provider` VALUES ('17', '007', '可乐', '1', '徐', '1', '', '1', 'admin', '2021-10-09 11:03:40', null, null, '0');

-- ----------------------------
-- Table structure for smbms_role
-- ----------------------------
DROP TABLE IF EXISTS `smbms_role`;
CREATE TABLE `smbms_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `roleCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色编码',
  `roleName` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '修改者',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_role
-- ----------------------------
INSERT INTO `smbms_role` VALUES ('1', 'SMBMS_ADMIN', '系统管理员', '1', '2016-04-13 00:00:00', null, null);
INSERT INTO `smbms_role` VALUES ('2', 'SMBMS_MANAGER', '经理', '1', '2016-04-13 00:00:00', null, null);
INSERT INTO `smbms_role` VALUES ('3', 'SMBMS_EMPLOYEE', '普通员工', '1', '2016-04-13 00:00:00', null, null);

-- ----------------------------
-- Table structure for smbms_user
-- ----------------------------
DROP TABLE IF EXISTS `smbms_user`;
CREATE TABLE `smbms_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userCode` varchar(15) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户编码',
  `userName` varchar(15) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名称',
  `userPassword` varchar(15) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户密码',
  `sex` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '性别（1:女、 2:男）',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '地址',
  `userRole` bigint(20) NOT NULL COMMENT '用户角色（取自角色表-角色id）',
  `createdBy` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `modifyBy` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新者（userId）',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `photo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '照片',
  `age` int(255) NOT NULL,
  `isdelete` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_user
-- ----------------------------
INSERT INTO `smbms_user` VALUES ('1', 'admin', '系统管理员', '123', '男', '1983-10-10', '13688889999', '北京市海淀区成府路207号', '1', '1', '2013-03-21 16:52:07', null, null, null, '38', '0');
INSERT INTO `smbms_user` VALUES ('2', 'liming', '李明', '123', '男', '1983-12-10', '13688884457', '北京市东城区前门东大街9号', '2', '1', '2014-12-31 19:52:09', '1', '2021-04-27 22:01:52', null, '38', '0');
INSERT INTO `smbms_user` VALUES ('5', 'hanlubiao', '韩路彪', '0000000', '女', '1984-06-05', '18567542321', '北京市朝阳区北辰中心12号', '2', '1', '2014-12-31 19:52:09', null, null, null, '37', '0');
INSERT INTO `smbms_user` VALUES ('6', 'zhanghua', '张华', '0000000', '男', '1983-06-15', '13544561111', '北京市海淀区学院路61号', '3', '1', '2013-02-11 10:51:17', null, null, null, '38', '0');
INSERT INTO `smbms_user` VALUES ('7', 'wangyang', '王洋', '0000000', '女', '1982-12-31', '13444561124', '北京市海淀区西二旗辉煌国际16层', '3', '1', '2014-06-11 19:09:07', null, null, null, '39', '0');
INSERT INTO `smbms_user` VALUES ('8', 'zhaoyan', '赵燕', '0000000', '女', '1986-03-07', '18098764545', '北京市海淀区回龙观小区10号楼', '3', '1', '2016-04-21 13:54:07', null, null, null, '35', '0');
INSERT INTO `smbms_user` VALUES ('10', 'sunlei', '孙磊', '0000000', '男', '1981-01-04', '13387676765', '北京市朝阳区管庄新月小区12楼', '3', '1', '2015-05-06 10:52:07', null, null, null, '40', '0');
INSERT INTO `smbms_user` VALUES ('11', 'sunxing', '孙兴', '0000000', '男', '1978-03-12', '13367890900', '北京市朝阳区建国门南大街10号', '3', '1', '2016-11-09 16:51:17', null, null, null, '43', '0');
INSERT INTO `smbms_user` VALUES ('12', 'zhangchen', '张晨', '0000000', '女', '1986-03-28', '18098765434', '朝阳区管庄路口北柏林爱乐三期13号楼', '3', '1', '2016-08-09 05:52:37', '1', '2016-04-14 14:15:36', null, '35', '0');
INSERT INTO `smbms_user` VALUES ('13', 'dengchao', '邓超test', '0000000', '女', '1981-11-04', '13689674534', '北京市海淀区北航家属院10号楼', '3', '1', '2016-07-11 08:02:47', 'admin', '2021-10-09 15:25:53', null, '40', '0');
INSERT INTO `smbms_user` VALUES ('14', 'yangguo', '杨过', '123', '男', '1980-01-01', '13388886623', '北京市朝阳区北苑家园茉莉园20号楼', '3', '1', '2015-02-01 03:52:07', null, null, null, '41', '0');
INSERT INTO `smbms_user` VALUES ('15', 'zhaomin', '赵敏', '123', '女', '1987-12-04', '18099897656', '北京市昌平区天通苑3区12号楼', '1', '1', '2015-09-12 12:02:12', '1', '2021-04-27 18:00:12', null, '34', '0');
INSERT INTO `smbms_user` VALUES ('23', 'xujunsheng', '徐俊生', '123', '男', null, '1', '福建', '3', 'admin', null, null, null, null, '10', '0');
INSERT INTO `smbms_user` VALUES ('24', '008', 'test', '1', '男', null, '1', '福建', '1', 'admin', null, null, null, null, '1', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '徐俊生', '女', '11', '21', '123456', 'test', '0', 'http://localhost:8080/uploads/6e0159f41b8a441f959daed6e6e13c75_test.jpg');
INSERT INTO `user` VALUES ('2', 'xujunsheng', '男', '123', '18', '123', '莆田', '1', null);
INSERT INTO `user` VALUES ('3', '酷酷酷', '女', '33', '15', '233', '福建', '0', null);
INSERT INTO `user` VALUES ('4', '健康卡', '女', '88', '30', '456', '抚州', '0', null);
INSERT INTO `user` VALUES ('5', '两轮了', '女', '7799', '18', '123', '建湖县', '0', null);
INSERT INTO `user` VALUES ('6', '这地方', '男', '31208', '21', '789', '南平', '0', null);
INSERT INTO `user` VALUES ('7', '规划局', '男', '777', '15', '999', '北京', '1', null);
INSERT INTO `user` VALUES ('8', '哦啦啦', '男', '3', '26', '777', '贵州', '0', null);
INSERT INTO `user` VALUES ('9', '去哦哦', '男', '999', '30', '666', '西北', '1', null);
INSERT INTO `user` VALUES ('10', '顶顶顶', '男', '1013', '23', '111', '泉州', '0', null);
INSERT INTO `user` VALUES ('11', '徐徐', '女', '1112', '20', '456', '三明', '0', null);
INSERT INTO `user` VALUES ('12', '嘎嘎嘎', '男', '121', '24', '789', '广州', '0', null);
INSERT INTO `user` VALUES ('13', '在这种', '男', '1317', '21', '123', '浙江', '1', null);
INSERT INTO `user` VALUES ('14', '小苏', '男', '1418', '22', '456', '重庆', '1', null);
INSERT INTO `user` VALUES ('15', '小武', '女', '1519', '18', '789', '武汉', '1', null);
INSERT INTO `user` VALUES ('16', '小夏', '男', '123456', '24', '789', '福建', '1', null);
INSERT INTO `user` VALUES ('25', 'test', '男', 'e10adc3949ba59abbe56e057f20f883e', '18', '15959403041', '莆田', '1', null);
