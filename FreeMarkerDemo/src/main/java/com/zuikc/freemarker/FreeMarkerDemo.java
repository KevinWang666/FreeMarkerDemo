package com.zuikc.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerDemo {

	public static void main(String[] args) throws Exception {
		// 获取配置对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		Writer out = null;
		// 模版所在位置
		File dir = new File("D:/Program Files/eclipse/StormWind/Freemarker-demo/target/classes/");
		// 设置模版目录和编码方式
		configuration.setDirectoryForTemplateLoading(dir);
		configuration.setDefaultEncoding("gbk");
		// 创建模版对象
		Template template = configuration.getTemplate("freemarker/freemarker-template.ftl");
		// 模型数据
		Map<String, Object> dataModel = new HashMap<>();

		List<String> list = new ArrayList<>();
		list.add("837");
		list.add("997");
		list.add("211");
		list.add("917");

		dataModel.put("test", "66666666");
		dataModel.put("map", list);
		
		out = new FileWriter("demo.txt");
		// 发送
		template.process(dataModel, out);
		// 释放资源
		out.close();
	}

}
