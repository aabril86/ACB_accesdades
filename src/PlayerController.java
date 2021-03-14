import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PlayerController {

	private Connection connection;
	private Scanner scanner = new Scanner(System.in);
	
	public PlayerController(Connection c) {
		this.connection = c;
	}

	public void addPlayer() throws SQLException {
		//TODO ARREGLAR ESTO

		Statement st = connection.createStatement();

		String name, last_name, bdate, gender, tname;
		int fcode ,height, mvp;

		System.out.print("Federation licence code: ");
		fcode = scanner.nextInt();
		scanner.nextLine();
		System.out.print("First name: ");
		name = scanner.nextLine();
		System.out.print("Last name: ");
		last_name = scanner.nextLine();
		System.out.print("Birthday: ");
		bdate = scanner.nextLine();
		System.out.print("Gender: ");
		gender = scanner.nextLine();
		System.out.print("Height: ");
		height = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Team name: ");
		tname = scanner.nextLine();
		System.out.print("Total mvp: ");
		mvp = scanner.nextInt();

		st.executeUpdate("INSERT INTO player (federation_license_code, first_name, last_name, birth_date, gender, height, team_name, mvp_total) VALUES ('" + fcode + "','" + name + "','" + last_name + "','" + bdate + "','" + gender + "','" + height +"','" + tname + "','" + mvp + "')");

		st.close();
	}

	public void showPlayersNoTeam() throws SQLException{

		Statement st = connection.createStatement();
		ResultSet rs;

		rs = st.executeQuery("SELECT first_name, last_name FROM player WHERE team_name IS NULL");

		while(rs.next()){
			System.out.println("Name: " + rs.getString("first_name") + " " +
					rs.getString("last_name"));
		}

		rs.close();
		st.close();
		try{
			Thread.sleep(1000);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void assignPlayer() throws SQLException {
		Scanner scanner = new Scanner(System.in);

		Statement st = connection.createStatement();
		System.out.print("Federation license code: ");
		String code = scanner.nextLine();
		//scanner.nextLine();
		System.out.print("Assigned team: ");
		String team = scanner.nextLine();

		st.executeUpdate("UPDATE player SET team_name = '" + team + "' WHERE federation_license_code = '" + code + "'");
		st.close();
	}

	public void detatchTeam() throws SQLException {
		Scanner scanner = new Scanner(System.in);

		Statement st = connection.createStatement();
		System.out.print("Federation license code: ");
		String code = scanner.nextLine();

		st.executeUpdate("UPDATE player SET team_name = NULL WHERE federation_license_code = '" + "'");
		st.close();
	}

}
