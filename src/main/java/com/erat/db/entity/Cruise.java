package com.erat.db.entity;


import java.sql.Timestamp;

public class Cruise {
    String name;
    java.sql.Timestamp startTime;
    java.sql.Timestamp endTime;
    Liner liner;
    //List<Point> ports;
    Long id;

    public Cruise() {
    }

    public Cruise(String name, Timestamp startTime, Timestamp endTime, Liner liner, Long id) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.liner = liner;
        this.id = id;
    }

    public static CruiseBuilder builder() {
        return new CruiseBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Liner getLiner() {
        return liner;
    }

    public void setLiner(Liner liner) {
        this.liner = liner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Route{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", liner=" + liner +
                ", id=" + id +
                '}';
    }

    public static class CruiseBuilder {
        private String name;
        private Timestamp startTime;
        private Timestamp endTime;
        private Liner liner;
        private Long id;

        CruiseBuilder() {
        }

        public CruiseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CruiseBuilder startTime(Timestamp startTime) {
            this.startTime = startTime;
            return this;
        }

        public CruiseBuilder endTime(Timestamp endTime) {
            this.endTime = endTime;
            return this;
        }

        public CruiseBuilder liner(Liner liner) {
            this.liner = liner;
            return this;
        }

        public CruiseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Cruise build() {
            return new Cruise(name, startTime, endTime, liner, id);
        }

        public String toString() {
            return "Cruise.CruiseBuilder(name=" + this.name + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", liner=" + this.liner + ", id=" + this.id + ")";
        }
    }
}
