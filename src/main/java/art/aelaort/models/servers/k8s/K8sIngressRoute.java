package art.aelaort.models.servers.k8s;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.Objects;

@Getter
@Builder(toBuilder = true)
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class K8sIngressRoute {
	private String name;
	private String namespace;
	private String match;
	private String serviceName;
	private Integer servicePort;
	private boolean hasTls;

	@Override
	public final boolean equals(Object o) {
		if (!(o instanceof K8sIngressRoute that)) {
			return false;
		}

		return Objects.equals(match, that.match);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(match);
	}
}
