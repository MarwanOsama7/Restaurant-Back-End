package com.global.RestaurantManage.config;
import java.util.Optional;

import org.springframework.data.domain.AuditorAware; 


public class AuditorAwireImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.of("user test");
	}

}
