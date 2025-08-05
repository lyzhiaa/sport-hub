package kh.edu.istad_sport.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseErrorResponse {
    private BaseError Error;
}
