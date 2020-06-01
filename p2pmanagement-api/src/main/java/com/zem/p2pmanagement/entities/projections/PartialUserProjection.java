package com.zem.p2pmanagement.entities.projections;

import org.springframework.data.rest.core.config.Projection;

import com.zem.p2pmanagement.entities.User;

@Projection(name = "partialUser", types = {User.class } )
public interface PartialUserProjection {

	String getLastName();
}
