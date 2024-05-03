package com.lazard.lam.core.models;

public interface SocialLinksModel{
    String getYoutubeLink();
    String getYoutubeImagePath();
    String getLinkedInLink();
    String getLinkedInImagePath();
    boolean isDisabled();
    boolean isEmpty();
}