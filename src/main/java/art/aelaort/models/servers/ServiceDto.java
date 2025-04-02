package art.aelaort.models.servers;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class ServiceDto {
	private String service;
	private String ymlName;
	private String dockerName;
	private String dockerImageName;

	@Override
	public String toString() {
		if (dockerName == null) {
			return "%s %s".formatted(service, ymlName);
		} else {
			return "%s (%s) %s".formatted(dockerName, service, ymlName);
		}
	}
}
