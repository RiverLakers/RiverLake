package com.riverlake.github.info;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.eclipse.egit.github.core.Repository;

public class GitHubInfo {
	public GitHubUser githubUser;
	public GitHubRepo githubRepo;

	public GitHubInfo(String log, String pwd) {
		githubUser = new GitHubUser(log, pwd);
		githubRepo = new GitHubRepo(log, pwd);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String login = scanner.nextLine();
		System.out.println("请输入密码：");
		String pwd = scanner.nextLine();
		scanner.close();
		GitHubInfo ghi = new GitHubInfo(login, pwd);
		System.out.println("数据读取完毕！");
		System.out.println("----------------------------------------");
		try {
			for (Method method : ghi.githubUser.getClass().getMethods()) {
				if (method.getName().startsWith("get") && !method.getName().endsWith("Class")
						&& !method.getName().endsWith("Followers")) {
					System.out.println(method.getName().substring(3) + ":\t" + method.invoke(ghi.githubUser));
				}
			}
			System.out.println("Repositories:");
			for (Repository repo : ghi.githubRepo.getRepos()) {
				for (Method method : ghi.githubRepo.getClass().getMethods()) {
					if (method.getName().startsWith("get") && !method.getName().endsWith("Class")
							&& !method.getName().endsWith("Repos") && !method.getName().endsWith("Branchs")
							&& !method.getName().endsWith("Contributors")) {
						System.out.println(method.getName().substring(3) + ":\t" + method.invoke(ghi.githubRepo, repo));
					}
				}
				System.out.println("----------------------------------------");
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
