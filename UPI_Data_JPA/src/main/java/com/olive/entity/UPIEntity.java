package com.olive.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "UPI_DATA")
public class UPIEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vid;
	
	private String name;
	
	private String addr;
	
	private String logo;
	
	private String url;
	
	private String code;
	
	private String ki;
	
	private String keyValue;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	
	

}
