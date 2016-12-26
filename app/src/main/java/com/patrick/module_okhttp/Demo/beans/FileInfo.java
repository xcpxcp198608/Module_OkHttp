package com.patrick.module_okhttp.Demo.beans;

/**
 * Created by patrick on 2016/12/24.
 */

public class FileInfo {
    private String name;
    private String url;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
