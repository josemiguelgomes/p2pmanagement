package com.zem.p2pmanagement.entities.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.zem.p2pmanagement.entities.Client;

@Projection(name = "virtualClientFullName", types = {Client.class } )
public interface ClientFullNameProjection {

	@Value("#{target.firstName} #{target.lastName}")
	String getClientFullName();
	
}
