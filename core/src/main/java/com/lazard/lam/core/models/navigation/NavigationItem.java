package com.lazard.lam.core.models.navigation;

import lombok.Getter;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Getter
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavigationItem {

    public NavigationItem(final String title, final String path, final int level, final String body, final String infoDate, final String readTime, final String image) {
        this.title = title;
        this.path = path;
        this.level = level;
        this.body = body;
        this.infoDate = infoDate;
        this.readTime = readTime;
        this.image = image;

    }

    private String title;

    private String path;

    private int level;

    private String body;

    private String infoDate;

    private String readTime;

    private String image;

}
