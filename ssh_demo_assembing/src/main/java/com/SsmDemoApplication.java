package com;

import com.filter.YLHttpRequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author ouyangyufeng
 */
@SpringBootApplication
public class SsmDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsmDemoApplication.class, args);
	}


	/**
	 * 过滤器注入
	 *
	 * @return
	 */
	@Bean
	public YLHttpRequestFilter ylHttpRequestFilter() {
		return new YLHttpRequestFilter();
	}
}
