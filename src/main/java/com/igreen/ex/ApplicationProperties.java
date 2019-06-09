/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * ApplicationProperties for Security if passed through header.
 *
 */
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "igreen")
public class ApplicationProperties {
	
	private String apiSalt;
	
	public String getApiSalt() {
		return apiSalt;
	}
	public void setApiSalt(String apiSalt) {
		this.apiSalt = apiSalt;
	}
}
