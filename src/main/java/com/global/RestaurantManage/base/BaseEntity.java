package com.global.RestaurantManage.base;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
public abstract class BaseEntity {
	
	@CreatedBy
	private String CreateBy;
	@CreatedDate
	private LocalDateTime CreatedDate;
	@LastModifiedBy
	private String modifiedBy;
	@LastModifiedDate
	private LocalDateTime modifiedDate;
}
