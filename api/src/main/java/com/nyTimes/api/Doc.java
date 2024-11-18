package com.nyTimes.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Doc {
    @JsonProperty("abstract")
    private String summary;
    @JsonProperty("web_url")
    private String webUrl;
    private String snippet;
    private String source;
    private List<SearchMultiMedia> multimedia;
    private Headline headline;
    @JsonProperty("pub_date")
    private String pubDate;
    @JsonProperty("news_desk")
    private String newsDesk;
    @JsonProperty("section_name")
    private String sectionName;
    @JsonProperty("subsection_name")
    private String subSectionName;
    private Byline byline;
    private String imageUrl;
}
