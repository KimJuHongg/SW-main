package com.wnjd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.wnjd.concert.Audience;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan(basePackages = {"com.wnjd.concert"})
public class ConcertConfig {
	@Bean
	public Audience audience() {
		return new Audience();
	}
}
