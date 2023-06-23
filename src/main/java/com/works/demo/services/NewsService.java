package com.works.demo.services;


import com.works.demo.models.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class NewsService {

    public List<News> news() {
        List<News> newsList = new ArrayList<>();
        try {

            String url = "https://www.haberler.com/";
            Document doc = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get();
            Elements elements = doc.getElementsByAttribute("data-headlinenumber");
            // System.out.println(elements);
            for (Element item : elements) {
                String title = item.attr("title");
                String href = item.attr("href");
                String src = item.getElementsByTag("img").attr("data-src");
                if (!title.isEmpty() && !href.isEmpty() && !src.isEmpty()) {

                    News news = new News();
                    news.setTitle(title);
                    news.setHref(href);
                    news.setSrc(src);
                    newsList.add(news);

                }

            }

        } catch (Exception ex) {
            System.err.println("News Error : " + ex);
        }
        return newsList;

    }
}
