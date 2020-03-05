package org.fxd.fk.common.base.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The class Login auth dto.
 *
 * @author paascloud.net@gmail.com
 */
@Data
public class LoginAuthDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userKid;
	private String uname;

}
