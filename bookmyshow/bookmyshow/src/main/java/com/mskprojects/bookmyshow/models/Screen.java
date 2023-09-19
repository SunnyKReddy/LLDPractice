package com.mskprojects.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seatList;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // creates mapping table for Screen to Feature (ENUM)
    private List<Feature> featureList;
}
