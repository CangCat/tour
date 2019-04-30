package cn.team.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "web")
public class MyConfig{

    /**
     * 版本
     */
    private String version;
    /**
     * 上传文件路径
     */
    private  String profile;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public  String getProfile() {
		return profile;
	}
	public  void setProfile(String profile) {
		this.profile = profile;
	}


}
