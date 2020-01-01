package com.radionama.schema.type;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class WebPageSchema implements BaseSchema {

	public WebPageSchema(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public JSONObject toJSON() {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("@context", "http://schema.org");
		jsonObject.put("@type", "WebPage");
		jsonObject.put("name", getName());
		jsonObject.put("description", getDescription());

		return jsonObject;
	}

	private String name;
	private String description;
	

}
