package com.yedam.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class AppTest {
	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<>();
		map.put("title", "test");
		map.put("start", "2024-10-05");
		map.put("end", "2024-10-06");
		//사용자별 게시글 test.
		BoardService svc = new BoardServiceImpl();
		svc.registerEvent(map);
		
		System.out.println("done");
		
		
		
		
				
	}
}
