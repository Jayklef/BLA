package com.jayklef.bla.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favourite {

    @ManyToOne
    private Book bookId;
}
