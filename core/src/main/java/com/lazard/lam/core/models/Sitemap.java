package com.lazard.lam.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Model(
    adaptables = SlingHttpServletRequest.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Sitemap {
    @SlingObject
    SlingHttpServletRequest slingRequest;

    @Inject
    @Via("resource")
    @Getter
    public List<SitemapDetails> sitemap;

    public boolean isEmpty() {
        return sitemap == null;
    }
}
