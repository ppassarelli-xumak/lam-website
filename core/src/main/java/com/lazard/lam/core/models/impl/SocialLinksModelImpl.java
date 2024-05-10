package com.lazard.lam.core.models.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.lazard.lam.core.models.SocialLinksModel;

@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = {SocialLinksModel.class},
    resourceType = "lam/components/social-links",
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class SocialLinksModelImpl implements SocialLinksModel {
    
    @ValueMapValue
    private String youtubeLink;

    @ValueMapValue
    private String youtubeImage;

    @ValueMapValue
    private String linkedInLink;

    @ValueMapValue
    private String linkedInImage;

    @ValueMapValue
    private boolean disabled;

    @Override
    public String getYoutubeLink() {
        return youtubeLink;
    }

    @Override
    public String getYoutubeImagePath() {
        return youtubeImage;
    }

    @Override
    public String getLinkedInLink() {
        return linkedInLink;
    }

    @Override
    public String getLinkedInImagePath() {
        return linkedInImage;
    }

    @Override
    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public boolean isEmpty() {
        return StringUtils.isBlank(youtubeImage) && StringUtils.isBlank(linkedInImage);
    }

    @Override
    public void setYoutubeImage(String youtubeImage) {
        this.youtubeImage = youtubeImage;
    }
    @Override
    public void setLinkedinImage(String linkedinImage) {
         this.linkedInImage = linkedinImage;
    }
}