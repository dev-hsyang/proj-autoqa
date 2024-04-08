package com.example.seleniumprog;

public class BlindBestTopicDto {

    private String topic;
    private String title;
    private Integer likes;
    private Integer comments;

    public BlindBestTopicDto(String topic, String title, int likes, int comments) {
        this.topic = topic;
        this.title = title;
        this.likes = likes;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return topic + " | " + title + " | " + likes + " | " + comments;
    }
}
