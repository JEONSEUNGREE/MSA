package com.example.orderservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Scheme {
    private String type;
    private List<Field> field;
    private boolean optional;
    private String name;
}