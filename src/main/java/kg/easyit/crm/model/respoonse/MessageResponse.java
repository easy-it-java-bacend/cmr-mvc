package kg.easyit.crm.model.respoonse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
public class MessageResponse {

    private String message;

    public static MessageResponse getSuccessMessage(String message) {
        return MessageResponse
                .builder()
                .message(message)
                .build();
    }

    public static MessageResponse getErrorMessage(String message) {
        return MessageResponse
                .builder()
                .message(message)
                .build();
    }

}
