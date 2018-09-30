package com.chen1144.hviewer.service;

import com.chen1144.hviewer.util.Box;
import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class PictureDownloader {
    private ThreadPoolExecutor threadPool;
    private int poolSize;

    public PictureDownloader(int poolSize){
        this.poolSize = poolSize;
        threadPool = new ThreadPoolExecutor(poolSize, poolSize, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }

    public void enqueue(String url, Consumer<Image> consumer){
        threadPool.execute(()->{
            try {
                Image image = ImageIO.read(new URL(url));
                consumer.accept(image);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

    public void shutdown(){
        threadPool.shutdown();
    }

}
