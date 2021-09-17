package com.cognizant.QuizAttemptDetail;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.QuizAttemptDetail.Model.Attempt;
import com.cognizant.QuizAttemptDetail.Model.Options;
import com.cognizant.QuizAttemptDetail.Model.Question;
import com.cognizant.QuizAttemptDetail.Model.User;
import com.cognizant.QuizAttemptDetail.Service.AttemptService;
import com.cognizant.QuizAttemptDetail.Service.OptionsService;
import com.cognizant.QuizAttemptDetail.Service.QuestionService;
import com.cognizant.QuizAttemptDetail.Service.UserService;
import com.cognizant.QuizAttemptDetail.util.DateUtil;

@SpringBootApplication
public class OrmLearnApplication {
	private static QuestionService questionService;
	private static OptionsService optionsService;
	private static AttemptService attemptService;
	private static UserService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static void testAddOneQuestionManyOptions() {
		Question question1 = new Question("What is the extension of the hyper text markup language file?", 1.0);
		Options option1 = new Options(".xhtm", false, 0.0);
		Options option2 = new Options(".ht", false, 0.0);
		Options option3 = new Options(".html", true, 1.0);
		Options option4 = new Options(".htmx", false, 0.0);
		Set<Options> optionSet1 = new HashSet<Options>();
		optionSet1.add(option1);
		optionSet1.add(option2);
		optionSet1.add(option3);
		optionSet1.add(option4);
		question1.setOptionSet(optionSet1);
		questionService.save(question1);

		Question question2 = new Question("What is the maximum level of heading tag can be used in a HTML page?", 1.0);
		Options option5 = new Options("5", false, 0.0);
		Options option6 = new Options("3", false, 0.0);
		Options option7 = new Options("4", false, 0.0);
		Options option8 = new Options("6", true, 1.0);
		Set<Options> optionSet2 = new HashSet<Options>();
		optionSet2.add(option5);
		optionSet2.add(option6);
		optionSet2.add(option7);
		optionSet2.add(option8);
		question2.setOptionSet(optionSet2);
		questionService.save(question2);

		Question question3 = new Question(
				"The HTML document itself begins with <html> and ends </html>. State True of False", 1.0);
		Options option9 = new Options("false", false, 0.0);
		Options option10 = new Options("true", true, 1.0);
		Set<Options> optionSet3 = new HashSet<Options>();
		optionSet3.add(option9);
		optionSet3.add(option10);
		question3.setOptionSet(optionSet3);
		questionService.save(question3);

		Question question4 = new Question("Choose the right option to store text value value in a variable.", 0.5);
		Options option11 = new Options("\'John\'", true, 0.5);
		Options option12 = new Options("John", false, 0.0);
		Options option13 = new Options("\"John\"", false, 0.0);
		Options option14 = new Options("/John/", false, 0.0);
		Set<Options> optionSet4 = new HashSet<Options>();
		optionSet4.add(option11);
		optionSet4.add(option12);
		optionSet4.add(option13);
		optionSet4.add(option14);
		question4.setOptionSet(optionSet4);
		questionService.save(question4);

	}

	private static void testAddUser() {
		LOGGER.info("Start");
		User user1 = new User("Harsh");
		userService.save(user1);
		LOGGER.debug("User1:{}", user1);
		User user2 = new User("Riya");
		userService.save(user2);
		LOGGER.debug("User2:{}", user2);
		User user3 = new User("Prerna");
		userService.save(user3);
		LOGGER.debug("User3:{}", user3);
		User user4 = new User("Jazz");
		userService.save(user4);
		LOGGER.debug("User4:{}", user4);

	}

	private static void testAddOneUserManyAttempt() {
		User user1 = userService.getById(19);

		Question question1 = questionService.getById(1);
		Question question2 = questionService.getById(6);
		Question question3 = questionService.getById(11);
		Question question4 = questionService.getById(14);
		Set<Question> questionSet = new HashSet<Question>();
		questionSet.add(question1);
		questionSet.add(question2);
		questionSet.add(question3);
		questionSet.add(question4);

		Options option1 = optionsService.getById(2);
		Options option2 = optionsService.getById(3);
		Options option3 = optionsService.getById(4);
		Options option4 = optionsService.getById(5);
		Options option5 = optionsService.getById(7);
		Options option6 = optionsService.getById(8);
		Options option7 = optionsService.getById(9);
		Options option8 = optionsService.getById(10);
		Options option9 = optionsService.getById(12);
		Options option10 = optionsService.getById(13);
		Options option11 = optionsService.getById(15);
		Options option12 = optionsService.getById(16);
		Options option13 = optionsService.getById(17);
		Options option14 = optionsService.getById(18);
		Set<Options> optionSet = new HashSet<Options>();
		optionSet.add(option1);
		optionSet.add(option2);
		optionSet.add(option3);
		optionSet.add(option4);
		optionSet.add(option5);
		optionSet.add(option6);
		optionSet.add(option7);
		optionSet.add(option8);
		optionSet.add(option9);
		optionSet.add(option10);
		optionSet.add(option11);
		optionSet.add(option12);
		optionSet.add(option13);
		optionSet.add(option14);

		Attempt attempt1 = new Attempt(DateUtil.convertToDate("2020-06-10"));
		Attempt attempt2 = new Attempt(DateUtil.convertToDate("2020-07-05"));
		attempt1.setUser(user1);
		attempt1.setQuestionSet(questionSet);
		attempt1.setOptionSet(optionSet);
		attempt2.setUser(user1);
		attempt2.setQuestionSet(questionSet);
		attempt2.setOptionSet(optionSet);

		attemptService.save(attempt1);
		attemptService.save(attempt2);

		User user2 = userService.getById(20);
		Attempt attempt3 = new Attempt(DateUtil.convertToDate("2020-06-10"));
		Attempt attempt4 = new Attempt(DateUtil.convertToDate("2020-07-05"));
		attempt3.setUser(user2);
		attempt3.setQuestionSet(questionSet);
		attempt3.setOptionSet(optionSet);
		attempt4.setUser(user2);
		attempt4.setQuestionSet(questionSet);
		attempt4.setOptionSet(optionSet);
		attemptService.save(attempt3);
		attemptService.save(attempt4);
	}

