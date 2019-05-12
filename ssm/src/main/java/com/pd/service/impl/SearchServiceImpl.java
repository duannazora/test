package com.pd.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.pojo.Item;
import com.pd.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	SolrClient solrClient;	
	public List<Item> findItemByKey(String key) {
		try {
			SolrQuery query = new SolrQuery(key);
			query.setStart(0);// 从那一行开始取数据
			query.setRows(20);// 取20行。
			QueryResponse response = solrClient.query(query);
			List<Item> itemList = response.getBeans(Item.class);

			return itemList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
