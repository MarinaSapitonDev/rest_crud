package com.example.d1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Customer( int id, String firstName, String lastName, String email) {}




