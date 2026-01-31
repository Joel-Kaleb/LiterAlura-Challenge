package com.challenger.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonAlias("id") Long gutendexId,
        String title,
        List<AuthorData> authors,
        List<String> languages,
        @JsonAlias("download_count") Integer downloads
) {
}
