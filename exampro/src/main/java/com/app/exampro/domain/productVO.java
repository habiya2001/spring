//클래스명은 테이블명+VO
package com.app.exampro.domain;

import org.springframework.stereotype.Component;

//해당클래스를 객체로 선언
//lombok를 추가하면 setter와 getter, 생성자를 생략가능

@Component
public class productVO {
	//해당테이블의 필드명으로 변수선언
	private int num;
	private String product;
	private String content;
	private int price;
	private int quantity;
	private String company;
	private String image;
	//getter와 setter 생성
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	//생성자
	public productVO() {
		super();
	}
	public productVO(int num, String product, String content, int price, int quantity, String company, String image) {
		super();
		this.num = num;
		this.product = product;
		this.content = content;
		this.price = price;
		this.quantity = quantity;
		this.company = company;
		this.image = image;
	}
	
}
