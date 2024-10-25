package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class EventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");

		BoardService svc = new BoardServiceImpl();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = "";
		String job = req.getParameter("job");

		if (job.equals("list")) { // 목록
			
			List<Map<String, Object>> result = svc.selectEvent();
			json = gson.toJson(result);

			// 웹브라우저에 출력
			resp.getWriter().print(json);

		} else if (job.equals("add")) {// 등록
			String title = req.getParameter("title");
			String start = req.getParameter("start");
			String end = req.getParameter("end");

			Map<String, String> map = new HashMap<>();
			map.put("title", title);
			map.put("start", start);
			map.put("end", end);

			Map<String, Object> result = new HashMap<String, Object>();
			try {
				if (svc.registerEvent(map)) { // {"retCode":"OK"}
					result.put("retCode", "OK");
					result.put("result", map);
				}
			} catch (Exception e) {
				e.printStackTrace();
				result.put("retCode", "FAIL");
			}
			
			
			resp.getWriter().print(gson.toJson(result));
		} else if(job.equals("del")) {//삭제
			String title = req.getParameter("title");
			String start = req.getParameter("start");
			String end = req.getParameter("end");

			Map<String, String> map = new HashMap<>();
			map.put("title", title);
			map.put("start", start);
			map.put("end", end);

			Map<String, Object> result = new HashMap<String, Object>();
			try {
				if (svc.deleteEvent(map)) { // {"retCode":"OK"}
					result.put("retCode", "OK");
					result.put("result", map);
				}
			} catch (Exception e) {
				e.printStackTrace();
				result.put("retCode", "FAIL");
			}
			
			
			resp.getWriter().print(gson.toJson(result));
		}

	}

}
