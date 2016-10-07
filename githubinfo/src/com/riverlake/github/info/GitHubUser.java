package com.riverlake.github.info;

import java.io.IOException;
import java.util.Date;

import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.UserService;

public class GitHubUser {
	private UserService userService;
	private User user;

	public GitHubUser(String log, String pwd) {
		GitHubClient client = new GitHubClient();
		client.setCredentials(log, pwd);
		userService = new UserService(client);
		try {
			user = userService.getUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAvatar() {
		return user.getAvatarUrl();
	}

	public String getName() {
		return user.getName();
	}

	public String getLogin() {
		return user.getLogin();
	}

	public String getBio() {
		return user.getBio();
	}

	public String getCompany() {
		return user.getLocation();
	}

	public String getEmail() {
		return user.getEmail();
	}

	public String getBlog() {
		return user.getBlog();
	}

	public Date getCreatedAt() {
		return user.getCreatedAt();
	}

	public int getFollowers() {
		int num = -1;
		try {
			num = userService.getFollowers().size();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
}
