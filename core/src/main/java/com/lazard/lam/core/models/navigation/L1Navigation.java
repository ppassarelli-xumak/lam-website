package com.lazard.lam.core.models.navigation;

import lombok.Getter;

import org.apache.commons.collections4.CollectionUtils;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Getter
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class L1Navigation {

    private static final Logger LOG = LoggerFactory.getLogger(L1Navigation.class);

    @ChildResource
    public List<L1NavigationItem> l1navItems;

    public boolean isNavItemEmpty() {
        return CollectionUtils.isEmpty(this.l1navItems);
    }


}
