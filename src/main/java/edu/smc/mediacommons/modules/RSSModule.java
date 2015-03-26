package edu.smc.mediacommons.modules;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import lombok.Getter;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

@Getter
public class RSSModule {
    
    private final List<?> entries;
    
    public RSSModule(String address) {
        SyndFeed feed = null;
        
        try {
            URL url = new URL(address);
            HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
            SyndFeedInput input = new SyndFeedInput();
            feed = input.build(new XmlReader(httpcon));
        } catch (IOException | IllegalArgumentException | FeedException e) {
            e.printStackTrace();
        }
        
        entries = feed.getEntries();
    }
    
    public void printFeed() {
        Iterator<?> itEntries = entries.iterator();
        
        while (itEntries.hasNext()) {
            SyndEntry entry = (SyndEntry) itEntries.next();
            System.out.println("Title: " + entry.getTitle());
            System.out.println("Link: " + entry.getLink());
            System.out.println("Author: " + entry.getAuthor());
            System.out.println("Publish Date: " + entry.getPublishedDate());
            
            if(entry.getDescription() == null) {
               System.out.println("Null description");
               continue;
            }
            
            System.out.println("Description: " + entry.getDescription().getValue());
            System.out.println();
        }
    }
}