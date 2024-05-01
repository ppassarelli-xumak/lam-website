package com.lazard.lam.core.models.impl;

import org.apache.commons.lang3.StringUtils;
import com.lazard.lam.core.models.FooterCopyright;
import java.time.Year;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    adapters = FooterCopyright.class,
    resourceType = FooterCopyrightImpl.RESOURCE_TYPE,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FooterCopyrightImpl implements FooterCopyright {
    protected static final String RESOURCE_TYPE = "lam/components/footercopyright";
    @ValueMapValue
    private String text;

    @Override
    public String textWithYear() {
        int tagEndIndex = text.indexOf('>') + 1;
        String year = String.valueOf(Year.now().getValue()) + " ";
        String text_with_year = text.substring(0, tagEndIndex) + "©" + year + text.substring(tagEndIndex);
        return text_with_year;
    }

    @Override
    public boolean isEmpty() {
        return StringUtils.isBlank(text);
    }
}
