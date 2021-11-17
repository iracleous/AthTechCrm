package gr.athtech.athtechcrm.front;

import gr.athtech.athtechcrm.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private int statusCode;
    private String description;
    private T data;



}
