package org.fxd.fk.common.confg;

import org.fxd.fk.common.confg.properties.TbProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
@Configuration
@EnableConfigurationProperties(TbProperties.class)
public class TbCoreConfig {
}
