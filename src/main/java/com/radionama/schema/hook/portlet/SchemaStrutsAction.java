package com.radionama.schema.hook.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.radionama.schema.type.WebPageSchema;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "path=/portal/layout" }, service = StrutsAction.class)

public class SchemaStrutsAction extends BaseStrutsAction {

	Log _log = LogFactoryUtil.getLog(SchemaStrutsAction.class);

	@Override
	public String execute(StrutsAction originalStrutsAction, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		
		WebPageSchema webPageSchema = new WebPageSchema(layout.getName(themeDisplay.getLocale()), layout.getDescription(themeDisplay.getLocale()));
		
		request.setAttribute("LIFERAY_SHARED_SCHEMA", webPageSchema.toJSON());

		return originalStrutsAction.execute(originalStrutsAction, request, response);
	}

}
