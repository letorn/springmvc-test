package controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Role;
import service.RoleService;

@Controller
@RequestMapping("role/")
public class RoleController {

	@Resource
	private RoleService roleService;

	@RequestMapping("role.do")
	@ResponseBody
	public Map<String, Object> role(Integer id) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Role role = roleService.get(id);
		if (role != null) {
			dataMap.put("success", true);
			dataMap.put("id", role.getId());
			dataMap.put("name", role.getName());	
		} else {
			dataMap.put("success", false);
		}
		return dataMap;
	}

}
