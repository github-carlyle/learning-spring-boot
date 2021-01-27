package com.cozycottage.web.controller;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	
	@GetMapping(value = "/application/version", produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String showVersion() {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneOffset.systemDefault());
		
		String version = buildProperties.getVersion();
		String artifactId = buildProperties.getArtifact();
		String build = formatter.format(buildProperties.getTime());
		
		return String.format("%s %s %s", artifactId, version, build);
	}
	
	@Autowired
	BuildProperties buildProperties;
}
