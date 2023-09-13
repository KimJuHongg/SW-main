package com.wnjd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wnjd.controller.BoardController;
import com.wnjd.controller.RestSvcController;
import com.wnjd.model.BoardDao;
import com.wnjd.model.NoticeboardDto;

import service.BoardService;

@Configuration
public class BoardConfig {
	@Bean
	public NoticeboardDto noticeboardDto() {
		return new NoticeboardDto();
	}
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao();
	}
	
	@Bean
	public BoardController boardController() {
		return new BoardController();
	}
	
	@Bean
	public BoardService boardService() {
		return new BoardService();
	}
	
	@Bean
	public RestSvcController restSvcController() {
		return new RestSvcController();
	}
}
