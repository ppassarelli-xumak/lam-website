package com.lazard.lam.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class SitemapDetails {

    @Inject
    private String url;

    @Inject
    private String text;
    
}
