package com.zuikc.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Controller
public class FreeMarkerController {

	@Resource
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@RequestMapping("/FreeMarkerTest")
	public @ResponseBody String test(String id, ServletRequest request) throws Exception {

		Configuration configuration = freeMarkerConfigurer.getConfiguration();

		Template template = configuration.getTemplate("freemarker-ftl.ftl");
		
		File file = new File(request.getServletContext().getRealPath("/WEB-INF/") + "demo.txt");

		Writer out = new FileWriter(file);

		Map<String, Object> dataModel = new HashMap<>();
		dataModel.put("id", id);
		template.process(dataModel, out);

		out.close();

		return "OK";
	}
}
