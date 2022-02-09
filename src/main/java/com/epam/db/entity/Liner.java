package com.epam.db.entity;

public class Liner {

    String name;
    Integer passengers;
    Integer crew;
    Long id;

    public Liner() {
    }

    public Liner(String name, Integer passengers, Integer crew, Long id) {
        this.name = name;
        this.passengers = passengers;
        this.crew = crew;
        this.id = id;
    }

    public static LinerBuilder builder() {
        return new LinerBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public Integer getCrew() {
        return crew;
    }

    public void setCrew(Integer crew) {
        this.crew = crew;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Liner{" +
                "name='" + name + '\'' +
                ", passengers=" + passengers +
                ", crew=" + crew +
                ", id=" + id +
                '}';
    }

    public static class LinerBuilder {
        private String name;
        private Integer passengers;
        private Integer crew;
        private Long id;

        LinerBuilder() {
        }

        public LinerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public LinerBuilder passengers(Integer passengers) {
            this.passengers = passengers;
            return this;
        }

        public LinerBuilder crew(Integer crew) {
            this.crew = crew;
            return this;
        }

        public LinerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Liner build() {
            return new Liner(name, passengers, crew, id);
        }

        public String toString() {
            return "Liner.LinerBuilder(name=" + this.name + ", passengers=" + this.passengers + ", crew=" + this.crew + ", id=" + this.id + ")";
        }
    }
}
