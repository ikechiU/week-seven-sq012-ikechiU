package com.example.weeksevensq012ikechiu.model.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class APIResponses {
    private final boolean success;
    private final LocalDateTime responseDate;
    private final List<Object> errorMessage;
}
