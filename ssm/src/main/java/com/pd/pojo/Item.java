package com.pd.pojo;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

public class Item implements Serializable
{
	//来之solr中的id field
	@Field("id")
	private Long id;
	@Field("title")
	private String title;
	@Field("sellPoint")
	private String sellPoint;
	@Field("price")
	private Long price;
	
	@Field("image")
	private String image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
}
