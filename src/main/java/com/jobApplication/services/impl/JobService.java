package com.jobApplication.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jobApplication.services.IJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobApplication.repositories.JobRepository;
import com.jobApplication.Model.Job;

@Service
public class JobService implements IJobService {
//	private List<Job> jobs = new ArrayList<>();
	ArrayList<Long> list = new ArrayList<>();
	private final Logger logger = LoggerFactory.getLogger(JobService.class);

	@Autowired
	private JobRepository jobRepository;

    @Override
	public void createuser(final Job job) {
		List<Job> lastCheckJobs = jobRepository.findAll();

		if ((list.size() >= 1)) {
			logger.info("");
			System.out.println("bda h ");
			System.out.println(list.size() + "size h yha ");
			Long i = list.remove(0);
			System.out.println("suru ka number " + i);
			job.setId(i);
			jobRepository.save(job);
		} else {
            int nexId = lastCheckJobs.size();
			if (nexId >= 1) {
				nexId = lastCheckJobs.size();
				System.out.println(nexId + " size  ");
				Job tempjob = lastCheckJobs.get(nexId - 1);
				System.out.println(tempjob.getId());
				job.setId(tempjob.getId() + 1);
				jobRepository.save(job);
			} else {
				jobRepository.save(job);
			}
		}
	}

	@Override
	public List<Job> getAllJobs() {

		return jobRepository.findAll();
	}

	@Override
	public Job getJobById(final Long id) {
		Optional<Job> job =  jobRepository.findById(id);
        return job.orElse(null);
    }

	@Override
	public Job updatejob(Job job) {
		boolean j = false;

		for (Job job2 : jobRepository.findAll()) {
			Long a = job2.getId();
			if (a.equals(job.getId())) {
				deletejob(job2.getId());
				j = true;
			}
		}
		if (j) {
			return jobRepository.save(job);
		} else {
			return null;
		}
	}

	@Override
	public Job deletejob(Long id) {
		List<Job> temp = jobRepository.findAll();
		boolean a = false;
		for (Job job : temp) {
			if (id.equals(job.getId())) {
				a = true;
				list.add(id);
				System.out.println(list);
				jobRepository.deleteById(id);
				return job;
			}
		}

		return null;
	}

}
