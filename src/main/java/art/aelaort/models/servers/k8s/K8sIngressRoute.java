package art.aelaort.models.servers.k8s;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Getter
@Builder(toBuilder = true)
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true, value = "tls", allowSetters = true)
public class K8sIngressRoute {
	private String name;
	private String namespace;
	private List<Route> routes;
	private boolean hasTls;
	@Setter
	private Object tls;
}
