package com.riverlake.github.info;

import java.io.IOException;
import java.util.List;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;

public class GitHubRepo {
	private RepositoryService repoService;
	private List<Repository> repos;
	
	public GitHubRepo(String log, String pwd){
		GitHubClient client = new GitHubClient();
		client.setCredentials(log, pwd);
		repoService = new RepositoryService(client);
		try {
			setRepos(repoService.getRepositories());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName(Repository repo){
		return repo.getName();
	}
	
	public String getLanguage(Repository repo){
		return repo.getLanguage();
	}
	
	public int getWatchers(Repository repo){
		return repo.getWatchers();
	}
	
	public int getForks(Repository repo){
		return repo.getForks();
	}
	
	public int getBranchs(Repository repo){
		int num = -1;
		try {
			num = repoService.getBranches(repo).size();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	public int getContributors(Repository repo){
		int num = -1;
		try {
			num = repoService.getContributors(repo, true).size();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	public List<Repository> getRepos() {
		return repos;
	}

	public void setRepos(List<Repository> repos) {
		this.repos = repos;
	}
	
}
