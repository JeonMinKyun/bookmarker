package com.min.edu;

import java.time.Instant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.min.edu.domain.Bookmark;
import com.min.edu.domain.BookmarkRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

	private final BookmarkRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
//		repository.save(new Bookmark(null, "devopsbookmark", "https://www.devopsbookmark.com", Instant.now()));
//        repository.save(new Bookmark(null, "techblog", "https://www.techblog.com", Instant.now()));
//        repository.save(new Bookmark(null, "codingresource", "https://www.codingresource.com", Instant.now()));
//        repository.save(new Bookmark(null, "programminghub", "https://www.programminghub.com", Instant.now()));
//        repository.save(new Bookmark(null, "javaguide", "https://www.javaguide.com", Instant.now()));
//        repository.save(new Bookmark(null, "webdevtips", "https://www.webdevtips.com", Instant.now()));
//        repository.save(new Bookmark(null, "cloudcomputing", "https://www.cloudcomputing.com", Instant.now()));
//        repository.save(new Bookmark(null, "datasciencetools", "https://www.datasciencetools.com", Instant.now()));
//        repository.save(new Bookmark(null, "aiinsights", "https://www.aiinsights.com", Instant.now()));
//        repository.save(new Bookmark(null, "devtools", "https://www.devtools.com", Instant.now()));
//        repository.save(new Bookmark(null, "machinelearning", "https://www.machinelearning.com", Instant.now()));
//        repository.save(new Bookmark(null, "opensource", "https://www.opensource.com", Instant.now()));
//        repository.save(new Bookmark(null, "cybersecurity", "https://www.cybersecurity.com", Instant.now()));
//        repository.save(new Bookmark(null, "frontendfocus", "https://www.frontendfocus.com", Instant.now()));
//        repository.save(new Bookmark(null, "backendbasics", "https://www.backendbasics.com", Instant.now()));
//        repository.save(new Bookmark(null, "mobiledev", "https://www.mobiledev.com", Instant.now()));
//        repository.save(new Bookmark(null, "datastructures", "https://www.datastructures.com", Instant.now()));
//        repository.save(new Bookmark(null, "algorithms", "https://www.algorithms.com", Instant.now()));
//        repository.save(new Bookmark(null, "designpatterns", "https://www.designpatterns.com", Instant.now()));
//        repository.save(new Bookmark(null, "softwareengineering", "https://www.softwareengineering.com", Instant.now()));
	}

}
