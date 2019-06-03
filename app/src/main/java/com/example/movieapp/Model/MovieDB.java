package com.example.movieapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MovieDB implements Serializable {

    @SerializedName("page")
    @Expose
    private Integer page;

    @SerializedName("total_results")
    @Expose
    private Integer total_results;

    @SerializedName("total_pages")
    @Expose
    private Integer total_pages;

    @SerializedName("results")
    @Expose
    private List<Movie> results;

    public MovieDB(Integer page, Integer total_results, Integer total_pages, List<Movie> results){
        this.setPage(page);
        this.setTotal_results(total_results);
        this.setTotal_pages(total_pages);
        this.setResults(results);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
