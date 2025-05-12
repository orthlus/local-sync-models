package art.aelaort.models.servers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.List;

@Builder(toBuilder = true)
@Getter
@Accessors(fluent = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirServer {
	private String name;
	private boolean monitoring;
	private List<ServiceDto> services;
	private Integer price;
}
