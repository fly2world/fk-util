package com.tmsps.fk.common.confg;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.tmsps.fk.common.confg.properties.TbProperties;

/**
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
@Configuration
@EnableConfigurationProperties(TbProperties.class)
public class TbCoreConfig {
}
