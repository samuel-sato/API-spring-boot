package one.digitalInovation.personAPI.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

	private String message;

	MessageResponseDTO(){
	}

	public MessageResponseDTO(String message) {
		this.message = message;
	}
	
	
}
