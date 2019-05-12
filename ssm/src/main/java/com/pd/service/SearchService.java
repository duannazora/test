package com.pd.service;

import java.util.List;

import com.pd.pojo.Item;

public interface SearchService {
	public List<Item> findItemByKey(String key);
}