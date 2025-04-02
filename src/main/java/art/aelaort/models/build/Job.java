package art.aelaort.models.build;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static java.util.Collections.frequency;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Job {
	@With
	private Integer id;
	@JsonProperty
	private String name;
	@JsonProperty("build_type")
	private String buildType;
	@JsonProperty("sub_directory")
	private String subDirectory;
	@Nullable
	private String projectDir;
	@Nullable
	private String secretsDirectory;
	@JsonProperty
	private boolean db;
	@JsonProperty
	private boolean deprecated;

	private final static Map<String, Integer> typesIds = Map.of(
			"java_docker", 1,
			"docker", 2,
			"java_local", 3,
			"java_graal_local", 4,
			"ya_func", 5,
			"frontend_vue", 6
	);


	@JsonProperty("project_dir")
	public void setProjectDir(String projectDir) {
		this.projectDir = projectDir.isEmpty() ? null : projectDir;
	}

	@JsonProperty("secrets_directory")
	public void setSecretsDirectory(String secretsDirectory) {
		this.secretsDirectory = secretsDirectory.isEmpty() ? null : secretsDirectory;
	}

	public static List<Job> addNumbers(List<Job> jobs) {
		AtomicInteger inc1 = new AtomicInteger(1);
		List<Job> repeatedItems = jobs.stream()
				.filter(i -> frequency(jobs, i) > 1)
				.sorted(getJobComparator())
				.map(getJobMapFunction(inc1))
				.toList();

		AtomicInteger inc2 = new AtomicInteger(1 + repeatedItems.size());
		List<Job> notRepeatedItems = jobs.stream()
				.filter(i -> frequency(jobs, i) == 1)
				.sorted(getJobComparator())
				.map(getJobMapFunction(inc2))
				.toList();

		return new ArrayList<>(notRepeatedItems) {{
			addAll(repeatedItems);
		}};
	}

	private static Comparator<Job> getJobComparator() {
		return Comparator.comparing(job -> typesIds.getOrDefault(job.buildType, 100) + "%" + job.name);
	}

	private static Function<Job, Job> getJobMapFunction(AtomicInteger inc1) {
		return server -> server.id == null ?
				server.withId(inc1.getAndIncrement()) :
				server;
	}

	@Override
	public String toString() {
		return "Job{" +
				"id=" + id +
				", name='" + name + '\'' +
				", buildType=" + buildType +
				", subDirectory='" + subDirectory + '\'' +
				", projectDir='" + projectDir + '\'' +
				", secretsDirectory='" + secretsDirectory + '\'' +
				'}';
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Job job)) {
			return false;
		}

		return name.equals(job.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	public Path resolveSrcDir(Path srcRootDir) {
		String dirName = projectDir == null ? name : projectDir;
		return srcRootDir.resolve(subDirectory).resolve(dirName);
	}
}
