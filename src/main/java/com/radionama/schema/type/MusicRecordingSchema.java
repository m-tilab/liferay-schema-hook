package com.radionama.schema.type;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;


public class MusicRecordingSchema implements BaseSchema {

	public MusicRecordingSchema(String name, String description, String genre, String artistName,
			String aboutName, String imagecaption, String imageUrl, String thumbnailUrl, String composerName,
			String audienceType, String url, String mainEntityOfPageId) {
		super();
		this.name = name;
		this.description = description;
		this.genre = genre;
		this.artistName = artistName;
		this.aboutName = aboutName;
		this.imagecaption = imagecaption;
		this.imageUrl = imageUrl;
		ThumbnailUrl = thumbnailUrl;
		this.composerName = composerName;
		this.audienceType = audienceType;
		this.url = url;
		this.mainEntityOfPageId = mainEntityOfPageId;
	}
	@Override
	public JSONObject toJSON() {
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		JSONObject artistObject = JSONFactoryUtil.createJSONObject();
		JSONObject aboutObject = JSONFactoryUtil.createJSONObject();
		JSONObject imageObject = JSONFactoryUtil.createJSONObject();
		JSONObject recordingOfObject = JSONFactoryUtil.createJSONObject();
		JSONObject composerObject = JSONFactoryUtil.createJSONObject();
		JSONObject audienceObject = JSONFactoryUtil.createJSONObject();
		JSONObject mainEntityOfPageObject = JSONFactoryUtil.createJSONObject();



		jsonObject.put("@context", "http://schema.org");
		jsonObject.put("@type", "MusicRecording");
		jsonObject.put("name", getName());
		jsonObject.put("description", getDescription());
		jsonObject.put("genre", getGenre());
			artistObject.put("@type", "MusicGroup");
			artistObject.put("name", getArtistName());
		jsonObject.put("byArtist", artistObject);
			aboutObject.put("@type", "Thing");
			aboutObject.put("name",  getAboutName());
		jsonObject.put("about", aboutObject);
			imageObject.put("@type", "ImageObject");
			imageObject.put("caption", getImagecaption());
			imageObject.put("url", getImageUrl());
		jsonObject.put("image", imageObject);
		jsonObject.put("thumbnailUrl", getThumbnailUrl());
		jsonObject.put("fileFormat", "https://en.wikipedia.org/wiki/MP3");
			recordingOfObject.put("@type", "MusicComposition");
				composerObject.put("@type", "person");
				composerObject.put("name", getComposerName());
			recordingOfObject.put("composer", composerObject);
		jsonObject.put("recordingOf", recordingOfObject);
			audienceObject.put("@type", "Audience");
			audienceObject.put("audienceType", getAudienceType());
		jsonObject.put("audience", audienceObject);
		jsonObject.put("url", getUrl());
			mainEntityOfPageObject.put("@type", "WebPage");
			mainEntityOfPageObject.put("@id", getMainEntityOfPageId());
		jsonObject.put("mainEntityOfPage", mainEntityOfPageObject);
		return jsonObject;
	}
	
	private String name;
	private String description;
	private String genre;
	private String artistName;
	private String aboutName;
	private String imagecaption;
	private String imageUrl;
	private String ThumbnailUrl;
	private String composerName;
	private String audienceType;
	private String url;
	private String mainEntityOfPageId;
	
	

	public String getMainEntityOfPageId() {
		return mainEntityOfPageId;
	}
	public void setMainEntityOfPageId(String mainEntityOfPageId) {
		this.mainEntityOfPageId = mainEntityOfPageId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAudienceType() {
		return audienceType;
	}
	public void setAudienceType(String audienceType) {
		this.audienceType = audienceType;
	}
	public String getComposerName() {
		return composerName;
	}
	public void setComposerName(String composerName) {
		this.composerName = composerName;
	}
	public String getThumbnailUrl() {
		return ThumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		ThumbnailUrl = thumbnailUrl;
	}
	
	public String getImagecaption() {
		return imagecaption;
	}
	public void setImagecaption(String imagecaption) {
		this.imagecaption = imagecaption;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	

	public String getArtistName() {
		return artistName;
	}



	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	
	public String getAboutName() {
		return aboutName;
	}



	public void setAboutName(String aboutName) {
		this.aboutName = aboutName;
	}

}
