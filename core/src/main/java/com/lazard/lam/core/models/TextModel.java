package com.lazard.lam.core.models;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TextModel {

    @Getter
    @ValueMapValue
    private String text;

    @ValueMapValue
    private boolean textIsRich;

    @ValueMapValue
    private boolean dropCap;

    public boolean isValid() {
        return StringUtils.isNotBlank(this.text);
    }

    public boolean isRichText() {
        return this.textIsRich;
    }

    public boolean isDropCapChecked() {
        return this.dropCap;
    }
}
