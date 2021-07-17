package com.example.sm.controller.request;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class FormCreateRequest {
    private String content;
}
