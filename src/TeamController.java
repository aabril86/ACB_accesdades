
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TeamController {

	private Connection connection;

	public TeamController(Connection connection) {
		this.connection = connection;
	}

	public void showTeams() throws SQLException, IOException {

		Statement st = connection.createStatement();
		ResultSet rs;

		rs = st.executeQuery("SELECT * FROM team");
		while (rs.next()) {
			System.out.println("Name: " + rs.getString("name") + " " +
							   "Type: " + rs.getString("type") + " " +
							   "Country: " + rs.getString("country") + " " +
							   "City: " + rs.getString("city") + " " +
							   "Court name: " + rs.getString("court_name"));
		}

		rs.close();
		st.close();
	}

	public void showPlayers() throws SQLException, IOException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Team name: ");
		String teamName = scanner.nextLine();

		Statement st = connection.createStatement();
		ResultSet rs;

		rs = st.executeQuery("SELECT first_name, last_name  FROM player WHERE team_name = '" + teamName + "'" );

		while (rs.next()){
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

	public void addTeam() throws SQLException, IOException {
		Scanner scanner = new Scanner(System.in);

		Statement st = connection.createStatement();

		String name, type, country, city, cname;
		System.out.print("Name: ");
		name = scanner.nextLine();
		System.out.print("Type: ");
		type = scanner.nextLine();
		System.out.print("Country: ");
		country = scanner.nextLine();
		System.out.print("City: ");
		city = scanner.nextLine();
		System.out.print("Court name: ");
		cname = scanner.nextLine();

		st.executeUpdate("Insert into TEAM (NAME,TYPE,COUNTRY,CITY,COURT_NAME) values ('" + name + "','" + type + "','" + country + "','" + city + "','" + cname + "')");

	}


}
