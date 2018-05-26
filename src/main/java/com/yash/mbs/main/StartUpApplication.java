package com.yash.mbs.main;

import java.util.Scanner;

import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.service.ScreenService;
import com.yash.mbs.serviceimpl.ScreenServiceImpl;
import com.yash.mbs.util.MenuUtil;

public class StartUpApplication {

	public static void main(String[] args) {
		int choice;
		String continueChoice;
		Scanner scanner = new Scanner(System.in);
		ScreenService screenService = new ScreenServiceImpl();
		do {
			
			MenuUtil menuUtil = new MenuUtil();
			menuUtil.readFile("menu.txt");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Screen screen = new Screen();
				System.out.println("Enter screen id:");
				Integer screenId = scanner.nextInt();
				screen.setId(screenId);
				System.out.println("Enter screen name:");
				String name = scanner.next();
				screen.setName(name);
				screenService.addScreen(screen);
				break;
			case 2:
				Movie movie = new Movie();
				System.out.println("Enter screen name:");
				String screenName = scanner.next();
				System.out.println("Enter movie id:");
				Integer movieId = scanner.nextInt();
				movie.setId(movieId);
				System.out.println("Enter movie title:");
				scanner.nextLine();
				String movieTitle = scanner.nextLine();
				movie.setTitle(movieTitle);
				System.out.println("Enter movie production:");
				String production = scanner.nextLine();
				movie.setProduction(production);
				System.out.println("Enter actor:");
				String actor = scanner.nextLine();
				movie.setActor(actor);
				screenService.addMovieToScreen(screenName, movie);
			default:
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equalsIgnoreCase("yes"));
		scanner.close();
	}

}
