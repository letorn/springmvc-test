package controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Pager;
import pojo.User;
import service.UserService;

@Controller
@RequestMapping("user/")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("page.do")
	@ResponseBody
	public Map<String, Object> page(Integer start, Integer limit) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Pager<User> pager = userService.page(start, limit);
		dataMap.put("total", pager.getTotal());
		dataMap.put("list", pager.getRows());
		return dataMap;
	}

}
