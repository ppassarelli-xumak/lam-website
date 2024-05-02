package com.lazard.lam.core.models.navigation;

import com.day.cq.wcm.api.Page;

import lombok.Getter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@Getter
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class L1NavigationItem {

    private static final Logger LOG = LoggerFactory.getLogger(L1Navigation.class);

    @ScriptVariable
    protected Page currentPage;

    @Self
    private SlingHttpServletRequest request;

    @Self
    private Resource resource;

    @SlingObject
    private ResourceResolver resourceResolver;

    @ValueMapValue
    @Getter
    private String navigationRoot;

    @ValueMapValue
    @Getter
    private String viewType;

    @Getter
    private String title;

    @PostConstruct
    public void init() {
        this.title = this.getPageTitle();
    }

    public String getPageTitle() {
        Resource res = resourceResolver.getResource(this.navigationRoot);
        String pageTitle = "";
        if(res != null) {
            Page page = res.adaptTo(Page.class);
            if (page != null) {
                pageTitle = page.getTitle();
            }
        }
        return pageTitle;
    }



}
