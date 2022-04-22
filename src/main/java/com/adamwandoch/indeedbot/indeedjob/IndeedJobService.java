package com.adamwandoch.indeedbot.indeedjob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Adam Wandoch
 */

@Service
public class IndeedJobService {

    private static final Logger LOG = LoggerFactory.getLogger(IndeedJobService.class);

    @Autowired
    private IndeedJobRepository indeedJobRepository;

    public IndeedJobService() {
    }

    public IndeedJobService(List<IndeedJob> cachedJobs) {
        this.cachedJobs = cachedJobs;
    }

    private List<IndeedJob> cachedJobs = new ArrayList<>();

    private String generateJobUrl(String jobId) {
        return "https://ie.indeed.com/viewjob?jk=".concat(jobId);
    }

//    @PostConstruct
//    public void runAfterObjectCreated() {
//        reloadFromDatasource();
//    }

    @PostConstruct
    public void reloadFromDatasource() {
        // reloads records from database
        indeedJobRepository.findAll().forEach(job -> {
            if (!cachedJobs.contains(job)) cachedJobs.add(job);
        });
        if (cachedJobs.size() > 0) {
            LOG.info("CACHED JOB LIST WITH " + cachedJobs.size() + " RECORDS");
        } else {
            LOG.info("JOB LIST SIZE == 0, CACHING UNSUCCESSFUL");
        }
    }

    public List<IndeedJob> getJobByIndex(int index) {
        return List.of(cachedJobs.get(index));
    }

    public List<IndeedJob> getCachedJobs() {
        return cachedJobs;
    }

    public List<IndeedJob> getCachedJobsSortId() {
        return cachedJobs.stream()
                .sorted(Comparator.comparing(IndeedJob::getIndeedId))
                .collect(Collectors.toList());
    }

    public List<IndeedJob> getCachedJobsSortTitle() {
        return cachedJobs.stream()
                .sorted(Comparator.comparing(IndeedJob::getTitle))
                .collect(Collectors.toList());
    }

    public List<IndeedJob> getCachedJobsSortCompany() {
        return cachedJobs.stream()
                .sorted(Comparator.comparing(IndeedJob::getCompany))
                .collect(Collectors.toList());
    }

    public List<IndeedJob> getJobsByTitle(String keyword) {
        return getCachedJobs().stream()
                .filter(j -> j.getTitle().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    public List<IndeedJob> getJobsByTitleSortId(String keyword) {
        return getJobsByTitle(keyword).stream()
                .sorted(Comparator.comparing(IndeedJob::getIndeedId))
                .collect(Collectors.toList());
    }

    public List<IndeedJob> getJobsByTitleSortTitle(String keyword) {
        return getJobsByTitle(keyword).stream()
                .sorted(Comparator.comparing(IndeedJob::getTitle))
                .collect(Collectors.toList());
    }

    public List<IndeedJob> getJobsByTitleSortCompany(String keyword) {
        return getJobsByTitle(keyword).stream()
                .sorted(Comparator.comparing(IndeedJob::getCompany))
                .collect(Collectors.toList());
    }

    public List<IndeedJob> getJobsByCompany(String keyword) {
        return getCachedJobs().stream()
                .filter(j -> j.getCompany().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    public List<IndeedJob> getJobsByCompanySortID(String keyword) {
        return getJobsByCompany(keyword).stream()
                .sorted(Comparator.comparing(IndeedJob::getIndeedId))
                .collect(Collectors.toList());
    }

    public List<IndeedJob> getJobsByCompanySortTitle(String keyword) {
        return getJobsByCompany(keyword).stream()
                .sorted(Comparator.comparing(IndeedJob::getTitle))
                .collect(Collectors.toList());
    }

    public List<IndeedJob> getJobsByCompanySortCompany(String keyword) {
        return getJobsByCompany(keyword).stream()
                .sorted(Comparator.comparing(IndeedJob::getCompany))
                .collect(Collectors.toList());
    }

    public long getDBTableSize() {
        return indeedJobRepository.count();
    }
}
