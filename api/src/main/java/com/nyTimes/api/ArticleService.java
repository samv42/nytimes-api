package com.nyTimes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Value("${api_key}")
    private String apikey;

    @Value("${mostPopularUrl}")
    private String mostPopularUrl;

    @Value("${nytSearchUrl}")
    private String nytSearchUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Article> getMostPopular() {
        NytResponse response = restTemplate.getForObject(mostPopularUrl + "api-key=" + apikey, NytResponse.class);
        List<Article> results = new ArrayList<>();
        if (response != null && response.getStatus().equals("OK")) {
            for(Article article : response.getResults()){
                if(!article.getMedia().isEmpty()){
                    article.setImageUrl(article.getMedia().get(0).getMediaMetadata().get(0).getUrl());
                results.add(article);
                }
            }
        }
        return results;
    }
    public List<Doc> getSearchResults(String search) {
        NytSearchResponse response = restTemplate.getForObject(nytSearchUrl + "api-key=" + apikey, NytSearchResponse.class);
        List<Doc> docs = new ArrayList<>();
        if (response != null && response.getStatus().equals("OK")) {
            for(Doc doc : response.getResponse().getDocs()){
                if(!doc.getMultimedia().isEmpty()){
                    for(SearchMultiMedia media : doc.getMultimedia()){
                        if(media.getSubtype().equals("largeHorizontal375")){
                            doc.setImageUrl("https://www.nytimes.com/" + media.getUrl());
                        }
                    }
                    docs.add(doc);
                }
            }
        }
        return docs;
    }
}
