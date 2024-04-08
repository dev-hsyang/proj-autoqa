package com.example.seleniumprog;

public class BlindBestTopicDto {

    private String topic;
    private String title;

    public BlindBestTopicDto(String topic, String title) {
        this.topic = topic;
        this.title = title;
    }

    @Override
    public String toString() {
        return topic + " | " + title;
    }
}
