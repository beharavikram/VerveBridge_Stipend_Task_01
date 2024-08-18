import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LMS {
	static Map<String, User> users = new HashMap<>();
	static Map<String, Course> courses = new HashMap<>();
	static User currentUser;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. Sign Up\n2. Login\n3. Admin Dashboard\n4. Exit");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				signUp(scanner);
				break;
			case 2:
				login(scanner);
				break;
			case 3:
				if (currentUser != null && currentUser.isAdmin) {
					adminDashboard(scanner);
				} else {
					System.out.println("Access denied. Admins only.");
				}
				break;
			case 4:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void signUp(Scanner scanner) {
		System.out.print("Enter username: ");
		String username = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();
		System.out.print("Enter payment status (true if paid): ");
		boolean paid = scanner.nextBoolean();
		scanner.nextLine(); // Consume newline

		if (paid) {
			users.put(username, new User(username, password, true));
			System.out.println("Sign-up successful. Admin access granted.");
		} else {
			System.out.println("Payment required for access.");
		}
	}

	private static void login(Scanner scanner) {
		System.out.print("Enter username: ");
		String username = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		User user = users.get(username);
		if (user != null && user.password.equals(password)) {
			currentUser = user;
			System.out.println("Login successful.");
		} else {
			System.out.println("Invalid credentials.");
		}
	}

	private static void adminDashboard(Scanner scanner) {
		while (true) {
			System.out.println("1. Create Course\n2. Manage Courses\n3. Logout");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				createCourse(scanner);
				break;
			case 2:
				manageCourses(scanner);
				break;
			case 3:
				currentUser = null;
				System.out.println("Logged out.");
				return;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void createCourse(Scanner scanner) {
		System.out.print("Enter course name: ");
		String courseName = scanner.nextLine();
		System.out.print("Enter course content: ");
		String content = scanner.nextLine();

		courses.put(courseName, new Course(courseName, content));
		System.out.println("Course created successfully.");
	}

	private static void manageCourses(Scanner scanner) {
		System.out.println("Courses available:");
		for (String courseName : courses.keySet()) {
			System.out.println(courseName);
		}
		System.out.print("Enter course name to delete or 'back' to go back: ");
		String courseName = scanner.nextLine();

		if (courseName.equals("back")) {
			return;
		}

		if (courses.containsKey(courseName)) {
			courses.remove(courseName);
			System.out.println("Course deleted.");
		} else {
			System.out.println("Course not found.");
		}
	}

	static class User {
		String username;
		String password;
		boolean isAdmin;

		User(String username, String password, boolean isAdmin) {
			this.username = username;
			this.password = password;
			this.isAdmin = isAdmin;
		}
	}

	static class Course {
		String name;
		String content;

		Course(String name, String content) {
			this.name = name;
			this.content = content;
		}
	}
}
