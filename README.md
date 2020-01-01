"# liferay-schema-hook" 

At first for deploy this module, copy this into module folder of your liferay workspace.

supported Schema Types:

<ul>
	<li>MusicRecording</li>
	<li>WebPage</li>
</ul>

<p>for add new schema support, must be implement <code>BaseSchema</code> class.</p>


<p>
In the module which is using the base schema module.You need to add to your dependencies, base module object:

<br>
<code>
compile project(":modules:schema-hook")
</code>

And populate your schema object same as this:
<br>
<code>
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
String imageUrl = "";
if (_music.getCoverFileEntryId() > 0) {
	FileEntry ImageEntry = DLAppServiceUtil.getFileEntry(_music.getCoverFileEntryId());
	imageUrl = DLUtil.getPreviewURL(ImageEntry, ImageEntry.getFileVersion(), themeDisplay, "&imageThumbnail=1");
	String[] imageSplit = imageUrl.split(StringPool.PERIOD + ImageEntry.getExtension());
	imageUrl = imageSplit[0] + StringPool.PERIOD + ImageEntry.getExtension();
}
Layout layout = themeDisplay.getLayout();
String completeURL = PortalUtil.getCanonicalURL(PortalUtil.getCurrentCompleteURL(request), themeDisplay, layout);
String artistName = "";
MusicRecordingSchema musicRecordingSchema = new MusicRecordingSchema(layout.getName(themeDisplay.getLocale()), layout.getDescription(themeDisplay.getLocale()),_music.getGenre(), artistName, LanguageUtil.get(request, "music-download"),_music.getTitle(themeDisplay.getLocale()), imageUrl, imageUrl, artistName, LanguageUtil.get(request, "music-enthusiasts"), completeURL, completeURL);
request.setAttribute("LIFERAY_SHARED_SCHEMA", musicRecordingSchema.toJSON());		
</code>

</p>

this code completed by me and Ms. maryam koochaki