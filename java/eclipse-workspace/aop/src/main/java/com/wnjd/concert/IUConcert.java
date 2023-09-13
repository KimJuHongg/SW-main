package com.wnjd.concert;

import org.springframework.stereotype.Component;

@Component("iuConcert")
public class IUConcert implements Performance {
	@Override
	public void perform() throws Exception {
		throw new Exception();
	}
}
