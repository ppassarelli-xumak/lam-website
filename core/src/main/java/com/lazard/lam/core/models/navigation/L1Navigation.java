package com.lazard.lam.core.models.navigation;



import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.PostConstruct;
import java.util.List;

@Getter
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class L1Navigation {

    @SlingObject
    private Resource resource;

    private static final Logger LOG = LoggerFactory.getLogger(L1Navigation.class);

    @Getter
    @ValueMapValue
    public String text;

    @ChildResource
    public List<L1NavigationItem> l1navItems;

    @PostConstruct
    private void init() {
        LOG.error("---------------------------------------");
        LOG.error("You are in L1 Nav");
        LOG.error("---------------------------------------");
    }

    public boolean isTextEmpty() {
        return StringUtils.isEmpty(this.text);
    }

    public boolean isNavItemEmpty() {
        return CollectionUtils.isEmpty(this.l1navItems);
    }


}
