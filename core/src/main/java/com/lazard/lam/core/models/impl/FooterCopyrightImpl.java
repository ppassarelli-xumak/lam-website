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
    public String getYear() {
        return String.valueOf(Year.now().getValue());
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public boolean isEmpty() {
        return StringUtils.isBlank(text);
    }
}