	private static void testGetAttemptDetails(int userId, int attemptId) {
		LOGGER.info("Start");
		Attempt attempt = attemptService.getAttempt(userId, attemptId);
		LOGGER.debug("Attempt:{}", attempt);
		LOGGER.info("End");
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		questionService = context.getBean(QuestionService.class);
		optionsService = context.getBean(OptionsService.class);
		attemptService = context.getBean(AttemptService.class);
		userService = context.getBean(UserService.class);

		// testAddOneQuestionManyOptions();
		// testAddUser();
		// testAddOneUserManyAttempt();
		// testGetAttemptDetails(19, 31);
		 boolean[] a = testTakeAttempt();
		 testShowAttemptDetails(a);

	}

	private static void testShowAttemptDetails(boolean[] a) {
		System.out.println("What is the extension of the hyper text markup language file?\n" + "1) .xhtm	0.0		"
				+ a[0] + "\n" + "2) .ht 		0.0		" + a[1] + "\n" + "3) .html	1.0		" + a[2] + "\n"
				+ "4) .htmx	0.0		" + a[3]);
		System.out.println("What is the maximum level of heading tag can be used in a HTML page?\n"
				+ "1) 5		0.0		" + a[4] + "\n" + "2) 3 		0.0		" + a[5] + "\n" + "3) 4		0.0		" + a[6]
				+ "\n" + "4) 6		1.0		" + a[7]);
		System.out.println("The HTML document itself begins with <html> and ends </html>. State True of False.\n"
				+ "1) false	0.0		" + a[8] + "\n" + "2) true 	1.0		" + a[9]);
		System.out.println("Choose the right option to store text value value in a variable.\n"
				+ "1) 'John'	0.5		" + a[10] + "\n" + "2) John		0.0		" + a[11] + "\n"
				+ "3) \"John\"	0.5		" + a[12] + "\n" + "4) /John/	0.0		" + a[13]);

	}

	private static boolean[] testTakeAttempt() {
		Scanner scanner = new Scanner(System.in);
		boolean a[] = new boolean[14];
		System.out.println("What is the extension of the hyper text markup language file?\n"
				+ "1) .xhtm \n2) .ht \n3) .html \n4).htmx");
		int ans1 = scanner.nextInt();

		if (ans1 == 1) {
			a[0] = true;
		} else {
			a[0] = false;
		}
		if (ans1 == 2) {
			a[1] = true;
		} else {
			a[1] = false;
		}
		if (ans1 == 3) {
			a[2] = true;
		} else {
			a[2] = false;
		}
		if (ans1 == 4) {
			a[3] = true;
		} else {
			a[3] = false;
		}

		System.out.println(
				"What is the maximum level of heading tag can be used in a HTML page?\n" + "1) 5 \n2) 3 \n3) 4 \n4) 6");
		int ans2 = scanner.nextInt();

		if (ans2 == 1) {
			a[4] = true;
		} else {
			a[4] = false;
		}
		if (ans2 == 2) {
			a[5] = true;
		} else {
			a[5] = false;
		}
		if (ans2 == 3) {
			a[6] = true;
		} else {
			a[6] = false;
		}
		if (ans2 == 4) {
			a[7] = true;
		} else {
			a[7] = false;
		}

		System.out.println("The HTML document itself begins with <html> and ends </html>. State True of False.\n"
				+ "1) false \n2) true");
		int ans3 = scanner.nextInt();

		if (ans3 == 1) {
			a[8] = true;
		} else {
			a[8] = false;
		}
		if (ans3 == 2) {
			a[9] = true;
		} else {
			a[9] = false;
		}

		System.out.println("Choose the right option to store text value value in a variable.\n"
				+ "1) 'John' \n2) John \n3) \"John\" \n4) /John/");
		int ans4 = scanner.nextInt();

		if (ans4 == 1) {
			a[10] = true;
		} else {
			a[10] = false;
		}
		if (ans4 == 2) {
			a[11] = true;
		} else {
			a[11] = false;
		}
		if (ans4 == 3) {
			a[12] = true;
		} else {
			a[12] = false;
		}
		if (ans4 == 4) {
			a[13] = true;
		} else {
			a[13] = false;
		}

		return a;

	}

}
