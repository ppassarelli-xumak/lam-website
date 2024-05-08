package com.lazard.lam.core.models;

import com.lazard.lam.core.models.impl.FooterCopyrightImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.day.cq.wcm.api.Page;


import java.time.Year;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import javax.jcr.RepositoryException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FooterCopyRightTest {


    public final AemContext context = new AemContext();


    @InjectMocks
    private FooterCopyrightImpl footerCopyright;

    @Mock
    private Page currentPage;

    @Mock
    private Resource resource;

    @Mock
    private ResourceResolver resourceResolver;

    @BeforeEach
    void setUp() throws RepositoryException {
        footerCopyright = new FooterCopyrightImpl();
         footerCopyright.setText("This is a copyright >text");
    }

    @Test
    void testReturnedText() {
        String year = String.valueOf(Year.now().getValue());
        assertEquals(footerCopyright.textWithYear(),"This is a copyright >&copy"+year+" text");
    }
}
