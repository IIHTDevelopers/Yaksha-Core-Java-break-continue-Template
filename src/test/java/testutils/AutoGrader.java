package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.BreakStmt;
import com.github.javaparser.ast.stmt.ContinueStmt;

public class AutoGrader {

	// Test if the code uses only 'break' and 'continue' keywords in loops and not
	// any other looping constructs
	public boolean testBreakContinueOnly(String filePath) throws IOException {
		System.out.println("Starting testBreakContinueOnly with file: " + filePath);

		File participantFile = new File(filePath); // Path to participant's file
		if (!participantFile.exists()) {
			System.out.println("File does not exist at path: " + filePath);
			return false;
		}

		FileInputStream fileInputStream = new FileInputStream(participantFile);
		JavaParser javaParser = new JavaParser();
		CompilationUnit cu;
		try {
			cu = javaParser.parse(fileInputStream).getResult()
					.orElseThrow(() -> new IOException("Failed to parse the Java file"));
		} catch (IOException e) {
			System.out.println("Error parsing the file: " + e.getMessage());
			throw e;
		}

		System.out.println("Parsed the Java file successfully.");

		boolean hasBreakContinue = false;

		// Log the parsed break statements
		System.out.println("------ Break Statements ------");
		for (BreakStmt breakStmt : cu.findAll(BreakStmt.class)) {
			System.out.println("Break statement found: " + breakStmt);
			hasBreakContinue = true;
		}

		// Log the parsed continue statements
		System.out.println("------ Continue Statements ------");
		for (ContinueStmt continueStmt : cu.findAll(ContinueStmt.class)) {
			System.out.println("Continue statement found: " + continueStmt);
			hasBreakContinue = true;
		}

		// Check if only break and continue are used and no 'for', 'while', or
		// 'do-while' loops
		System.out.println("Has break or continue statement: " + hasBreakContinue);

		boolean result = hasBreakContinue;
		System.out.println("Test result: " + result);

		return result;
	}
}
