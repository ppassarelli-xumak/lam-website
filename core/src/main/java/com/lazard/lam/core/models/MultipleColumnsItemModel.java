package com.lazard.lam.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = { Resource.class },
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultipleColumnsItemModel {

    @Inject
    private String mobileSize;

    @Inject
    private String tabletSize;

    @Inject
    private String desktopSize;

    public String getMobileSize() {
        return mobileSize;
    }

    public String getTabletSize() {
        return tabletSize;
    }

    public String getDesktopSize() {
        return desktopSize;
    }
}