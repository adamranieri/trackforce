package com.revature.config;

import java.util.Properties;

import javax.sql.DataSource;

/**
 * DataSource configurations for an injectable DataSource
 * Using principles IoC and coding to an interface
 * This uses DI to make datasources more configurable
 * and allows for ease of testing
 * @author Vaeth
 *
 */
public interface DataSourceBuilder {

	// Injectable DatasSource
	public DataSource buildDataSource(Properties props);

	public DataSource getDataSource();
	public String getUrl();
	public String getUsername();
	public String getPassword();
	
	public final class Constants {
		
		private Constants() {}
	    public static final String URL_KEY = "tf.url-env";
	    public static final String USERNAME_KEY = "tf.username-env";
	    public static final String PASS_KEY = "tf.password-env";
	}
}