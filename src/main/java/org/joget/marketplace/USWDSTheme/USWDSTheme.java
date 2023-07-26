package org.joget.marketplace.USWDSTheme;

import java.util.Map;
import org.joget.apps.app.service.AppUtil;
import org.joget.apps.userview.lib.AjaxUniversalTheme;

public class USWDSTheme extends AjaxUniversalTheme{
    @Override
    public String getName() {
        return "US Web Design Theme";
    }

    @Override
    public String getVersion() {
        return "8.0.0";
    }

    @Override
    public String getLabel() {
        return getName();
    }
    
    @Override
    public String getDescription() {
        return "A US Web Design System Theme based on Material Design";
    }
    
    @Override
    public String getClassName() {
        return getClass().getName();
    }
    
    @Override
    public String getPropertyOptions() {
        return AppUtil.readPluginResource(getClass().getName(), "/properties/dx8USWDSTheme.json", null, true, null);
    }
    
    @Override
    public String getHeader(Map<String, Object> data) {
        if (isAjaxContent(data)) {
            return "";
        } else {
            if ("true".equals(getPropertyString("horizontal_menu"))) {
                data.put("header_help_before", "<span class=\"grow\"></span>");
            }
            return super.getHeader(data);
        }
    }
    @Override
    public String getJsCssLib(Map<String, Object> data) {
        if (isAjaxContent(data)) {
            return "";
        } else {
            String jsCssLink = super.getJsCssLib(data);
            jsCssLink += "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n";
            jsCssLink += "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n";
            jsCssLink += "<link href=\"https://fonts.googleapis.com/css2?family=Source+Sans+3:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap\" rel=\"stylesheet\">";
            jsCssLink += "<link rel=\"stylesheet\" href=\"" + data.get("context_path") + "/plugin/" + getClassName() + "/USWDSTheme.css\"></link>\n";
            return jsCssLink;
        }
    }
}
