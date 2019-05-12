package com.pd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pd.pojo.Item;
import com.pd.service.SearchService;

@Controller
public class SearchController {
	@Autowired
	SearchService searchService;
	
	@RequestMapping("/search/toSearch.html")
	public String search(String key,Model model) 
			throws Exception
	{
		
		List<Item> itemList=
				searchService.findItemByKey(key);
		model.addAttribute("list", itemList);
		//转发到search.jsp
		return "/search.jsp";
	}

}