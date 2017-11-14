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
		// ��ȡ���ö���
		Configuration configuration = new Configuration(Configuration.getVersion());
		Writer out = null;
		// ģ������λ��
		File dir = new File("D:/Program Files/eclipse/StormWind/Freemarker-demo/target/classes/");
		// ����ģ��Ŀ¼�ͱ��뷽ʽ
		configuration.setDirectoryForTemplateLoading(dir);
		configuration.setDefaultEncoding("gbk");
		// ����ģ�����
		Template template = configuration.getTemplate("freemarker/freemarker-template.ftl");
		// ģ������
		Map<String, Object> dataModel = new HashMap<>();

		List<String> list = new ArrayList<>();
		list.add("837");
		list.add("997");
		list.add("211");
		list.add("917");

		dataModel.put("test", "66666666");
		dataModel.put("map", list);
		
		out = new FileWriter("demo.txt");
		// ����
		template.process(dataModel, out);
		// �ͷ���Դ
		out.close();
	}

}
