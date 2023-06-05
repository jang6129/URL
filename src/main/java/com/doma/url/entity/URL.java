package com.doma.url.entity;

import lombok.*;

@ToString
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class URL {
    private long urlId;
    private String urlOriginal;
    private String urlShorten;
    private long requestCount;
}
