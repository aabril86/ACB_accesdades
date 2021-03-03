import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PlayerController {

	private Connection connection;
	private Scanner scanner = new Scanner(System.in);
	
	public PlayerController(Connection c) {
		this.connection = connection;
	}

	public void addPlayer() throws SQLException {
		//TODO ARREGLAR ESTO

		Statement st = connection.createStatement();

		String name, last_name, bdate, gender, tname;
		int fcode ,height, mvp;

		System.out.print("Federation licence code: ");
		fcode = scanner.nextInt();
		scanner.nextLine();
		System.out.print("First name");
		name = scanner.nextLine();
		System.out.print("Last name: ");
		last_name = scanner.nextLine();
		System.out.print("Birthday: ");
		bdate = scanner.nextLine();
		System.out.print("Gender: ");
		gender = scanner.nextLine();
		System.out.println("Height: ");
		height = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Team name: ");
		tname = scanner.nextLine();
		System.out.println("Total mvp: ");
		mvp = scanner.nextInt();

		st.executeUpdate("NSERT INTO player (federation_license_code, first_name, last_name, birth_date, gender, height, team_name, mvp_total) VALUES ('" + fcode + "','" + name + "','" + last_name + "','" + bdate + "','" + gender + "','" + height +"','" + tname + "','" + mvp + "')");
	}

}
