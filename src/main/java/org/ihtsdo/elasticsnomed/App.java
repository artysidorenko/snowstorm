package org.ihtsdo.elasticsnomed;

import io.kaicode.elasticvc.api.BranchService;
import org.ihtsdo.elasticsnomed.rf2import.ImportService;
import org.ihtsdo.elasticsnomed.services.ConceptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
public class App extends Config {

	@Autowired
	private ConceptService conceptService;

	@Autowired
	private BranchService branchService;

	@Autowired
	private ElasticsearchOperations elasticsearchTemplate;

	@Autowired
	private ImportService importService;

	final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		System.setProperty("org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH", "true"); // Swagger encodes the slash in branch paths
		SpringApplication.run(App.class, args);
	}

	@PostConstruct
	public void run() throws Exception {
		// Uncomment to import the international edition from disk at startup
//		conceptService.deleteAll();
//		branchService.deleteAll();
//		branchService.create("MAIN");
//		String releasePath = "release/SnomedCT_InternationalRF2_Production_20170131";
//		importService.importSnapshot(releasePath, "MAIN");
//		 or
//		importService.importFull(releasePath, "MAIN");
	}

}