package com.lazard.lam.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.inject.Inject;
import java.util.*;

@Model(adaptables = { Resource.class },
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultipleColumnsModel {

    @Self
    private Resource resource;
    @Inject
    private Long noColumns;

    private List<Map<String, Object>> columnsList;

    public List<Map<String, Object>> getColumnsList() {
        columnsList = new ArrayList<>();
        for (int i = 1; i <= noColumns; i++) {
            Map<String, Object> columnMap = new HashMap<>();
            List<String> componentsList = new ArrayList<>();
            Resource childColumn = resource.getChild("column_" + i);
            if (childColumn != null) {
                for (Resource resourceComp : childColumn.getChildren()){
                    if (resourceComp != null) {
                        componentsList.add(resourceComp.getPath());
                    }
                }
            }
            columnMap.put("columnName", "column_" + i);
            columnMap.put("componentsList", componentsList);
            columnsList.add(columnMap);
        }
        return Collections.unmodifiableList(columnsList);
    }
}