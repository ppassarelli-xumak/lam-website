package com.lazard.lam.core.models;

import com.lazard.lam.core.models.impl.SocialLinksModelImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;


import static org.junit.jupiter.api.Assertions.*;

class SocialLinksModelTest {


    public final AemContext context = new AemContext();


    @InjectMocks
    private SocialLinksModelImpl socialLinksModel;



    @BeforeEach
    void setUp() {
        socialLinksModel = new SocialLinksModelImpl();
    }

    @Test
    void testValidations() {
        assertTrue(socialLinksModel.isEmpty());
        socialLinksModel.setYoutubeImage("/content/dam/images/youtube.png");
        assertFalse(socialLinksModel.isEmpty());
        socialLinksModel.setLinkedinImage("/content/dam/images/linkedIn.png");
        assertFalse(socialLinksModel.isEmpty());
    }
}
