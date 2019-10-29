package com.cristianruizblog.loginSecurity.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public  @Data @AllArgsConstructor @NoArgsConstructor class Item {
	
	
	private Producto producto;
	private int cantidad;

}
