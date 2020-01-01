<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<% 
JSONObject schemaJSONObject = (JSONObject) request.getAttribute("LIFERAY_SHARED_SCHEMA");
if (schemaJSONObject != null) {
	%>
<script type="application/ld+json">
	<%= schemaJSONObject.toString() %>
</script>
<%
}
%>