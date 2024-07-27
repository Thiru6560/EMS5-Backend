package com.ems.service;

import org.springframework.stereotype.Component;

import com.ems.dto.LatLon;

@Component
public interface LocationFindServ {
	public LatLon geocodeAddress(String address);

}
