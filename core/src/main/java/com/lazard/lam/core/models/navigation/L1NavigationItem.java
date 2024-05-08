package com.lazard.lam.core.models.navigation;

import com.day.cq.wcm.api.Page;

import lombok.Getter;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@Getter
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class L1NavigationItem {

    private static final Logger LOG = LoggerFactory.getLogger(L1Navigation.class);

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

    @Getter
    private int l1Level = 1;

    @Getter
    private List<NavigationItem> listItems = new ArrayList<>();

    @PostConstruct
    public void init() {
        Resource resource = getResource(this.navigationRoot);
        if (resource != null){
            Page rootPage = resource.adaptTo(Page.class);
            if (rootPage != null){
                int startLevel = rootPage.getDepth();
                this.title = rootPage.getTitle();
                this.setChildrenList(startLevel, rootPage);
            }
        }
    }

    public Resource getResource(String path){
        return resourceResolver.getResource(path);
    }

    public void setChildrenList(int startLevel, Page parent) {
        Iterator<Page> listChildren = parent.listChildren(null, true);
        NavigationItem newItem;
        while (listChildren.hasNext()) {
            Page currentChild = listChildren.next();
            int level = (currentChild.getDepth() - startLevel) + 1;
            String body = this.getProperties(currentChild, "jcr:description");
            String infoDate = this.getProperties(currentChild, "infoDate"); //Type to be updated when page properties is added to the template
            String readTime = this.getProperties(currentChild, "readTime"); //Type to be updated when page properties is added to the template
            String image = this.getProperties(currentChild, "image"); //Type to be updated when page properties is added to the template
            newItem = new NavigationItem(currentChild.getTitle(),
                    currentChild.getPath(),
                    level,
                    body,
                    infoDate,
                    readTime,
                    image);
            listItems.add(newItem);
        }
    }

    public String getProperties(Page parent,String property) {
        ValueMap properties = parent.getProperties();
        if (properties.containsKey(property)){
            return properties.get(property).toString();
        }
        return null;
    }

    public boolean isListItemsEmpty() {
        return CollectionUtils.isEmpty(this.listItems);
    }
}
