package com.tmsps.fk.common.confg.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.tmsps.fk.common.base.constant.GlobalConstant;

import lombok.Data;

/**
 * 阿里云通用配置
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
@Data
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class TbProperties {
	private AliyunProperties aliyun = new AliyunProperties();
}
