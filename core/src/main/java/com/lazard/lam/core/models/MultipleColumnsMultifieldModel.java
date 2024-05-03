package com.lazard.lam.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(adaptables = { Resource.class },
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultipleColumnsMultifieldModel {

    @Inject
    private List<MultipleColumnsItemModel> columnsList;

    public List<MultipleColumnsItemModel> getColumnsList() {
        if(columnsList == null) {
            columnsList = new ArrayList<>();
        }
        return Collections.unmodifiableList(columnsList);
    }
}