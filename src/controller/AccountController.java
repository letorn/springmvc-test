package controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Account;
import service.AccountService;

@Controller
@RequestMapping("account/")
public class AccountController {

	@Resource
	private AccountService accountService;

	@RequestMapping("account.do")
	@ResponseBody
	public Map<String, Object> account(String name) {
		new Thread() {    //A
            public void run() {
            	StringBuilder sb = new StringBuilder();
            	while (true) {
            		for (int i = 0; i < 1000000; i ++) {
                        sb.append("aaaaa");
                    }
            		sb = new StringBuilder();
            	}
            }
        }.start();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Account account = accountService.getAccountByName(name);
		dataMap.put("id", account.getId());
		dataMap.put("name", account.getName());
		dataMap.put("password", account.getPassword());
		return dataMap;
	}

	public static class TestThread implements Runnable {

		public void run() {
			while (true) {
        		
        	}
		}
		
	}
	
}
