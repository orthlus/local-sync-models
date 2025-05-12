package art.aelaort.models.make;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
	private String name;
	private Integer id;
	private boolean hasGit;
	private boolean hasJooq;
	private boolean isMavenBuildForLocal;
	private String dir;
}
