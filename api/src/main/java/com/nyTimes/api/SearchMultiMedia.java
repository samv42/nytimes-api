package com.nyTimes.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchMultiMedia {
    int rank;
    String subtype;
    String caption;
    String credit;
    String type;
    String url;
    int height;
    int width;
    String subType;
    @JsonProperty("crop_name")
    String cropName;
}
